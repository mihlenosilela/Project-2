/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ca.cput.studentsresidentapp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogIn extends JFrame implements ActionListener {
    // Component declarations
    private JLabel lblTitle, lblEmail, lblPassword;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JCheckBox chkShowPassword;
    private JButton btnLogin, btnCancel;

    public LogIn() {
        setTitle("Login System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768 );
        setLayout(new BorderLayout());

        initializeComponents();
        setupLayout();
        addActionListeners();

        setVisible(true);
    }

    private void initializeComponents() {
        // Initialize labels
        lblTitle = new JLabel("LOG-IN");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        
        lblEmail = new JLabel("Email");
        lblPassword = new JLabel("Password");

        // Initialize text fields
        txtEmail = new JTextField();
        txtPassword = new JPasswordField();
        txtPassword.setEchoChar('*');

        // Initialize checkbox
        chkShowPassword = new JCheckBox("Show");
        chkShowPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Initialize buttons
        btnLogin = new JButton("Log-In");
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnCancel = new JButton("Cancel");
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel();
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

        // Email
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(lblEmail, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtEmail.setPreferredSize(new Dimension(200, 25));
        mainPanel.add(txtEmail, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        mainPanel.add(lblPassword, gbc);
        
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.add(txtPassword, BorderLayout.CENTER);
        passwordPanel.add(chkShowPassword, BorderLayout.EAST);
        mainPanel.add(passwordPanel, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnCancel);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        // Add main panel to frame
        add(mainPanel, BorderLayout.CENTER);
    }

    private void addActionListeners() {
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
        chkShowPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            handleLogin();
        } else if (e.getSource() == btnCancel) {
            handleCancel();
        } else if (e.getSource() == chkShowPassword) {
            togglePasswordVisibility();
        }
    }

    private void handleLogin() {
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());
        
        if (email.equals("keepiniteazy") && password.equals("admin")) {
            this.setVisible(false);
            new SignUp().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect username or password");
        }
    }

    private void handleCancel() {
        int option = JOptionPane.showConfirmDialog(
            this, 
            "Do you really want to close the application?", 
            "Confirm Exit", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void togglePasswordVisibility() {
        if (chkShowPassword.isSelected()) {
            txtPassword.setEchoChar((char)0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LogIn());
    }
}