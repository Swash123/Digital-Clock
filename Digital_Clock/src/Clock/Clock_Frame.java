package Clock;

import TitleBarCustom.SimpleButtonBar;
import swingacrylic.SwingAcrylic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock_Frame extends JFrame {

    static Clock_Panel clock_panel;

    private TitleBar tb;

    private SimpleButtonBar button;


    public static Clock_Panel getClock_panel() {
        return clock_panel;
    }

    public SimpleButtonBar getButton() {
        return button;
    }

    Clock_Frame(){
        tb = new TitleBar();

        clock_panel=new Clock_Panel();

        button = new SimpleButtonBar();

        button.initEvent(this);
        button.setOpaque(false);
        button.setBackground(Color.blue);
        button.setPreferredSize(new Dimension(105,tb.getHeight()));

        tb.setLayout(new BorderLayout());
        tb.setPreferredSize(new Dimension(this.getWidth(),50));
        tb.add(button, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(tb,BorderLayout.NORTH);
        add(clock_panel,BorderLayout.CENTER);
        setUndecorated(true);
        setSize(350,250);
        setVisible(true);
        setLocationRelativeTo(null);

        Timer timer=new Timer(1000,e->updateTime());
        timer.start();

    }

    private void updateTime() {
        SimpleDateFormat timeFormat=new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dayFormat=new SimpleDateFormat("EEEE");
        SimpleDateFormat dateFormat=new SimpleDateFormat("MMMMM dd, yyyy");
        String time;
        String day;
        String date;

        time=timeFormat.format(Calendar.getInstance().getTime());
        clock_panel.getLblTime().setText(time);
        day=dayFormat.format(Calendar.getInstance().getTime());
        clock_panel.getLblDay().setText(day);
        date=dateFormat.format(Calendar.getInstance().getTime());
        clock_panel.getLblDate().setText(date);
    }


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try{
                    for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                        if("Nimbus".equals(info.getName())){
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                }catch (Exception exp){
                    System.out.println(exp);
                }
                SwingAcrylic.prepareSwing();
                Clock_Frame fram = new Clock_Frame();
                SwingAcrylic.processFrame(fram);
                    SwingAcrylic.prepareSwing();
                    SwingAcrylic.processFrame(fram);
            }
        });
    }
}
