package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class() {
        // Get the screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Load and scale the background image dynamically
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, screenWidth, screenHeight);
        add(img);

        // Create the menu bar
        JMenuBar mb = new JMenuBar();

        // New Information
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        // View Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        // Apply Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        // Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        // Examination
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        mb.add(exam);

        JMenuItem examDetails = new JMenuItem("Examination Results");
        examDetails.setBackground(Color.WHITE);
        examDetails.addActionListener(this);
        exam.add(examDetails);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        // Update Details
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);

        JMenuItem updateFaculty = new JMenuItem("Update Faculty Details");
        updateFaculty.setBackground(Color.WHITE);
        updateFaculty.addActionListener(this);
        updateInfo.add(updateFaculty);

        JMenuItem updateStudent = new JMenuItem("Update Student Details");
        updateStudent.setBackground(Color.WHITE);
        updateStudent.addActionListener(this);
        updateInfo.add(updateStudent);

        // Fee Details
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        // About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setBackground(Color.WHITE);
        aboutItem.addActionListener(this);
        about.add(aboutItem);

        // Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setBackground(Color.WHITE);
        exitItem.addActionListener(this);
        exit.add(exitItem);

        setJMenuBar(mb);

        // Set JFrame properties
        setSize(screenWidth, screenHeight);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Make it full screen
        setUndecorated(true); // Removes title bar for a true full-screen effect
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if (action.equals("Exit")) {
            System.exit(0);
        } else if (action.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (action.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (action.equals("New Faculty Information")) {
            new AddFaculty();
        } else if (action.equals("New Student Information")) {
            new AddStudent();
        } else if (action.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (action.equals("View Student Details")) {
            new StudentDetails();
        } else if (action.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (action.equals("Student Leave")) {
            new StudentLeave();
        } else if (action.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (action.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (action.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (action.equals("Update Student Details")) {
            new updateStudent();
        } else if (action.equals("Enter Marks")) {
            new EnterMarks();
        } else if (action.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (action.equals("Fee Structure")) {
            new FreeStructure();
        } else if (action.equals("Student Fee Form")) {
            new StudentFeeForm();
        } else if (action.equals("About")) {
            new About();
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}