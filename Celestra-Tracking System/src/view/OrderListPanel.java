/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.OrderItemController;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import model.OrderItemModel;

/**
 *
 * @author Camille
 */
public class OrderListPanel implements ActionListener {
    private JButton btnAddNewOrder;
    private JTable tableOrders;
    private MainFrame mainFrame;
    private JPanel orderListPanel;
    private JScrollPane orderPane;
    private JPanel scrollContainer;
    private OrderItemController orderItemController;
    
    public OrderListPanel(MainFrame frame) {
        mainFrame = frame;
        orderItemController = new OrderItemController();
        orderListPanel = new JPanel();
        scrollContainer = new JPanel();
        
        JLabel lblListOfOrders = new JLabel("List of Orders");
        lblListOfOrders.setBounds(15, 20, 119, 25);
        lblListOfOrders.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        if(orderPane != null) {
            orderListPanel.remove(orderPane);
        }
        tableOrders = createTable(orderItemController.retrieveOrderItemList());
        tableOrders.setBounds(0, 0, 555, 240);
        orderPane = new JScrollPane(tableOrders);
        orderPane.setBounds(0, 0, 555, 250);
        
        scrollContainer.setBounds(15, 50, 555, 250);
        scrollContainer.add(orderPane);
        
        btnAddNewOrder = new JButton("Add Order");
        btnAddNewOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAddNewOrder.setBounds(450, 20, 119, 20);
        
        btnAddNewOrder.addActionListener(this);
        
        orderListPanel.add(btnAddNewOrder);
//        orderListPanel.add(tableOrders);
        orderListPanel.add(lblListOfOrders);
        orderListPanel.add(scrollContainer);
        
        orderListPanel.setBounds(200, 0, 600, 300);
        orderListPanel.setVisible(true);
        orderListPanel.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == this.btnAddNewOrder){
            mainFrame.removeSecondPanelContent();
            mainFrame.setSecondPanelContent(new AddOrderPanel(mainFrame).getPanel(), new JPanel());
        }
    }
    
    public JPanel getPanel() {
        return orderListPanel;
    }
    
    public JTable createTable(ArrayList<OrderItemModel> orderItemList) {
        int size = orderItemList.size();
        
        JTable orderListTable = new UneditableJTable(size, 4);
        orderListTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    mainFrame.setOrderDetails(orderItemController.getData(row));
                }
            }
        });
        TableColumnModel columnModel = orderListTable.getColumnModel();
        TableModel model = orderListTable.getModel();
        
        String header[] = {"Order ID", "Quantity", "Order List ID", "Item Price"};
        
        for(int i = 0; i < orderListTable.getColumnCount(); i++) {
            TableColumn column1 = orderListTable.getTableHeader().getColumnModel().getColumn(i);  
            column1.setHeaderValue(header[i]);  
            columnModel.getColumn(i).setWidth(140);
        }   
        
        OrderItemModel orderItem = new OrderItemModel();
        for(int i = 0; i < size; i++) {
            orderItem = orderItemList.get(i);

            model.setValueAt(orderItem.getItem(OrderItemModel.ORDER_ID).getValue(), i, 0);
            model.setValueAt(orderItem.getItem(OrderItemModel.QUANTITY).getValue(), i, 1);
            model.setValueAt(orderItem.getItem(OrderItemModel.ORDER_LIST_ID).getValue(), i, 2);
            model.setValueAt(orderItem.getItem(OrderItemModel.ITEM_PRICE).getValue(), i, 3);
        }
        return orderListTable;
    }
}
