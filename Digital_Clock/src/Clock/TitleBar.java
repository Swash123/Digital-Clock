package Clock;

import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {

    public float getTransparent() {
        return transparent;
    }

    public void setTransparent(float transparent) {
        this.transparent = transparent;
    }

    private float transparent = 0.5f;

    public TitleBar(){
        setOpaque(false);
        setBackground(new Color(255,255,255));
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(getBackground());
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,transparent));
        g2.fillRect(0,0,getWidth(),getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        super.paint(g);
    }


}
