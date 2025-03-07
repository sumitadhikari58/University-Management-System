package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About() {
        setTitle("About SRM University");

        // Image Setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/images (2) (1).png"));
        Image i2 = i1.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 20, 250, 150);
        add(img);

        // Heading
        JLabel heading = new JLabel("<html><center>SRM<br>University</center></html>");
        heading.setBounds(50, 30, 350, 100);
        heading.setFont(new Font("Serif", Font.BOLD, 40));
        heading.setForeground(new Color(25, 25, 112)); // Dark Blue
        add(heading);

        // About Text with JTextArea for better formatting
        JTextArea aboutText = new JTextArea(
                "SRM Institute of Science and Technology (SRMIST), commonly known as SRM University, is one of India's leading private universities. "
                        + "Renowned for excellence in engineering, management, medicine, and humanities, SRM has multiple campuses across India. "
                        + "Established in 1985, the main campus is in Kattankulathur, Tamil Nadu. With state-of-the-art infrastructure, global collaborations, "
                        + "and strong placement records, SRM provides a dynamic learning environment fostering innovation and professional growth.");
        aboutText.setBounds(50, 150, 600, 120);
        aboutText.setFont(new Font("SansSerif", Font.PLAIN, 14));
        aboutText.setForeground(Color.BLACK);
        aboutText.setWrapStyleWord(true);
        aboutText.setLineWrap(true);
        aboutText.setEditable(false);
        aboutText.setOpaque(false);
        add(aboutText);

        // Contact Label
        JLabel contact = new JLabel("Visit: www.srmist.edu.in");
        contact.setBounds(50, 320, 600, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contact.setForeground(Color.BLUE);
        add(contact);

        // Frame Settings
        setSize(700, 450);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230)); // Light Blue
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}