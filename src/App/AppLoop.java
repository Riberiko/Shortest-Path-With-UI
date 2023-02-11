package App;

import Frame.FrameManager;

import javax.swing.*;

public class AppLoop implements Runnable{

    private final short FPS = 60;
    private final short UPS = 60;

    private final short FPSTarget = 1000/FPS;
    private final short UPSTarget = 1000/UPS;

    private JFrame currentFrame;

    private boolean changingFrame = false;

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long secondCounter = startTime;

        short actualFPS = 0;
        long curTime = 0;

        long FPSTime = startTime;
        long FPSDelta = 0;

        long UPSTime = startTime;
        long UPSDelta = 0;

        while(true){

            curTime = System.currentTimeMillis();
            FPSDelta += curTime - FPSTime;
            FPSTime = curTime;

            UPSDelta += curTime - UPSTime;
            UPSTime = curTime;

            if(!changingFrame && currentFrame != null && FPSDelta >= FPSTarget){
                FPSDelta = 0;
                currentFrame.repaint();
                actualFPS++;
            }

            if(UPSDelta >= UPSTarget){
                update(UPSDelta);
                UPSDelta = 0;
            }

            if((curTime-secondCounter)/1000 >= 1){
                secondCounter = System.currentTimeMillis();
                System.out.println("FPS: "+actualFPS);
                actualFPS = 0;
            }

        }

    }

    public void update(long deltaTime){

    }

    public void setCurrentFrame(JFrame currentFrame){
        this.currentFrame = currentFrame;
    }

    public void setChangingFrame(boolean state){
        changingFrame = state;
    }

}
