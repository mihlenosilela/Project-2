package za.ca.cput.studentsresidentapp.gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author keepingiteazy
 */
public class SplashScreen extends JFrame {

    private JPanel panelNorth, panelSouth;
    private JProgressBar loadScreen;
    private JLabel lblImage;

    public SplashScreen() {
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        loadScreen = new JProgressBar(0, 100);
        loadScreen.setPreferredSize(new Dimension(200, 20));
        lblImage = new JLabel(new ImageIcon("/Users/keepingiteazy/NetBeansProjects/StudentsResidentApp/src/images/Resicon.jpeg"));
        
        
    }

    public void setGui() {
        this.setLayout(new BorderLayout());
        this.setSize(200, 300);
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelSouth, BorderLayout.SOUTH);
        panelNorth.add(lblImage);
        panelSouth.add(loadScreen);

        this.setUndecorated(true);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        showProgress();
        dispose();

    }

    private void showProgress() {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loadScreen.setValue(i);
        }
    }

    public static void main(String[] args) {
        new SplashScreen().setGui();
    }

}
