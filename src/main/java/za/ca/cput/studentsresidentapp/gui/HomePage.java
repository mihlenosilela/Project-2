
package za.ca.cput.studentsresidentapp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener {
    // Component declarations
    private JPanel leftPanel, topPanel, centerPanel;
    private JButton btnApply, btnResidence, btnRoom;
    private JButton btnButton5, btnButton6, btnButton7;
    private JLabel lblWelcome, lblLogo;
    private JMenuBar menuBar;
    private JMenu menuFile, menuEdit;

    public HomePage() {
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366, 768);
        setLayout(new BorderLayout());

        initializeComponents();
        setupLayout();
        addActionListeners();

        setVisible(true);
    }

    private void initializeComponents() {
        // Initialize panels
        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(87, 132, 230));
        
        topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(209, 232, 255));
        
        centerPanel = new JPanel();
        //centerPanel.setBackground(new Color(87, 132, 230));

        // Initialize buttons
        btnApply = new JButton("Apply");
        btnApply.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnResidence = new JButton("Residence");
        btnResidence.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnRoom = new JButton("Room");
        btnRoom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnButton5 = new JButton("Button5");
        btnButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnButton6 = new JButton("Button6");
        btnButton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnButton7 = new JButton("Button7");
        btnButton7.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Initialize label
        lblWelcome = new JLabel("WELCOME");
        lblWelcome.setFont(new Font("SansSerif", Font.BOLD, 48));

        // Initialize logo (replace "path/to/your/logo.png" with your actual logo path)
        ImageIcon logoIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/Resicon.jpeg");
        // Scale the logo if needed
        Image scaledLogo = logoIcon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(scaledLogo));
        lblLogo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));

        // Initialize menu
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
    }

    private void setupLayout() {
        // Left panel layout
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        btnApply.setPreferredSize(new Dimension(241, 120));
        leftPanel.add(btnApply, gbc);
        
        gbc.gridy++;
        btnResidence.setPreferredSize(new Dimension(241, 120));
        leftPanel.add(btnResidence, gbc);
        
        gbc.gridy++;
        btnRoom.setPreferredSize(new Dimension(241, 120));
        leftPanel.add(btnRoom, gbc);

        // Top panel layout - now with logo on left and buttons centered
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        btnButton5.setPreferredSize(new Dimension(120, 60));
        btnButton6.setPreferredSize(new Dimension(120, 60));
        btnButton7.setPreferredSize(new Dimension(120, 60));
        buttonPanel.add(btnButton5);
        buttonPanel.add(btnButton6);
        buttonPanel.add(btnButton7);
        buttonPanel.setOpaque(false); // Make transparent to show topPanel background
        
        topPanel.add(lblLogo, BorderLayout.WEST);
        topPanel.add(buttonPanel, BorderLayout.CENTER);

        // Center panel layout
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(lblWelcome);

        // Menu bar
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        setJMenuBar(menuBar);

        // Add panels to frame
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnApply) {
            handleApply();
        } else if (e.getSource() == btnResidence) {
            handleResidence();
        } else if (e.getSource() == btnRoom) {
            handleRoom();
        }
        // Add handlers for other buttons as needed
    }

    private void handleApply() {
        // TODO: Add apply button functionality
    }

    private void handleResidence() {
        // TODO: Add residence button functionality
    }

    private void handleRoom() {
        // TODO: Add room button functionality
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage());
    }
}