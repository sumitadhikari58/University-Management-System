package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Splash extends JFrame implements Runnable {
    Thread t;
    JPanel topBar, bottomBar;
    
    Splash() {
        setUndecorated(true); // Remove default window borders
        setLayout(null);
        
        // Load and resize the splash image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/univ.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1000, 700);
        add(img);

        // Set rounded corners
        setShape(new RoundRectangle2D.Float(0, 0, 1000, 700, 30, 30)); 
        
        // Get screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int finalWidth = 1000, finalHeight = 700;
        int finalX = (screenSize.width - finalWidth) / 2;
        int finalY = (screenSize.height - finalHeight) / 2;

        setBounds(finalX, finalY, finalWidth, finalHeight);
        setOpacity(0f); // Start with invisible frame
        setVisible(true);

        // 🔥 Fade-in effect
        for (float i = 0; i <= 1; i += 0.05f) {
            setOpacity(i);
            try { Thread.sleep(50); } catch (Exception e) { e.printStackTrace(); }
        }

        // 🔥 Zoom-in effect
        for (int i = 0; i <= 20; i++) {
            img.setBounds(-i * 5, -i * 3, 1000 + i * 10, 700 + i * 6);
            repaint();
            try { Thread.sleep(50); } catch (Exception e) { e.printStackTrace(); }
        }

        // Stay for 2 seconds
        try { Thread.sleep(2000); } catch (Exception e) { e.printStackTrace(); }

        // 🔥 Camera shutter effect
        startCameraShutterEffect();
    }

    public void startCameraShutterEffect() {
        // Create top and bottom black bars
        topBar = new JPanel();
        bottomBar = new JPanel();
        
        topBar.setBackground(Color.BLACK);
        bottomBar.setBackground(Color.BLACK);

        // Initially off-screen
        topBar.setBounds(0, -350, 1000, 350);
        bottomBar.setBounds(0, 700, 1000, 350);

        add(topBar);
        add(bottomBar);
        repaint();

        // Animate bars to close like a camera shutter with bounce effect
        int speed = 10;
        for (int i = 0; i <= 350; i += 10) {
            topBar.setBounds(0, -350 + i, 1000, 350);
            bottomBar.setBounds(0, 700 - i, 1000, 350);
            repaint();
            try { Thread.sleep(speed); } catch (Exception e) { e.printStackTrace(); }
        }

        // Bounce effect
        for (int i = 0; i <= 20; i += 2) {
            topBar.setBounds(0, -350 + 350 + i, 1000, 350);
            bottomBar.setBounds(0, 700 - 350 - i, 1000, 350);
            repaint();
            try { Thread.sleep(speed); } catch (Exception e) { e.printStackTrace(); }
        }
        for (int i = 20; i >= 0; i -= 2) {
            topBar.setBounds(0, -350 + 350 + i, 1000, 350);
            bottomBar.setBounds(0, 700 - 350 - i, 1000, 350);
            repaint();
            try { Thread.sleep(speed); } catch (Exception e) { e.printStackTrace(); }
        }

        // Wait a moment before fading out
        try { Thread.sleep(300); } catch (Exception e) { e.printStackTrace(); }

        // 🔥 Fade-out effect
        for (float i = 1; i >= 0; i -= 0.05f) {
            setOpacity(i);
            try { Thread.sleep(50); } catch (Exception e) { e.printStackTrace(); }
        }

        setVisible(false);
        new Login();
    }

    public void run() {
        // Not needed anymore since animation is in main constructor
    }

    public static void main(String[] args) {
        new Splash();
    }
}