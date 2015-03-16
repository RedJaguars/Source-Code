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
public class InventoryDetailsPanel implements ActionListener {
    private JButton btnReduce;
    private JButton btnAdd;
    
    private JTextArea itemDetails;
    
    private JPanel inventoryDetailsPanel;
    
    public InventoryDetailsPanel() {
        inventoryDetailsPanel = new JPanel();
        
        JLabel lblItemDetails = new JLabel("Item Details");
        lblItemDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblItemDetails.setBounds(15, 20, 119, 25);
        
        itemDetails = new JTextArea();
        itemDetails.setBounds(15, 50, 300, 190);
        itemDetails.setEditable(false);

        SpinnerModel addSpnrModel = new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer (100), new Integer(1));
        SpinnerModel removeSpnrModel = new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer (100), new Integer(1));
        
        JLabel lblReduceQuantity = new JLabel("Reduce Quantity");
        lblReduceQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblReduceQuantity.setBounds(330, 70, 119, 25);
        
        JSpinner sprReduceQuantity = new JSpinner(removeSpnrModel);
        sprReduceQuantity.setBounds(330, 100, 135, 25);
        sprReduceQuantity.setEnabled(true);
        
        btnReduce = new JButton("Reduce");
        btnReduce.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnReduce.setBounds(480, 100, 80, 23);
        
        JLabel lblAddQuantity = new JLabel("Add Quantity");
        lblAddQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAddQuantity.setBounds(330, 130, 119, 25);
        
        JSpinner sprAddQuantity = new JSpinner(addSpnrModel);
        sprAddQuantity.setBounds(330, 160, 135, 25);
        sprAddQuantity.setEnabled(true);

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnAdd.setBounds(480, 160, 80, 23);
        
        btnReduce.addActionListener(this);
        btnAdd.addActionListener(this); 
        
        inventoryDetailsPanel.add(lblItemDetails);
        inventoryDetailsPanel.add(itemDetails);
        inventoryDetailsPanel.add(lblReduceQuantity);
        inventoryDetailsPanel.add(sprReduceQuantity);
        inventoryDetailsPanel.add(btnReduce);
        inventoryDetailsPanel.add(lblAddQuantity);
        inventoryDetailsPanel.add(sprAddQuantity);
        inventoryDetailsPanel.add(btnAdd);
        
        inventoryDetailsPanel.setBounds(200, 300, 600, 300);
        inventoryDetailsPanel.setVisible(true);
        inventoryDetailsPanel.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == this.btnReduce){
            System.out.println("hello");
        } else if(arg0.getSource() == this.btnAdd){
            System.out.println("hello");
        }
    }
    
    public JPanel getPanel() {
        return inventoryDetailsPanel;
    }
    
    public void setInventoryDetailsTextArea(String info) {
        itemDetails.setText(info);
    }
}
