import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;

public class OrderController extends Controller{	
	public OrderController() {
		super();
		model = new OrderModel();
		model.register(this);
	}
	
	public void addNewOrder(int receiptNo, Date dueDate, Date orderDate, double balance, 
							String pickupLocation, Iterator<OrderItem> items, Client client) throws SQLException{
		
		OrderList orderToAdd = new OrderList.OrderListBuilder(receiptNo, dueDate, orderDate, balance, pickupLocation, client)
								.build();
		for(OrderItem itemToAdd = items.next(); items.hasNext(); itemToAdd = items.next()) {
			orderToAdd.addOrderItem(itemToAdd);
		}
		((OrderModel)model).addNewOrder(orderToAdd);
	}	
	
	public void cancelOrder(OrderList orderToCancel) {
		((OrderModel)model).cancelOrder(orderToCancel);
	}
	
	public void modifyOrder(OrderList original, OrderList modified) throws SQLException {
		((OrderModel)model).modifyOrder(original, modified);
	}
}
