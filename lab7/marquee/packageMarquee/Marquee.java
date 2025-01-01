package packageMarquee;

import javax.swing.*;
import java.awt.*;

public class Marquee extends JFrame implements Runnable {

    private Thread th;
    private final String str  = "Java is the best";
    private JLabel jLabel;
    private JFrame frame;
    private  int start = 0;

   public Marquee(){
       jLabel = new JLabel();
       this.setTitle("Banner Application");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        jLabel.setText(str);
        this.add(jLabel, BorderLayout.CENTER);
        th = new Thread(this);
        th.start();
    }


    @Override
    public void run() {
        while(true){
            try{
                jLabel.setBounds(start, 50, 100,40);
                start+=5;
                if(start == 600){
                    start = 0;
                }
                Thread.sleep(100);
            }catch(InterruptedException i){
                System.out.println(i.getMessage());
            }
        }

    }
}