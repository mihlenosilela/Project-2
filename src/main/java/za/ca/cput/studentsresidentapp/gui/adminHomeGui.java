
package za.ca.cput.studentsresidentapp.gui;

import javax.swing.*;
import java.awt.*;

public class adminHomeGui extends JFrame {
    
    private JPanel pnlHead, pnlBody, pnlFooter;
    private JButton resManagement, stuManagement;
    private JLabel logoLabel, titleLabel, backgroundLabel;
    
    public adminHomeGui(){
        initializeComponents();
        setupLayout();
        setupWindow();
    }
    
    private void initializeComponents() {
        pnlHead = new JPanel();
        pnlBody = new JPanel(new BorderLayout());
        pnlFooter = new JPanel();
          
        resManagement = new JButton("⚙ Residence Management");
        stuManagement = new JButton("⚙ Student Management");
        
        // Initialize logo (use a placeholder if image path is empty)
        ImageIcon originalIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/Resicon.jpeg"); // Empty path will cause issues
        if (originalIcon.getIconWidth() == -1) { // Check if image failed to load
            logoLabel = new JLabel("LOGO");
            logoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        } else {
            Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            logoLabel = new JLabel(new ImageIcon(scaledImage));
        }

        titleLabel = new JLabel("ADMINISTRATION PANEL");
        
        // Initialize backgroundLabel FIRST
        try {
            ImageIcon backgroundIcon = new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/students-outside-university.jpg"); // Empty path
            if (backgroundIcon.getIconWidth() == -1) {
                backgroundLabel = new JLabel();
                backgroundLabel.setBackground(new Color(86, 151, 254));
                backgroundLabel.setOpaque(true);
            } else {
                backgroundLabel = new JLabel(new ImageIcon(backgroundIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_SMOOTH)));
            }
            backgroundLabel.setLayout(new BorderLayout());
        } catch (Exception e) {
            backgroundLabel = new JLabel();
            backgroundLabel.setBackground(new Color(86, 151, 254));
            backgroundLabel.setOpaque(true);
            System.out.println("Background image not found, using solid color");
        }
        
        
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
 
        pnlHead.setLayout(new BorderLayout());
        pnlHead.setBackground(new Color(209, 232, 255));
        pnlHead.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlHead.add(titleLabel, BorderLayout.WEST);
        pnlHead.add(logoLabel, BorderLayout.EAST);
      
       
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        buttonPanel.setOpaque(false); 
        buttonPanel.add(resManagement);
        buttonPanel.add(stuManagement);
        
        
        pnlBody.setLayout(new BorderLayout());
        pnlBody.add(backgroundLabel, BorderLayout.CENTER);
        
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1366, 768));
        
    
        backgroundLabel.setBounds(0, 0, 1366, 768);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
        
        
        buttonPanel.setBounds(0, 0, 1366, 768);
        buttonPanel.setOpaque(false);
        layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);
        
        pnlBody.add(layeredPane, BorderLayout.CENTER);
        pnlBody.setBackground(new Color(86, 151, 254));
        
       
        pnlFooter.setLayout(new FlowLayout());
        pnlFooter.setBackground(new Color(209, 232, 255));
        pnlFooter.setPreferredSize(new Dimension(0, 100));
        
       
        this.setLayout(new BorderLayout());
        this.add(pnlHead, BorderLayout.NORTH);
        this.add(pnlBody, BorderLayout.CENTER);
        this.add(pnlFooter, BorderLayout.SOUTH);
    }
    
    private void setupWindow() {
        this.setTitle("Administration Panel");
        this.setSize(1366, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setResizable(true);
    }
    
    public void showGUI() {
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                adminHomeGui gui = new adminHomeGui();
                gui.showGUI();
            }
        });
    }
}