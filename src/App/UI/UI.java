package App.UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public abstract class UI implements UIInterface{

    private Spacing margin;
    private Spacing padding;

    protected BufferedImage image;
    protected int[] pixels;

    private int contentWidth;
    private int contentHeight;

    private Point topLeft;

    protected Font font;

    protected FontMetrics fontMetrics;

    public UI(int contentWidth, int contentHeight, int x, int y){
        this.contentWidth = contentWidth;
        this.contentHeight = contentHeight;

        image = new BufferedImage(contentWidth, contentHeight, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)(image.getRaster().getDataBuffer())).getData();

        topLeft = new Point(x,y);
    }

    public int getContentWidth() {
        return contentWidth;
    }

    public void setContentWidth(int contentWidth) {
        this.contentWidth = contentWidth;
    }

    public int getContentHeight() {
        return contentHeight;
    }

    public void setContentHeight(int contentHeight) {
        this.contentHeight = contentHeight;
    }

    public int[] getPixels(){
        return pixels;
    }

    public BufferedImage getImage(){
        return image;
    }

    public int getX(){
        return (int) topLeft.getX();
    }

    public int getY(){
        return (int) topLeft.getY();
    }
}
