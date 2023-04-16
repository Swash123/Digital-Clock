package TitleBarCustom;

import Clock.Clock_Frame;
import Clock.Clock_Panel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buttont extends JButton {

    Clock_Panel clock_panel = new Clock_Panel();

    public Color getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }

    private Animator animator;
    private boolean mouseOver;
    private float animate;
    private Color hoverColor = new Color(100, 100, 100);

    public Buttont() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
//        setBackground(new Color(50, 50, 50));
        setBorder(new EmptyBorder(0, 0, 0, 0));
//        setContentAreaFilled(false);
        setFocusable(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                mouseOver = true;
                stopAnimation();
                animator.start();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                mouseOver = false;
                stopAnimation();
                animator.start();
            }
        });
        animator = new Animator(300, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                fraction *= 0.5f;
                if (mouseOver) {
                    animate = fraction;
                } else {
                    animate = 0.5f - fraction;
                }
                repaint();
            }
        });
        animator.setResolution(0);
    }

    private void stopAnimation() {
        if (animator.isRunning()) {
            float f = animator.getTimingFraction();
            animator.stop();
            animator.setStartFraction(1f - f);
        } else {
            animator.setStartFraction(0f);
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, animate));
        g2.setColor(hoverColor);
        g2.fillRect(0, 0, width, height);
        g2.dispose();
        super.paintComponent(grphcs);
    }
}
