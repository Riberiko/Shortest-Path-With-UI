package App.UI;

import java.awt.*;
import java.util.Map;

public class GraphUI extends UI{

    Button solve;

    public GraphUI(int contentWidth, int contentHeight) {
        super(contentWidth, contentHeight, 740,20);

        solve = new Button((int)(getContentWidth()*0.9),getContentHeight()/10,(int) (contentWidth*0.05),(int) (contentHeight*0.9)-10);

        initiate();
    }

    private void initiate(){
        Graphics2D g = image.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getContentWidth(), getContentHeight());
        g.setColor(Color.YELLOW);
        g.fillRect(1,1,getContentWidth()-2,getContentHeight()-2);
        g.setColor(Color.BLACK);
        g.setFont(new Font(g.getFont().toString(), Font.BOLD, getContentWidth()/8));
        g.addRenderingHints((Map) Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints"));
        fontMetrics = g.getFontMetrics();
        g.drawString("Option UI", getContentWidth()/2 - fontMetrics.stringWidth("Option UI")/2,getContentHeight()/12);

        g.setColor(Color.RED);
        g.drawImage(solve.getImage(), solve.getX(), solve.getY(), null);
    }
}
