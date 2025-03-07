package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, back;
    Login(){

        JLabel labelName = new JLabel("Username");
        labelName.setBounds(40,20,100,30);
        labelName.setForeground(Color.white);
        labelName.setFont(new Font("Courier New", Font.BOLD, 15));
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150,20,150,30);
        
        add(textFieldName);

        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(40,70,100,30);
        labelpass.setForeground(Color.white);
        labelpass.setFont(new Font("Courier New", Font.BOLD, 15));
        add(labelpass);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.white);
        login.setForeground(Color.black);
        login.setFont(new Font("Times New Roman", Font.BOLD, 14));
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(180,140,120,30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setFont(new Font("Times New Roman", Font.BOLD, 14));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ad1.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/ab2.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,300,Image.SCALE_SMOOTH);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,600,300);
        add(image);



        setSize(600,300);
        setLocation(500,250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed method triggered");
    
        if (e.getSource() == login) {
            System.out.println("Login button clicked");
    
            String username = textFieldName.getText();
            String password = new String(passwordField.getPassword());
    
            System.out.println("Entered Username: " + username);
            System.out.println("Entered Password: " + password);
    
            String query = "SELECT * FROM login WHERE username ='" + username + "' AND password = '" + password + "'";
    
            System.out.println("SQL Query: " + query);
    
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
    
                if (resultSet.next()) {
                    System.out.println("Login successful! Redirecting...");
                    setVisible(false);
                    new main_class().setVisible(true);
                } else {
                    System.out.println("Invalid credentials");
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception ex) {
                System.out.println("Exception occurred: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            System.out.println("Some other button clicked");
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
