package App.Controllers;

import Frame.FrameManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyController {

    FrameManager frame;

    HashMap<Integer, Boolean> keys;
    KeyListener listener;

    public KeyController(){
        keys = new HashMap<>();
        listener = new KeyListener();
    }

    public KeyListener getKeyListener(){
        return listener;
    }

    public void setFrame(FrameManager frame){
        this.frame = frame;
    }


    private class KeyListener extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            keys.put(e.getKeyCode(), true);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            keys.put(e.getKeyCode(), true);
            if(e.getKeyCode() == KeyEvent.VK_F11){
                frame.changeState();
            }

            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                frame.getRenderer().changeEscapeState();
            }

            if(e.getKeyCode() == KeyEvent.VK_F12){
                System.exit(0);
            }

            if(e.getKeyCode() == KeyEvent.VK_P){
                frame.getRenderer().changeGraphUIState();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            keys.replace(e.getKeyCode(), false);
        }
    }
}
