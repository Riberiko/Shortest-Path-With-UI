package App.UI;

import java.awt.*;
import java.util.Map;

public class EscapeUI extends UI{

    public EscapeUI(int contentWidth, int contentHeight) {
        super(contentWidth, contentHeight, 250,250);
        initiate();
    }

    private void initiate(){
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getContentWidth(), getContentHeight());
        g.setColor(Color.BLACK);
        g.fillRect(1,1,getContentWidth()-2, getContentHeight()-2);
        g.setColor(Color.WHITE);
        g.setFont(new Font(g.getFont().toString(), Font.BOLD, getContentWidth()/10));
        g.addRenderingHints((Map) Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints"));

        fontMetrics = g.getFontMetrics();
        g.drawString("MENU", getContentWidth()/2 - fontMetrics.stringWidth("MENU")/2,getContentHeight()/6);
    }


}
