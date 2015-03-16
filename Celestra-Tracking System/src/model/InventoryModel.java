/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Camille
 */
public class InventoryModel extends Model {
    public static final String TABLE_NAME = "inventory";
    public static final String INVENTORY_ID = "inventoryID";
    public static final String INVENTORY_NAME = "inventoryName";
    public static final String QUANTITY_IN_STOCK = "quantityInStock";
    public static final String DESCRIPTION = "description";
    public static final String UNIT = "unit";
    
    public InventoryModel() {
        super();
    }

    @Override
    public void init() {
        setTableName(TABLE_NAME);
        addItem(INVENTORY_ID, true, DataType.INT, 11);
        addItem(INVENTORY_NAME, true, DataType.STRING, 45);
        addItem(QUANTITY_IN_STOCK, true, DataType.DOUBLE, 0);
        addItem(DESCRIPTION, true, DataType.STRING, 45);
        addItem(UNIT, true, DataType.STRING, 45);
    }
}
