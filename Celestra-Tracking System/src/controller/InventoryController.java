/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DatabaseConnection;
import java.sql.*;
import java.util.*;
import model.InventoryModel;

/**
 *
 * @author Camille
 */
public class InventoryController extends Controller {
    public InventoryController() {
    }
    
    public void addInventory(String inventoryName, double quantityInStock, 
            String description, String unit) throws Exception {
        InventoryModel inventoryModel = new InventoryModel();
        inventoryModel.getItem(InventoryModel.INVENTORY_NAME).setValue(inventoryName);
        inventoryModel.getItem(InventoryModel.QUANTITY_IN_STOCK).setValue(quantityInStock);
        inventoryModel.getItem(InventoryModel.DESCRIPTION).setValue(description);
        inventoryModel.getItem(InventoryModel.UNIT).setValue(unit);
        inventoryModel.setInsertFields(InventoryModel.INVENTORY_NAME, InventoryModel.QUANTITY_IN_STOCK,
                InventoryModel.DESCRIPTION, InventoryModel.UNIT);
        inventoryModel.insert(DatabaseConnection.getInstance().getConnection());
    }
    
    public ArrayList<InventoryModel> retrieveInventoryModelList() {
        ArrayList<InventoryModel> inventoryModelItemList = new ArrayList<InventoryModel>();
        try {
            String query = "SELECT inventoryID, inventoryName, quantityInStock, description, unit FROM inventory";
            PreparedStatement statement =  DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            try {
                while(rs.next()) {
                    InventoryModel inventoryItem = new InventoryModel();
                    inventoryItem.getItem(InventoryModel.INVENTORY_ID).setValue(rs.getInt(1));
                    inventoryItem.getItem(InventoryModel.INVENTORY_NAME).setValue(rs.getString(2));
                    inventoryItem.getItem(InventoryModel.QUANTITY_IN_STOCK).setValue(rs.getDouble(3));
                    inventoryItem.getItem(InventoryModel.DESCRIPTION).setValue(rs.getString(4));
                    inventoryItem.getItem(InventoryModel.UNIT).setValue(rs.getString(5));
                    
                    inventoryModelItemList.add(inventoryItem);
                }
                return inventoryModelItemList;
            } finally {
                rs.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getData(int row) {
        ArrayList<InventoryModel> inventoryModelList = retrieveInventoryModelList();
        InventoryModel inventoryModel = inventoryModelList.get(row);
        
        return "Inventory ID: " + inventoryModel.getItem(InventoryModel.INVENTORY_ID).getValue().toString() + '\n' +
               "Inventory Name: " + inventoryModel.getItem(InventoryModel.INVENTORY_NAME).getValue().toString() + '\n' +
               "Quantity in Stock: " + inventoryModel.getItem(InventoryModel.QUANTITY_IN_STOCK).getValue().toString() + '\n' +
               "Description: " + inventoryModel.getItem(InventoryModel.DESCRIPTION).getValue().toString() + '\n' +
               "Unit: " + inventoryModel.getItem(InventoryModel.UNIT).getValue().toString() + '\n';
    } 
}
