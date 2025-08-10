/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ca.cput.studentsresidentapp.gui;

import javax.swing.*;
import java.awt.*;


public class adminHomeGui extends JFrame {
    
    private JPanel pnlHead, pnlBody, pnlFooter;
    private JButton resManagement, stuManagement;
    private JLabel logoLabel, titleLabel;
    
    public adminHomeGui(){
        initializeComponents();
        setupLayout();
        setupWindow();
    }
    
    private void initializeComponents() {
        // Initialize panels
        pnlHead = new JPanel();
        pnlBody = new JPanel();
        pnlFooter = new JPanel();
        
        // Initialize buttons with gear icons (using Unicode gear symbol)
        resManagement = new JButton("⚙ Residence Management");
        stuManagement = new JButton("⚙ Student Management");
        
        // Initialize labels
        ImageIcon originalIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/Resicon.jpeg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        logoLabel = new JLabel(new ImageIcon(scaledImage));

        titleLabel = new JLabel("ADMINISTRATION PANEL");
        
        // Set button properties
        resManagement.setPreferredSize(new Dimension(200, 40));
        resManagement.setBackground(Color.WHITE);
        resManagement.setFocusPainted(false);

        
        stuManagement.setPreferredSize(new Dimension(200, 40));
        stuManagement.setBackground(Color.WHITE);
        stuManagement.setFocusPainted(false);
        

        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
    }
    
    private void setupLayout() {
        // Header panel setup (white background)
        pnlHead.setLayout(new BorderLayout());
        pnlHead.setBackground(Color.WHITE);
        pnlHead.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add title to left side of header
        pnlHead.add(titleLabel, BorderLayout.WEST);
        // Add logo to right side of header
        pnlHead.add(logoLabel, BorderLayout.EAST);
        
        // Body panel setup (blue background)
        pnlBody.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        pnlBody.setBackground(new Color(86, 151, 254)); 
        
        // Add buttons to body
        pnlBody.add(resManagement);
        pnlBody.add(stuManagement);
        
        // Footer panel setup (white background)
        pnlFooter.setLayout(new FlowLayout());
        pnlFooter.setBackground(Color.WHITE);
        pnlFooter.setPreferredSize(new Dimension(0, 100));
        
        // Add panels to main frame
        this.setLayout(new BorderLayout());
        this.add(pnlHead, BorderLayout.NORTH);
        this.add(pnlBody, BorderLayout.CENTER);
        this.add(pnlFooter, BorderLayout.SOUTH);
    }
    
    private void setupWindow() {
        this.setTitle("Administration Panel");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the window
        this.setResizable(true);
    }
    
    // Method to make the GUI visible
    public void showGUI() {
        this.setVisible(true);
    }
    
}