import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;

public class Ball extends JFrame {
    public Ball() {
        setTitle("Animation Ball Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new BallPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ball app = new Ball();
            app.setBounds(50, 50, 600, 400);
            app.setVisible(true);
        });
    }
}

class BallPanel extends JPanel implements Runnable {
    private double ballX = 100;
    private double ballY = 100;
    private int ballSize = 50;
    private double dx = 3;
    private double dy = 3;
    private Thread animationThread;
    private final int DELAY = 16;
    private BufferedImage ballImage;

    public BallPanel() {
        setBackground(Color.WHITE);
        loadBallImage();
        setPreferredSize(new Dimension(600, 400));
        animationThread = new Thread(this);
        animationThread.start();
    }

    private void loadBallImage() {
        try {
            ballImage = ImageIO.read(new File("ball.png"));
            ballSize = Math.max(ballImage.getWidth(), ballImage.getHeight());
        } catch (Exception e) {
            System.err.println("Error loading ball image: " + e.getMessage());
            ballImage = createDefaultBallImage();
        }
    }

    private BufferedImage createDefaultBallImage() {
        BufferedImage defaultImage = new BufferedImage(ballSize, ballSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = defaultImage.createGraphics();
        g2.setColor(Color.RED);
        g2.fillOval(0, 0, ballSize, ballSize);
        g2.dispose();
        return defaultImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(ballImage, (int)ballX, (int)ballY, ballSize, ballSize, null);
    }

    private void moveBall() {
        ballX += dx;
        ballY += dy;

        if (ballX <= 0) {
            ballX = 0;
            dx = Math.abs(dx);
            changeDirection();
        } else if (ballX >= getWidth() - ballSize) {
            ballX = getWidth() - ballSize;
            dx = -Math.abs(dx);
            changeDirection();
        }

        if (ballY <= 0) {
            ballY = 0;
            dy = Math.abs(dy);
            changeDirection();
        } else if (ballY >= getHeight() - ballSize) {
            ballY = getHeight() - ballSize;
            dy = -Math.abs(dy);
            changeDirection();
        }
    }

    private void changeDirection() {
        Random rand = new Random();
        dx += (rand.nextDouble() - 0.5) * 0.5;
        dy += (rand.nextDouble() - 0.5) * 0.5;
        
        double speed = Math.sqrt(dx * dx + dy * dy);
        if (speed > 6) {
            dx = (dx / speed) * 6;
            dy = (dy / speed) * 6;
        } else if (speed < 2) {
            dx = (dx / speed) * 2;
            dy = (dy / speed) * 2;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                moveBall();
                repaint();
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}