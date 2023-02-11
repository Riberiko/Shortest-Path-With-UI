package App;

import App.UI.Button;
import App.UI.EscapeUI;
import App.UI.GraphUI;

import Frame.FrameManager;

import javax.swing.*;
import java.awt.*;

public class Renderer {

    int[] pixels;
    JFrame currentFrame;

    EscapeUI escapeUI;
    GraphUI graphUI;


    private boolean isEscape;
    private boolean isGraphUI;

    public Renderer(){
        isEscape = false;
        isGraphUI = true;
    }

    public void initiate(){
        escapeUI = new EscapeUI(currentFrame.getWidth()/2, currentFrame.getHeight()/2);
        graphUI = new GraphUI(currentFrame.getWidth()/4, currentFrame.getHeight());
    }



    public void render(Graphics2D g){
        for(int i = 0; i < pixels.length; i++) pixels[i] = -1;
        if(pixels == null) return;

        renderUI(g);
    }

    public void changeEscapeState(){
        if(isEscape) isEscape = false;
        else isEscape = true;
    }

    public void changeGraphUIState(){
        if(isGraphUI) isGraphUI = false;
        else isGraphUI = true;
    }

    public void setCurrentFrame(JFrame currentFrame){
        this.currentFrame = currentFrame;
        initiate();
    }

    private void renderUI(Graphics2D g){

        if (isGraphUI) g.drawImage(graphUI.getImage(),(int) (currentFrame.getWidth()*0.75)-10, 10, graphUI.getContentWidth()-10, graphUI.getContentHeight()-20, null);

        if (isEscape) g.drawImage(escapeUI.getImage(), currentFrame.getWidth()/4, currentFrame.getHeight()/4, currentFrame.getWidth()/2, currentFrame.getHeight()/2, null);

    }

    public void setPixels(int[] pixels){
        this.pixels = pixels;
    }

}
