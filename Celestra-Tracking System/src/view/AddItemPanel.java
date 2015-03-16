/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InventoryController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Camille
 */
public class AddItemPanel implements ActionListener {
    private JButton btnSubmit;
    private JButton btnCancel;
    
    private JTextField txtItemName;
    private JTextField txtQuantity;
    
    private JTextArea itemDescription;
    
    private JComboBox cmbUnit;
    
    private MainFrame mainFrame;
    
    private JPanel addItemPanel;
    
    private InventoryController inventoryController;
    
    public AddItemPanel(MainFrame frame) {
        inventoryController = new InventoryController();
        
        mainFrame = frame;
        
        addItemPanel = new JPanel();
        
        JLabel lblAddNewItem = new JLabel("Add New Item");
        lblAddNewItem.setBounds(15, 20, 119, 25);
        lblAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblItemName = new JLabel("Item Name:");
        lblItemName.setBounds(60, 50, 100, 25);
        lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        txtItemName = new JTextField();
        txtItemName.setBounds(150, 50, 400, 25);
        txtItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblDecription = new JLabel("Description:");
        lblDecription.setBounds(60, 95, 100, 25);
        lblDecription.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        itemDescription = new JTextArea();
        itemDescription.setBounds(150, 95, 400, 190);
        itemDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(60, 310, 100, 25);
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        txtQuantity = new JTextField();
        txtQuantity.setBounds(150, 310, 400, 25);
        txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblUnit = new JLabel("Unit:");
        lblUnit.setBounds(60, 355, 100, 25);
        lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        String[] unitChoices = {"Meter", "Foot", "Roll"};
        
        cmbUnit = new JComboBox(unitChoices);
        cmbUnit.setBounds(150, 355, 400, 25);
        cmbUnit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSubmit.setBounds(150, 400, 168, 23);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCancel.setBounds(380, 400, 168, 23);
        
        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);
        
        addItemPanel.add(lblAddNewItem);
        addItemPanel.add(lblItemName);
        addItemPanel.add(txtItemName);
        addItemPanel.add(lblDecription);
        addItemPanel.add(itemDescription);
        addItemPanel.add(lblQuantity);
        addItemPanel.add(txtQuantity);
        addItemPanel.add(lblUnit);
        addItemPanel.add(cmbUnit);
        addItemPanel.add(btnSubmit);
        addItemPanel.add(btnCancel);
        
        addItemPanel.setBounds(200, 0, 600, 600);
        addItemPanel.setVisible(true);
        addItemPanel.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == this.btnSubmit) {
            try {
                inventoryController.addInventory(txtItemName.getText(), Integer.parseInt(txtQuantity.getText()),
                        itemDescription.getText(), cmbUnit.getSelectedItem().toString());
                JOptionPane.showMessageDialog(null, "Item has been added to the inventory.");
                emptyTextAreas();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                e.printStackTrace();
            }
        } else if(arg0.getSource() == this.btnCancel) {
            mainFrame.openManageInventoryScreen();
        }
    }
    
    public JPanel getPanel() {
        return addItemPanel;
    }
    
    public void emptyTextAreas() {
        txtItemName.setText("");
        txtQuantity.setText("");
        itemDescription.setText("");
    }
}
