package TitleBarCustom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class SimpleButtonBar extends JPanel {

    public SimpleButtonBar() {
        initComponents();
        setOpaque(false);
        cmdClose.setIcon(iconClose.toIcon());
        cmdResize.setIcon(iconRestore.toIcon());
        cmdMinimize.setIcon(iconMinimize.toIcon());
        cmdMinimize.setFont(cmdMinimize.getFont().deriveFont(0, 3));
    }

    public void initEvent(JFrame fram) {
        fram.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent we) {
                if (we.getNewState() == JFrame.MAXIMIZED_BOTH) {
                    cmdResize.setIcon(iconMax.toIcon());
                } else if (we.getNewState() == JFrame.NORMAL) {
                    cmdResize.setIcon(iconRestore.toIcon());
                }
            }
        });
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        cmdMinimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fram.setState(JFrame.ICONIFIED);
            }
        });
        cmdResize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (fram.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    fram.setExtendedState(JFrame.NORMAL);
                } else {
                    fram.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
            }
        });
    }

    public Buttont getCmdClose() {
        return cmdClose;
    }

    public Buttont getCmdMinimize() {
        return cmdMinimize;
    }

    public Buttont getCmdResize() {
        return cmdResize;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconClose = new javaswingdev.GoogleMaterialIcon();
        iconMax = new javaswingdev.GoogleMaterialIcon();
        iconMinimize = new javaswingdev.GoogleMaterialIcon();
        iconRestore = new javaswingdev.GoogleMaterialIcon();
        cmdClose = new Buttont();
        cmdResize = new Buttont();
        cmdMinimize = new Buttont();

        iconClose.setColor1(new Color(111, 111, 111));
        iconClose.setColor2(new Color(215, 215, 215));
        iconClose.setIcon(javaswingdev.GoogleMaterialDesignIcon.CLOSE);
        iconClose.setSize(18);

        iconMax.setColor1(new Color(16,19,72));
        iconMax.setColor2(new Color(16,19,72));
        iconMax.setIcon(javaswingdev.GoogleMaterialDesignIcon.CONTENT_COPY);
        iconMax.setSize(16);

        iconMinimize.setColor1(new Color(111, 111, 111));
        iconMinimize.setColor2(new Color(215, 215, 215));
        iconMinimize.setIcon(javaswingdev.GoogleMaterialDesignIcon.REMOVE);
        iconMinimize.setSize(18);

        iconRestore.setColor1(new Color(16,19,72));
        iconRestore.setColor2(new Color(16,19,72));
        iconRestore.setIcon(javaswingdev.GoogleMaterialDesignIcon.CROP_DIN);

        cmdClose.setHoverColor(new Color(255, 48, 48));
        cmdClose.setContentAreaFilled(false);

        cmdMinimize.setBorder(BorderFactory.createEmptyBorder(8, 1, 1, 1));
        cmdMinimize.setContentAreaFilled(false);
        cmdMinimize.setHoverColor(new Color(5, 19, 100));

        cmdResize.setHoverColor(new Color(16,19,72));

        cmdResize.setEnabled(false);
        cmdResize.setFocusable(false);
//        cmdResize.setBackground(new Color(16,19,72));
        cmdResize.setForeground(Color.WHITE);
        cmdResize.setContentAreaFilled(false);
        cmdResize.setEnabled(false);


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(cmdMinimize, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(cmdResize, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(cmdClose, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cmdClose, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(cmdResize, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(cmdMinimize, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Buttont cmdClose;
    private Buttont cmdMinimize;
    private Buttont cmdResize;
    private javaswingdev.GoogleMaterialIcon iconClose;
    private javaswingdev.GoogleMaterialIcon iconMax;
    private javaswingdev.GoogleMaterialIcon iconMinimize;
    private javaswingdev.GoogleMaterialIcon iconRestore;
    // End of variables declaration//GEN-END:variables
}
