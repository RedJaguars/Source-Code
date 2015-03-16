/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Camille
 */
public class AlterationPanel {
    private JTextArea txtMaterials;
    private JTextArea txtSpecialInstruction;
    
    private JPanel alterationPanel;
    
    public AlterationPanel() {
        alterationPanel = new JPanel();
        
        JLabel lblMaterials = new JLabel("Materials:");
        lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMaterials.setBounds(60, 20, 119, 25);
       
        txtMaterials = new JTextArea();
        txtMaterials.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtMaterials.setBounds(60, 45, 230, 230);
        
        JLabel lblSpecialInstruction = new JLabel("Special Instructions:");
        lblSpecialInstruction.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSpecialInstruction.setBounds(320, 20, 200, 25);
       
        txtSpecialInstruction = new JTextArea();
        txtSpecialInstruction.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtSpecialInstruction.setBounds(320, 45, 230, 230);
        
        alterationPanel.add(lblMaterials);
        alterationPanel.add(txtMaterials);
        alterationPanel.add(lblSpecialInstruction);
        alterationPanel.add(txtSpecialInstruction);
        
        alterationPanel.setBounds(0, 0, 600, 300);
        alterationPanel.setVisible(true);
        alterationPanel.setLayout(null);
    }
    
    public JPanel getPanel() {
        return alterationPanel;
    }
}
