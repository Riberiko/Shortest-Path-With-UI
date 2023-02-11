package App.Controllers;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController {

    private JFrame currentFrame;
    private MouseListener mouseListener;

    public MouseController(){
        mouseListener = new MouseListener();
    }

    public MouseListener getMouseListener(){
        return mouseListener;
    }

    class MouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getPoint());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
