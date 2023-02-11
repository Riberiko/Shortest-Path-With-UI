package App.UI;

import java.awt.*;

public class Button extends UI{
    public Button(int contentWidth, int contentHeight, int x, int y) {
        super(contentWidth, contentHeight, x, y);
    }

    private void initiate() {
        Graphics2D g = image.createGraphics();
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = i+255;
        }
    }
}
