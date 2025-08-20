
package za.ca.cput.studentsresidentapp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogIn extends JFrame implements ActionListener {
    // Component declarations
    private JPanel leftPanel, rightPanel, topPanel;
    private JLabel lblTitle, lblEmail, lblPassword, lblLogo;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JCheckBox chkShowPassword;
    private JButton btnLogin, btnCancel;

    public LogIn() {
        setTitle("Login System");
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

        
        lblTitle = new JLabel("LOG-IN");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 48));
        lblTitle.setForeground(Color.WHITE);
        
        lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("SansSerif", Font.BOLD, 18));
        
        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("SansSerif", Font.BOLD, 18));

        
        txtEmail = new JTextField();
        txtEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtEmail.setPreferredSize(new Dimension(300, 40));
        
        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
        txtPassword.setPreferredSize(new Dimension(300, 40));
        txtPassword.setEchoChar('*');

        
        chkShowPassword = new JCheckBox("Show Password");
        chkShowPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
        chkShowPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chkShowPassword.setBackground(new Color(209, 232, 255));

       
        btnLogin = new JButton("Log-In");
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnLogin.setBackground(new Color(87, 132, 230));
        
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setPreferredSize(new Dimension(150, 50));
        
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnCancel.setBackground(new Color(255, 102, 102));
       
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancel.setPreferredSize(new Dimension(150, 50));

        
        ImageIcon logoIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/Resicon.jpeg");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(scaledLogo));
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
        rightPanel.add(lblEmail, gbc);
        
        gbc.gridy = 1;
        rightPanel.add(txtEmail, gbc);

      
        gbc.gridy = 2;
        rightPanel.add(lblPassword, gbc);
        
        gbc.gridy = 3;
        rightPanel.add(txtPassword, gbc);

       
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        rightPanel.add(chkShowPassword, gbc);

    
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(209, 232, 255));
        buttonPanel.add(btnLogin);
        buttonPanel.add(Box.createHorizontalStrut(30));
        buttonPanel.add(btnCancel);
        
        gbc.gridy = 5;
        rightPanel.add(buttonPanel, gbc);

        
        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
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
            new HomePage().setVisible(true);  
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect username or password", 
                "Login Error", JOptionPane.ERROR_MESSAGE);
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