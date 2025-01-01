import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

class TextBannerProgram extends JFrame  implements Runnable {
    Thread th; Date d = new Date();
    JLabel timeLabel = new JLabel();

    public TextBannerProgram(){
        this.setTitle("Date & Time Frame Application");
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setText(d.toString());
        this.add(timeLabel,BorderLayout.CENTER);
        th = new Thread(this);
        th.start();
    }

    public void run(){
        while(true){
            d = new Date();
            timeLabel.setText(d.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } 
}
 

public class TextBanner {
    public static void main(String[] args) {
        TextBannerProgram app = new TextBannerProgram();
        app.setBounds(50,50,600,400);    
        app.setVisible(true);
    }
}