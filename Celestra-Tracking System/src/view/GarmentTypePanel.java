/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Camille
 */
public class GarmentTypePanel implements ActionListener {
    private JComboBox cmbGarmentType;
    
    private JPanel garmentTypePanel;
    private AddOrderPanel addOrderPanel;
    
    public GarmentTypePanel(AddOrderPanel panel) {
        addOrderPanel = panel;
        
        garmentTypePanel = new JPanel();
        
        JLabel lblGarment = new JLabel("Garment:");
        lblGarment.setBounds(60, 0, 100, 20);
        lblGarment.setFont(new Font("Tahoma", Font.PLAIN, 14));

        String[] garmentTypeChoices = {"Full Body", "Bottom", "Top"};

        cmbGarmentType = new JComboBox(garmentTypeChoices);
        cmbGarmentType.setBounds(170, 0, 380, 20);
        cmbGarmentType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmbGarmentType.addActionListener(this);

        garmentTypePanel.add(lblGarment);
        garmentTypePanel.add(cmbGarmentType);
        
        garmentTypePanel.setVisible(true);
        garmentTypePanel.setLayout(null);
        garmentTypePanel.setBounds(0, 0, 600, 20);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(cmbGarmentType.getSelectedIndex() == 0) {
            addOrderPanel.changeGarmentDetailsPanel(new FullBodyPanel().getPanel());
        } else if(cmbGarmentType.getSelectedIndex() == 1) {
            addOrderPanel.changeGarmentDetailsPanel(new BottomPanel().getPanel());
        } else if(cmbGarmentType.getSelectedIndex() == 2) {
            addOrderPanel.changeGarmentDetailsPanel(new TopPanel().getPanel());
        }
    }
    
    public JPanel getPanel() {
        return garmentTypePanel;
    }
}
