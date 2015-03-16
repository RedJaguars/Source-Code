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
public class MainFrame extends JFrame implements ActionListener {
    private JButton btnAddNewOrder;
    private JButton btnModifyOrder;
    private JButton btnChangeStatus;
    private JButton btnCancelOrder;

    private JButton btnManageOrder;
    private JButton btnManageInventory;
    private JButton btnManageSales;
    private JButton btnExit;
    private JButton btnChangePassword;
    
    private JPanel menuPanel;
    private JPanel secondPanel;
    
    private InventoryDetailsPanel inventoryDetailsPanel;
    private OrderDetailsPanel orderDetailsPanel;
    
    public MainFrame() {
        inventoryDetailsPanel = new InventoryDetailsPanel();
        orderDetailsPanel = new OrderDetailsPanel();
        
        menuPanel = new JPanel();
        menuPanel.setSize(200, 600);
        menuPanel.setBackground(Color.gray);
        menuPanel.setLayout(null);
        
        btnManageOrder = new JButton("Manage Order");
        btnManageOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnManageOrder.setBounds(15, 58, 168, 23);
        menuPanel.add(btnManageOrder);

        btnManageInventory = new JButton("Manage Inventory");
        btnManageInventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnManageInventory.setBounds(15, 111, 168, 23);
        menuPanel.add(btnManageInventory);

        btnManageSales = new JButton("Manage Sales");
        btnManageSales.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnManageSales.setBounds(15, 169, 168, 23);
        menuPanel.add(btnManageSales);
        
        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnChangePassword.setBounds(15, 226, 168, 23);
        menuPanel.add(btnChangePassword);
        
        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnExit.setBounds(15, 480, 168, 23);
        menuPanel.add(btnExit);
        
        btnManageOrder.addActionListener(this);
        btnManageInventory.addActionListener(this);
        btnManageSales.addActionListener(this);
        btnChangePassword.addActionListener(this);
        btnExit.addActionListener(this);
        
        secondPanel = new JPanel();
        secondPanel.setBounds(200, 0, 600, 600);
        secondPanel.setLayout(null);
        
        this.add(menuPanel);
        this.add(secondPanel);
        
        this.setSize(new Dimension(800, 600));
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(800, 600);
        this.setBounds(ss.width/2 - frameSize.width/2, 
                        ss.height/2 - frameSize.height/2,
                        frameSize.width, frameSize.height);
        
        btnManageOrder.doClick();
        this.setDefaultCloseOperation(3);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == this.btnManageInventory){
            secondPanel.removeAll();
            secondPanel.add(new InventoryListPanel(this).getPanel());
            secondPanel.add(inventoryDetailsPanel.getPanel());
            repaint();
        } else if(arg0.getSource() == this.btnManageOrder){
            secondPanel.removeAll();
            secondPanel.add(new OrderListPanel(this).getPanel());
            secondPanel.add(orderDetailsPanel.getPanel());
            repaint();
        } else if(arg0.getSource() == this.btnManageSales){
            secondPanel.removeAll();
            repaint();
        } else if(arg0.getSource() == this.btnChangePassword){
            new ChangePasswordView();
        } else if(arg0.getSource() == this.btnExit){
            System.out.println("exit");
        }
    }
    
    public void removeSecondPanelContent() {
        secondPanel.removeAll();
        repaint();
    }
    
    public void setSecondPanelContent(JPanel panel1, JPanel panel2) {
        secondPanel.add(panel1);
        secondPanel.add(panel2);
        repaint();
    }
    
    public void setInventoryDetails(String info) {
        inventoryDetailsPanel.setInventoryDetailsTextArea(info);
    }
    
    public void setOrderDetails(String info) {
        orderDetailsPanel.setOrderDetailsTextArea(info);
    }
    
    public void openManageInventoryScreen() {
        btnManageInventory.doClick();
    }
    
    public void openManageOrderScreen() {
        btnManageOrder.doClick();
    }
}
