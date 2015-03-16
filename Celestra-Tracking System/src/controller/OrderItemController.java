/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DatabaseConnection;
import java.sql.*;
import java.util.*;
import model.OrderItemModel;

/**
 *
 * @author Camille
 */
public class OrderItemController extends Controller {
    public OrderItemController() {
    }
    
    public ArrayList<OrderItemModel> retrieveOrderItemList() {
        ArrayList<OrderItemModel> orderItemModelList = new ArrayList<OrderItemModel>();
        try {
            String query = "SELECT orderID, quantity, orderListID, itemPrice FROM order_item";
            PreparedStatement statement =  DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            try {
                while(rs.next()) {
                    OrderItemModel orderItem = new OrderItemModel();
                    orderItem.getItem(OrderItemModel.ORDER_ID).setValue(rs.getInt(1));
                    orderItem.getItem(OrderItemModel.QUANTITY).setValue(rs.getInt(2));
                    orderItem.getItem(OrderItemModel.ORDER_LIST_ID).setValue(rs.getInt(3));
                    orderItem.getItem(OrderItemModel.ITEM_PRICE).setValue(rs.getDouble(4));
                    
                    orderItemModelList.add(orderItem);
                }
                return orderItemModelList;
            } finally {
                rs.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getData(int row) {
        ArrayList<OrderItemModel> orderList = retrieveOrderItemList();
        OrderItemModel orderItemModel = orderList.get(row);
        
        return "Order ID: " + orderItemModel.getItem(OrderItemModel.ORDER_ID).getValue().toString() + '\n' +
               "Quantity Name: " + orderItemModel.getItem(OrderItemModel.QUANTITY).getValue().toString() + '\n' +
               "Order List ID: " + orderItemModel.getItem(OrderItemModel.ORDER_LIST_ID).getValue().toString() + '\n' +
               "Item Price: " + orderItemModel.getItem(OrderItemModel.ITEM_PRICE).getValue().toString() + '\n';
    } 
}
