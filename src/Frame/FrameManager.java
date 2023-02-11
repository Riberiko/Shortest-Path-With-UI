package Frame;

import App.AppLoop;
import App.Controllers.KeyController;
import App.Controllers.MouseController;
import App.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class FrameManager {

    private static String title;

    private JFrame currentFrame;

    private Renderer renderer;

    private KeyController keyController;
    private MouseController mouseController;

    private boolean isFullScreen;

    public static final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

    BufferedImage image;
    private int[] pixels;

    BufferStrategy bs;

    AppLoop loop;

    public FrameManager(String title){
        this.title = title;
        renderer = new Renderer();
        currentFrame = new MinFrame(title);
        renderer.setCurrentFrame(currentFrame);
        image = new BufferedImage( (int) currentFrame.getWidth(), (int) currentFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) (image.getRaster().getDataBuffer())).getData();
        renderer.setPixels(pixels);
        isFullScreen = false;
        currentFrame.toFront();
    }

    public void setKeyController(KeyController keyController){
        this.keyController = keyController;
        currentFrame.addKeyListener(keyController.getKeyListener());
    }

    public void setMouseController(MouseController mouseController){
        this.mouseController = mouseController;
        currentFrame.addMouseListener(mouseController.getMouseListener());
    }

    public JFrame getCurrentFrame(){
        return currentFrame;
    }

    public void setLoop(AppLoop loop){
        this.loop = loop;
    }

    public void changeState(){
        loop.setChangingFrame(true);
        System.out.println("Changing Frame");
        if(!isFullScreen){
            currentFrame.dispose();
            currentFrame = new MaxFrame(title);
            currentFrame.toFront();
            isFullScreen = true;
        }
        else{
            currentFrame.dispose();
            currentFrame = new MinFrame(title);
            currentFrame.toFront();
            isFullScreen = false;
        }
        bs = null;
        loop.setChangingFrame(false);
        renderer.setCurrentFrame(currentFrame);

        image = new BufferedImage( (int) currentFrame.getWidth(), (int) currentFrame.getHeight(), BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) (image.getRaster().getDataBuffer())).getData();
        renderer.setPixels(pixels);

        currentFrame.addKeyListener(keyController.getKeyListener());
        currentFrame.addMouseListener(mouseController.getMouseListener());
    }

    public void render(){
        if(bs == null){
            currentFrame.createBufferStrategy(2);
            bs = currentFrame.getBufferStrategy();
            return;
        }
        Graphics2D g =(Graphics2D) bs.getDrawGraphics();

        renderer.render(image.createGraphics());

        g.drawImage(image, 0, 0,currentFrame.getWidth(), currentFrame.getHeight(), null);
        g.dispose();
        bs.show();
    }

    public Renderer getRenderer(){
        return renderer;
    }



    private class MinFrame extends JFrame{

        public MinFrame(String title){
            setTitle(title);
            setUndecorated(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setPreferredSize(new Dimension((int) screenDimension.getWidth()/2, (int) screenDimension.getHeight()/2));
            pack();
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        @Override
        public void repaint(){
            render();
        }


    }

    private class MaxFrame extends JFrame{

        public MaxFrame(String title){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setResizable(false);
            setUndecorated(true);
            setVisible(true);
        }

        @Override
        public void repaint(){
            render();
        }

    }


}
