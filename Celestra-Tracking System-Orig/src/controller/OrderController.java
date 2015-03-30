package controller;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;

import objects.Client;
import objects.OrderItem;
import objects.OrderList;
import objects.OrderStatus;
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
	
	public void modifyOrder(OrderList original, OrderList modified) throws SQLException {
		((OrderModel)model).modifyOrder(original, modified);
	}
}
