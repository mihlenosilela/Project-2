package za.ca.cput.studentsresidentapp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyGuiWelcome extends JFrame implements ActionListener {

    private final JButton btnSignIn;
    private final JButton btnCreateAccount;

    public MyGuiWelcome() {
        setTitle("Student Accommodation Portal");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

   
        getContentPane().setBackground(new Color(86, 151, 254)); 

       
        setLayout(new BorderLayout());

     
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40)); 

 
        JLabel lblTitle = new JLabel("FIND YOUR BEST ACCOMMODATION");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        JLabel lblStudent = new JLabel("<html><div style='text-align: center;'>"
                + "Are you a student looking for safe, affordable, and reliable accommodation near your campus? "
                + "Our platform helps you find the perfect place with verified listings and trusted landlords."
                + "</div></html>");
        lblStudent.setFont(new Font("Arial", Font.PLAIN, 14));
        lblStudent.setForeground(Color.WHITE);
        lblStudent.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblStudent.setMaximumSize(new Dimension(600, 60));

        
        JLabel lblLandlord = new JLabel("<html><div style='text-align: center;'>"
                + "Are you a landlord with available rooms or flats? Reach thousands of students by listing your property now. "
                + "It’s fast, easy, and secure."
                + "</div></html>");
        lblLandlord.setFont(new Font("Arial", Font.PLAIN, 14));
        lblLandlord.setForeground(Color.WHITE);
        lblLandlord.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblLandlord.setMaximumSize(new Dimension(600, 60));

     
        btnSignIn = new JButton("Log In");
        btnSignIn.setFont(new Font("Arial", Font.BOLD, 16));
        btnSignIn.setBackground(Color.WHITE);
        btnSignIn.setForeground(new Color(52, 152, 219));
        btnSignIn.setFocusPainted(false);
        btnSignIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSignIn.setMaximumSize(new Dimension(200, 40));
        btnSignIn.addActionListener(this);

        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setFont(new Font("Arial", Font.BOLD, 16));
        btnCreateAccount.setBackground(Color.WHITE);
        btnCreateAccount.setForeground(new Color(52, 152, 219));
        btnCreateAccount.setFocusPainted(false);
        btnCreateAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCreateAccount.setMaximumSize(new Dimension(200, 40));
        btnCreateAccount.addActionListener(this);

       
        centerPanel.add(lblTitle);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        centerPanel.add(lblStudent);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        centerPanel.add(lblLandlord);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        centerPanel.add(btnSignIn);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        centerPanel.add(btnCreateAccount);

    
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignIn) {
            new LogIn().setVisible(true);
            dispose();
        } else if (e.getSource() == btnCreateAccount) {
            new SignUp().setVisible(true);
            dispose();
        }
    }
public static void main(String args[]){
    SwingUtilities.invokeLater(() -> new MyGuiWelcome());
}
  
}
