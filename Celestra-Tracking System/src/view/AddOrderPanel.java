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
public class AddOrderPanel implements ActionListener {
    private JTextField txtCustomerName;
    private JTextField txtAddress;
    private JTextField txtContact;
    private JTextField txtQuantity;
    private JTextField price;
    
    private JComboBox cmbType;
    private JComboBox cmbMonth;
    private JComboBox cmbDay;
    private JComboBox cmbYear;
    private JComboBox cmbGarmentType;
    
    private JLabel lblGarment;
    
    private JButton btnSubmit;
    private JButton btnCancel;
    
    private MainFrame mainFrame;
    
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel panelType;
    private JPanel addOrderPanel;

    public AddOrderPanel(MainFrame frame) {
        mainFrame = frame;
        
        addOrderPanel = new JPanel();
        
        JLabel lblAddNewOrder = new JLabel("Add New Order");
        lblAddNewOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAddNewOrder.setBounds(15, 20, 119, 25);
        
        JLabel lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setBounds(60, 50, 120, 20);
        lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(170, 50, 380, 20);
        txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(60, 70, 120, 20);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JRadioButton male = new JRadioButton("Male");
        male.setMnemonic(KeyEvent.VK_M);
        male.setBounds(170, 70, 150, 20);
        
        JRadioButton female = new JRadioButton ("Female");
        female.setMnemonic(KeyEvent.VK_F);
        female.setBounds(340, 70, 150, 20);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(60, 90, 100, 20);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        txtAddress = new JTextField();
        txtAddress.setBounds(170, 90, 380, 20);
        txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblContact = new JLabel("Contact#:");
        lblContact.setBounds(60, 110, 100, 20);
        lblContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        txtContact = new JTextField();
        txtContact.setBounds(170, 110, 380, 20);
        txtContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(60, 130, 100, 20);
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        String[] typeChoices = {"Embroidery", "Alteration", "Made to Order"};
        
        cmbType = new JComboBox(typeChoices);
        cmbType.setBounds(170, 130, 380, 20);
        cmbType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cmbType.addActionListener(this);
        
        panelType = new JPanel();
        panelType.setBounds(0, 170, 600, 300);
        panelType.add(new EmbroideryPanel().getPanel());
        
        JLabel quantity = new JLabel("Quantity:");
        quantity.setBounds(60, 450, 100, 20);
        quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        txtQuantity = new JTextField();
        txtQuantity.setBounds(170, 450, 380, 20);
        txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel dueDate = new JLabel("Due Date:");
        dueDate.setBounds(60, 470, 100, 20);
        dueDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        String[] monthChoices = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                                "November", "December"};
        
        cmbMonth = new JComboBox(monthChoices);
        cmbMonth.setBounds(170, 470, 100, 20);
        cmbMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        String[] dayChoices = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        
        cmbDay = new JComboBox(dayChoices);
        cmbDay.setBounds(280, 470, 50, 20);
        cmbDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        String[] yearChoices = {"2015", "2016", "2017", "2018"};
        
        cmbYear = new JComboBox(yearChoices);
        cmbYear.setBounds(340, 470, 70, 20);
        cmbYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(60, 480, 70, 50);
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        price = new JTextField();
        price.setBounds(120, 495, 50, 20);

        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(120, 530, 168, 20);
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));        
       
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(350, 530, 168, 20);
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);
        
        addOrderPanel.add(lblAddNewOrder);
        addOrderPanel.add(lblCustomerName);
        addOrderPanel.add(txtCustomerName);
        addOrderPanel.add(lblGender);
        addOrderPanel.add(male);
        addOrderPanel.add(female);
        addOrderPanel.add(lblAddress);
        addOrderPanel.add(txtAddress);
        addOrderPanel.add(lblContact);
        addOrderPanel.add(txtContact);
        addOrderPanel.add(lblType);
        addOrderPanel.add(cmbType);
        addOrderPanel.add(panelType);
        addOrderPanel.add(quantity);
        addOrderPanel.add(txtQuantity);
        addOrderPanel.add(dueDate);
        addOrderPanel.add(cmbMonth);
        addOrderPanel.add(cmbDay);
        addOrderPanel.add(cmbYear);
        addOrderPanel.add(priceLabel);
        addOrderPanel.add(price);
        addOrderPanel.add(btnSubmit);
        addOrderPanel.add(btnCancel);
        
        addOrderPanel.setBounds(200, 0, 600, 600);
        addOrderPanel.setVisible(true);
        addOrderPanel.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == this.btnSubmit) {
            System.out.println("hello");
        } else if(arg0.getSource() == this.btnCancel) {
            mainFrame.openManageOrderScreen();
        } else if(cmbType.getSelectedIndex() == 0) {
            panelType.removeAll();
            panelType.add(new EmbroideryPanel().getPanel());
            panelType.repaint();
        } else if(cmbType.getSelectedIndex() == 1) {
            panelType.removeAll();
            panelType.add(new AlterationPanel().getPanel());
            panelType.repaint();
        } else if(cmbType.getSelectedIndex() == 2) { 
            panelType.removeAll();
            
            firstPanel = new JPanel();
            firstPanel.setBounds(0, 0,  600, 20);
            firstPanel.setLayout(null);
            firstPanel.add(new GarmentTypePanel(this).getPanel());
            
            secondPanel = new JPanel();
            secondPanel.setBounds(0, 10,  600, 280);
            secondPanel.setLayout(null);
            secondPanel.add(new FullBodyPanel().getPanel());
            
            panelType.add(firstPanel);
            panelType.add(secondPanel);
            panelType.repaint();
        }
    }
    
    public JPanel getPanel() {
        return addOrderPanel;
    }
    
    public void changeGarmentDetailsPanel(JPanel panel) {
        secondPanel.removeAll();
        secondPanel.add(panel);
        secondPanel.repaint();
        panelType.repaint();
    }
}
