/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.OrderItemModel;

/**
 *
 * @author Camille
 */
public class OrderDetailsPanel implements ActionListener {
    private JButton btnChangeStatus;
    private JButton btnCancelOrder;
    private JButton btnModifyOrder;
    
    private JTextArea orderDetails;
    
    private JPanel orderDetailsPanel;
            
    public OrderDetailsPanel() {
        orderDetailsPanel = new JPanel();
        
        JLabel lblOrderDetails = new JLabel("Order Details");
        lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblOrderDetails.setBounds(15, 20, 119, 25);
        
        orderDetails = new JTextArea();
        orderDetails.setBounds(20, 45, 380, 190);
        orderDetails.setEditable(false);

        btnChangeStatus = new JButton("Change status");
        btnChangeStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnChangeStatus.setBounds(430, 75, 130, 23);

        btnCancelOrder = new JButton("Cancel order");
        btnCancelOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnCancelOrder.setBounds(430, 120, 130, 23);

        btnModifyOrder = new JButton("Modify order");
        btnModifyOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnModifyOrder.setBounds(430, 165, 130, 23);
        
        btnChangeStatus.addActionListener(this);
        btnCancelOrder.addActionListener(this);
        btnModifyOrder.addActionListener(this);
        
        orderDetailsPanel.add(lblOrderDetails);
        orderDetailsPanel.add(orderDetails);
        orderDetailsPanel.add(btnChangeStatus);
        orderDetailsPanel.add(btnCancelOrder);
        orderDetailsPanel.add(btnModifyOrder);
        
        orderDetailsPanel.setBounds(200, 300, 600, 300);
        orderDetailsPanel.setVisible(true);
        orderDetailsPanel.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == this.btnChangeStatus){
            System.out.println("hello");
        } else if(arg0.getSource() == this.btnCancelOrder){
            System.out.println("hello");
        } else if(arg0.getSource() == this.btnModifyOrder){
            System.out.println("hello");
        }
    }
    
    public JPanel getPanel() {
        return orderDetailsPanel;
    }
    
    public void setOrderDetailsTextArea(String info) {
        orderDetails.setText(info);
        orderDetails.repaint();
    }
}
