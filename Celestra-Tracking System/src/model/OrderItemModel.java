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
public class OrderItemModel extends Model {
    public static final String TABLE_NAME = "order_item";
    public static final String ORDER_ID = "orderID";
    public static final String QUANTITY = "quantity";
    public static final String ORDER_LIST_ID = "orderListID";
    public static final String ITEM_PRICE = "itemPrice";
    
    public OrderItemModel() {
        super();
    }
    
    @Override
    public void init() {
        setTableName(TABLE_NAME);
        addItem(ORDER_ID, true, DataType.INT, 11);
        addItem(QUANTITY, true, DataType.INT, 11);
        addItem(ORDER_LIST_ID, true, DataType.INT, 11);
        addItem(ITEM_PRICE, true, DataType.DOUBLE, 0);
    }
    
}
