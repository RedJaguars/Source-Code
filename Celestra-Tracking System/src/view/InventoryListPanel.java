/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InventoryController;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import model.InventoryModel;

/**
 *
 * @author Camille
 */
public class InventoryListPanel implements ActionListener {
    private JButton btnModify;
    private JButton btnAddNewItem;
    
    private JTable tableInventory;
    private MainFrame mainFrame;
    private JPanel inventoryListPanel;
    private JScrollPane inventoryPane = new JScrollPane(tableInventory);
    private JPanel scrollContainer;
    private InventoryController inventoryController;
    
    public InventoryListPanel(MainFrame frame) {
        mainFrame = frame;
        inventoryListPanel = new JPanel();
        scrollContainer = new JPanel();
        inventoryController = new InventoryController();
        
        JLabel lblListOfInventory = new JLabel("List of Inventory");
        lblListOfInventory.setBounds(15, 20, 119, 25);
        lblListOfInventory.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        /* = new JTable();
        tableInventory.setBounds(15, 50, 555, 240);*/
        
        
        tableInventory = createTable(inventoryController.retrieveInventoryModelList());
        tableInventory.setBounds(0, 0, 555, 240);
        inventoryPane = new JScrollPane(tableInventory);
        inventoryPane.setBounds(0, 0, 555, 240);
        inventoryPane.setViewportView(tableInventory);
        scrollContainer.add(inventoryPane);
        scrollContainer.setBounds(15, 50, 555, 240);
        
        btnModify = new JButton("Modify");
        btnModify.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnModify.setBounds(315, 20, 119, 20);
        
        btnAddNewItem = new JButton("Add Item");
        btnAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAddNewItem.setBounds(450, 20, 119, 20);
        
        btnModify.addActionListener(this);
        btnAddNewItem.addActionListener(this);
        
        inventoryListPanel.add(btnModify);
        inventoryListPanel.add(btnAddNewItem);
        //inventoryListPanel.add(inventoryPane);
        //inventoryListPanel.add(tableInventory);
        inventoryListPanel.add(lblListOfInventory);
        inventoryListPanel.add(scrollContainer);
        
        inventoryListPanel.setBounds(200, 0, 600, 300);
        inventoryListPanel.setVisible(true);
        inventoryListPanel.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == this.btnModify){
            System.out.println("hello");
        } else if(arg0.getSource() == this.btnAddNewItem){
            mainFrame.removeSecondPanelContent();
            mainFrame.setSecondPanelContent(new AddItemPanel(mainFrame).getPanel(), new JPanel());
        }
    }
    
    public JPanel getPanel() {
        return inventoryListPanel;
    }
    
    public JTable createTable(ArrayList<InventoryModel> inventoryItemList) {
    	int size = inventoryItemList.size();
        
        JTable inventoryListTable;
        
        String header[] = {"Inventory ID", "Inventory Name", "Quantity In Stock", "Description", "Unit"};
        DefaultTableModel model = new DefaultTableModel(header, size);
        
        InventoryModel inventoryItem = new InventoryModel();
        for(int i = 0; i < size; i++) {
            inventoryItem = inventoryItemList.get(i);

            model.setValueAt(inventoryItem.getItem(InventoryModel.INVENTORY_ID).getValue(), i, 0);
            model.setValueAt(inventoryItem.getItem(InventoryModel.INVENTORY_NAME).getValue(), i, 1);
            model.setValueAt(inventoryItem.getItem(InventoryModel.QUANTITY_IN_STOCK).getValue(), i, 2);
            model.setValueAt(inventoryItem.getItem(InventoryModel.DESCRIPTION).getValue(), i, 3);
            model.setValueAt(inventoryItem.getItem(InventoryModel.UNIT).getValue(), i, 4);
        }
        
        inventoryListTable = new JTable(model);
        
        for(int i = 0; i < inventoryListTable.getColumnCount(); i++) {  
            inventoryListTable.getColumnModel().getColumn(i).setWidth(111);
        }   
        
        inventoryListTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    mainFrame.setInventoryDetails(inventoryController.getData(row));
                }
            }
        });
        return inventoryListTable;
    }
}
