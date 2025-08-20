
package za.ca.cput.studentsresidentapp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {
   
    private JPanel leftPanel, rightPanel, topPanel;
    private JButton btnClose, btnSignUp, btnLogin, btnForgotPassword;
    private JTextField txtName, txtEmail, txtAnswer, txtAddress;
    private JPasswordField txtPassword;
    private JComboBox<String> cmbSecurityQuestion;
    private JLabel lblTitle, lblName, lblEmail, lblPassword, lblSecurityQuestion, lblAnswer, lblAddress, lblLogo;

    public SignUp() {
        setTitle("Student Residence Sign Up");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLayout(new BorderLayout());

        initializeComponents();
        setupLayout();
        addActionListeners();

        setVisible(true);
    }

    private void initializeComponents() {
        
        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(87, 132, 230));
        
        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(209, 232, 255));
        
        topPanel = new JPanel();
        topPanel.setBackground(new Color(87, 132, 230));

      
        btnClose = createStyledButton("Close", new Color(255, 102, 102));
        btnSignUp = createStyledButton("Sign-up", new Color(87, 132, 230));
        btnLogin = createStyledButton("Log-in", new Color(87, 132, 230));
        btnForgotPassword = createStyledButton("Forgot Password", new Color(87, 132, 230));

        
        txtName = createStyledTextField();
        txtEmail = createStyledTextField();
        txtPassword = createStyledPasswordField();
        txtAnswer = createStyledTextField();
        txtAddress = createStyledTextField();

       
        String[] questions = {
            "-Choose an option-",
            "What primary school did you attend?",
            "What was your first car?",
            "What is the name of the town you were born?",
            "What is the name of your first pet?"
        };
        cmbSecurityQuestion = new JComboBox<>(questions);
        cmbSecurityQuestion.setFont(new Font("SansSerif", Font.PLAIN, 16));
        cmbSecurityQuestion.setBackground(Color.WHITE);
        cmbSecurityQuestion.setPreferredSize(new Dimension(300, 40));

      
        lblTitle = new JLabel("SIGN UP");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 48));
        lblTitle.setForeground(Color.WHITE);
        
        lblName = createStyledLabel("Name:");
        lblEmail = createStyledLabel("Email:");
        lblPassword = createStyledLabel("Password:");
        lblSecurityQuestion = createStyledLabel("Security Question:");
        lblAnswer = createStyledLabel("Answer:");
        lblAddress = createStyledLabel("Address:");

       
        ImageIcon logoIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/Resicon.jpeg");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(scaledLogo));
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setBackground(bgColor);
        button.setForeground(Color.BLACK);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(180, 50));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return button;
    }

    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("SansSerif", Font.PLAIN, 16));
        field.setPreferredSize(new Dimension(300, 40));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(150, 150, 150)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return field;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField field = new JPasswordField();
        field.setFont(new Font("SansSerif", Font.PLAIN, 16));
        field.setPreferredSize(new Dimension(300, 40));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(150, 150, 150)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        field.setEchoChar('*');
        return field;
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    private void setupLayout() {
        
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(lblLogo);
        topPanel.add(Box.createHorizontalStrut(20));
        topPanel.add(lblTitle);

     
        leftPanel.setPreferredSize(new Dimension(300, 0));

        
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        rightPanel.add(lblName, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        rightPanel.add(txtName, gbc);

      
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        rightPanel.add(lblEmail, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(txtEmail, gbc);

        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        rightPanel.add(lblPassword, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(txtPassword, gbc);

        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        rightPanel.add(lblSecurityQuestion, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(cmbSecurityQuestion, gbc);

        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        rightPanel.add(lblAnswer, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(txtAnswer, gbc);

        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        rightPanel.add(lblAddress, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rightPanel.add(txtAddress, gbc);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(209, 232, 255));
        buttonPanel.add(btnSignUp);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(btnLogin);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(btnForgotPassword);
        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        rightPanel.add(buttonPanel, gbc);

        
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        closePanel.setBackground(new Color(209, 232, 255));
        closePanel.add(btnClose);

        
        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
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
       
        if (validateSignUp()) {
            JOptionPane.showMessageDialog(this, "Sign up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new HomePage().setVisible(true);
        }
    }

    private boolean validateSignUp() {
        
        if (txtName.getText().trim().isEmpty() ||
            txtEmail.getText().trim().isEmpty() ||
            new String(txtPassword.getPassword()).isEmpty() ||
            cmbSecurityQuestion.getSelectedIndex() == 0 ||
            txtAnswer.getText().trim().isEmpty() ||
            txtAddress.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
      
        return true;
    }

    private void handleLogin() {
        this.dispose();
        new LogIn().setVisible(true);
    }

    private void handleForgotPassword() {
        JOptionPane.showMessageDialog(this, "Please contact the administrator to reset your password", 
            "Forgot Password", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUp());
    }
}