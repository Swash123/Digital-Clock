package Clock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock_Panel extends JPanel {

    private float transparent = 0.5f;

    public boolean show=true;

    private  Calendar calendar;
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private  JLabel lblTime;
    private JLabel lblDay;
    private JLabel lblDate;
    private String time;
    private String day;
    private String date;

    public JLabel getLblDay() {
        return lblDay;
    }

    public void setLblDay(JLabel lblDay) {
        this.lblDay = lblDay;
    }

    public JLabel getLblDate() {
        return lblDate;
    }

    public void setLblDate(JLabel lblDate) {
        this.lblDate = lblDate;
    }

    public Clock_Panel(){
        timeFormat =new SimpleDateFormat("hh:mm:ss a");
        dayFormat=new SimpleDateFormat("EEEE");
        dateFormat=new SimpleDateFormat("MM dd, yyyy");
        lblTime =new JLabel();
        lblDay=new JLabel();
        lblDate=new JLabel();


        lblTime.setFont(new Font("Verdana",Font.PLAIN,50));
        lblTime.setForeground(new Color(0x00ff00));
        lblTime.setOpaque(false);

        lblDay.setFont(new Font("Ink Free",Font.PLAIN,35));

        lblDate.setFont(new Font("Ink Free",Font.PLAIN,35));

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(lblTime);
        this.add(lblDay);
        this.add(lblDate);
        this.setOpaque(false);
    }

    public JLabel getLblTime() {
        return lblTime;
    }

    public void setLblTime(JLabel lblTime) {
        this.lblTime = lblTime;
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
