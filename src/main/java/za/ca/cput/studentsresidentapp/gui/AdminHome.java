/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package za.ca.cput.studentsresidentapp.gui;

import javax.swing.SwingUtilities;


/**
 *
 * @author tshab
 */
public class AdminHome {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                adminHomeGui gui = new adminHomeGui();
                gui.showGUI();
            }
        });
        
        System.out.println("Moses");
    }
}
