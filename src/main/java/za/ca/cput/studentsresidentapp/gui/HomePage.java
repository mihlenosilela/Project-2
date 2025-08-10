
package za.ca.cput.studentsresidentapp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {
   
    private JPanel leftPanel, topPanel, centerPanel;
    private JButton btnApply, btnResidence, btnRoom;
    private JButton btnButton5, btnButton6, btnButton7, btnAccount;
    private JLabel lblWelcome, lblLogo, lblBackground;
    
    public HomePage() {
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLayout(new BorderLayout());

        createComponents();
        setupLayout();
        addActionListeners();

        setVisible(true);
    }

    private void createComponents() {
        
        btnApply = new JButton("Apply");
        btnResidence = new JButton("Residence");
        btnRoom = new JButton("Room");
        btnButton5 = new JButton("Button5");
        btnButton6 = new JButton("Button6");
        btnButton7 = new JButton("Button7");
        
       
        btnApply.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnResidence.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnButton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnButton7.setCursor(new Cursor(Cursor.HAND_CURSOR));

       
        btnAccount = new JButton();
        btnAccount.setBackground(new Color(0, 51, 102));
        btnAccount.setForeground(Color.WHITE);
        btnAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAccount.setPreferredSize(new Dimension(120, 40));
        
        try {
            ImageIcon accountIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/person_24dp_0000F5_FILL0_wght400_GRAD0_opsz24.png");
            Image scaledIcon = accountIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            btnAccount.setIcon(new ImageIcon(scaledIcon));
            btnAccount.setText("Account");
            btnAccount.setHorizontalTextPosition(SwingConstants.RIGHT);
            btnAccount.setIconTextGap(10);
        } catch (Exception e) {
            btnAccount.setText("Account"); 
            System.out.println("Account icon not found, using text only");
        }

       
        lblWelcome = new JLabel("WELCOME");
        lblWelcome.setFont(new Font("SansSerif", Font.BOLD, 64));
        lblWelcome.setForeground(Color.WHITE);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        
       
        try {
            ImageIcon logoIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/Resicon.jpeg");
            lblLogo = new JLabel(new ImageIcon(logoIcon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
            
            ImageIcon bgIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/duskfall-crew-5PMQF1y1hrk-unsplash.jpg");
            lblBackground = new JLabel(new ImageIcon(bgIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            lblLogo = new JLabel("LOGO");
            lblBackground = new JLabel();
            lblBackground.setBackground(new Color(87, 132, 230));
            lblBackground.setOpaque(true);
        }
    }

    private void setupLayout() {
       
        leftPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        leftPanel.setBackground(new Color(87, 132, 230));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        leftPanel.add(btnApply);
        leftPanel.add(btnResidence);
        leftPanel.add(btnRoom);

     
        topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(209, 232, 255));
        
        JPanel centerButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        centerButtons.setOpaque(false);
        centerButtons.add(btnButton5);
        centerButtons.add(btnButton6);
        centerButtons.add(btnButton7);
        
        JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        accountPanel.setOpaque(false);
        accountPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        accountPanel.add(btnAccount);
        
        topPanel.add(lblLogo, BorderLayout.WEST);
        topPanel.add(centerButtons, BorderLayout.CENTER);
        topPanel.add(accountPanel, BorderLayout.EAST);

        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(87, 132, 230));
        lblBackground.setLayout(new GridBagLayout());
        lblBackground.add(lblWelcome);
        centerPanel.add(lblBackground, BorderLayout.CENTER);

   
        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void addActionListeners() {
        btnApply.addActionListener(this);
        btnResidence.addActionListener(this);
        btnRoom.addActionListener(this);
        btnButton5.addActionListener(this);
        btnButton6.addActionListener(this);
        btnButton7.addActionListener(this);
        btnAccount.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAccount) {
            JOptionPane.showMessageDialog(this, "Account button clicked!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage());
    }
}