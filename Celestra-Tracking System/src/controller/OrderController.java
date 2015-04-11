package controller;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import objects.Alteration;
import objects.Client;
import objects.OrderItem;
import objects.OrderList;
import objects.OrderStatus;
import model.InventoryModel;
import model.OrderModel;

public class OrderController extends Controller{	
	public OrderController() {
		super();
		model = new OrderModel();
		model.register(this);
		notifyObservers();
	}
	
	public void addNewOrder(int receiptNo, Date dueDate, Date orderDate, double balance, 
							String pickupLocation, Iterator<OrderItem> items, Client client,
							OrderStatus status) throws SQLException{
		
		OrderList orderToAdd = new OrderList.OrderListBuilder(receiptNo, dueDate, orderDate, balance, pickupLocation, client, status)
								.build();
		do {
			OrderItem itemToAdd = items.next();
			orderToAdd.addOrderItem(itemToAdd);
		} while(items.hasNext());
		((OrderModel)model).addNewOrder(orderToAdd);
	}	
	
	public void cancelOrder(OrderList orderToCancel) {
		((OrderModel)model).cancelOrder(orderToCancel);
	}
	
	public void modifyOrder(OrderItem originalOrder, String orderType, Alteration modifiedOrder) throws SQLException {
		((OrderModel)model).modifyOrder(originalOrder, orderType, modifiedOrder);
	}
	
	public Iterator<?> retrieveOrderList() throws SQLException {
		return ((OrderModel)model).getModelList();
	}
	
	public String getOrderListData(int row) throws SQLException {
		return ((OrderModel)model).getOrderListData(row);
	}
	
	public OrderList getSelectedOrderList(int row) throws SQLException {
		return ((OrderModel)model).getSelectedOrderList(row);
	}
	
	public Iterator<?> retrieveOrderItem(OrderList orderList) throws SQLException {
		return ((OrderModel)model).getOrderItemModelList(orderList);
	}
	
	public OrderItem getOrderItem(OrderList orderList, int selectedIndex) throws SQLException {
		return ((OrderModel)model).getOrderItem(orderList, selectedIndex);
	}
	
	public ArrayList<Integer> getOrderItemIDList(OrderList orderList) throws SQLException {
		return ((OrderModel)model).getOrderItemIDList(orderList);
	}
	
	public String determinePanel(OrderList orderList, int selectedIndex) throws SQLException {
		return ((OrderModel) model).determinePanel(orderList, selectedIndex);
	}
}
