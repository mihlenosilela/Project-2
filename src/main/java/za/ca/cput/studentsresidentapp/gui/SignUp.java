
package za.ca.cput.studentsresidentapp.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
    // Component declarations
    private JButton btnClose, btnSignUp, btnLogin, btnForgotPassword;
    private JPanel mainPanel;
    private JTextField txtName, txtEmail, txtAnswer, txtAddress;
    private JPasswordField txtPassword;
    private JComboBox<String> cmbSecurityQuestion;
    private JLabel lblTitle, lblName, lblEmail, lblPassword, lblSecurityQuestion, lblAnswer, lblAddress;
     private Image backgroundImage;
    
    
    public SignUp() {
        setTitle("Student Residence Sign Up");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        

        initializeComponents();
        setupLayout();
        addActionListeners();

        setVisible(true);
    }

    private void initializeComponents() {
        // Initialize buttons
        btnClose = new JButton("Close");
        btnSignUp = new JButton("Sign-up");
        btnLogin = new JButton("Log-in");
        btnForgotPassword = new JButton("Forgot Password");

        // Initialize text fields
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtPassword = new JPasswordField();
        txtAnswer = new JTextField();
        txtAddress = new JTextField();

        // Initialize combo box
        String[] questions = {
            "-Choose an option-",
            "What primary school did you attend?",
            "What was your first car?",
            "What is the name of the town you were born?",
            "What is the name of your first pet?"
        };
        cmbSecurityQuestion = new JComboBox<>(questions);

        // Initialize labels
        lblTitle = new JLabel("Signup");
        lblTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
        
        lblName = new JLabel("Name:");
        lblEmail = new JLabel("Email:");
        lblPassword = new JLabel("Password:");
        lblSecurityQuestion = new JLabel("Security Question:");
        lblAnswer = new JLabel("Answer:");
        lblAddress = new JLabel("Address:");

        // Set common fonts for labels
        Font labelFont = new Font("Arial", Font.BOLD, 12);
        lblName.setFont(labelFont);
        lblEmail.setFont(labelFont);
        lblPassword.setFont(labelFont);
        lblSecurityQuestion.setFont(labelFont);
        lblAnswer.setFont(labelFont);
        lblAddress.setFont(labelFont);
    }

    private void setupLayout() {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.cyan);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(lblTitle, gbc);

        // Name
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(lblName, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtName.setPreferredSize(new Dimension(200, 25));
        mainPanel.add(txtName, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(lblEmail, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(txtEmail, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(lblPassword, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(txtPassword, gbc);

        // Security Question
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(lblSecurityQuestion, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(cmbSecurityQuestion, gbc);

        // Answer
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(lblAnswer, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(txtAnswer, gbc);

        // Address
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(lblAddress, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(txtAddress, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(btnSignUp);
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnForgotPassword);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        // Close button at bottom
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        closePanel.add(btnClose);

        // Add components to frame
        add(mainPanel, BorderLayout.CENTER);
        add(closePanel, BorderLayout.SOUTH);
    }

    private void addActionListeners() {
        btnClose.addActionListener(this);
        btnSignUp.addActionListener(this);
        btnLogin.addActionListener(this);
        btnForgotPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClose) {
            dispose();
        } else if (e.getSource() == btnSignUp) {
            handleSignUp();
        } else if (e.getSource() == btnLogin) {
            handleLogin();
        } else if (e.getSource() == btnForgotPassword) {
            handleForgotPassword();
        }
    }

    private void handleSignUp() {
        // Implement sign-up logic here
        JOptionPane.showMessageDialog(this, "Sign Up button clicked");
    }

    private void handleLogin() {
        // Implement login logic here
        JOptionPane.showMessageDialog(this, "Login button clicked");
    }

    private void handleForgotPassword() {
        // Implement forgot password logic here
        JOptionPane.showMessageDialog(this, "Forgot Password button clicked");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUp());
    }
}