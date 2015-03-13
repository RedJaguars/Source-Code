import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderList {
	private int listID;
	private int receiptNo;
	private Date dueDate;
	private Date orderDate;
	private double totalPrice;
	private double balance;
	private String pickupLocation;
	private OrderStatus status;
	private Client client;
	private ArrayList<OrderItem> items;
	
	private OrderList(OrderListBuilder builder) {
		this.items = new ArrayList<>();
		this.totalPrice = 0;
		
		this.receiptNo = builder.receiptNo;
		this.dueDate = builder.dueDate;
		this.orderDate = builder.orderDate;
		this.balance = builder.balance;
		this.pickupLocation = builder.pickupLocation;
		this.client = builder.client;
		this.listID = builder.listID;
		this.status = builder.state;
	}
	
	public static class OrderListBuilder {
		private int listID = 0;
		private final int receiptNo;
		private final Date dueDate;
		private final Date orderDate;
		private final double balance;
		private final String pickupLocation;
		private final Client client;
		private final OrderStatus state;
		
		public OrderListBuilder(int receiptNo, Date dueDate, Date orderDate, double balance, String pickupLocation, Client client, OrderStatus status) {
			this.receiptNo = receiptNo;
			this.dueDate = dueDate;
			this.orderDate = orderDate;
			this.balance = balance;
			this.pickupLocation = pickupLocation;
			this.client = client;
			this.state = status;
		}
		
		public OrderListBuilder listID(int id) {
			this.listID = id;
			return this;
		}
		
		public OrderList build() {
			return new OrderList(this);
		}
	}
	
	public int getListID() {
		return this.listID;
	}
	
	public int getReceiptNo() {
		return this.receiptNo;
	}
	
	public Date getDueDate() {
		return this.dueDate;
	}
	
	public Date getOrderDate() {
		return this.orderDate;
	}
	
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String getPickupLocation() {
		return this.pickupLocation;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public OrderStatus getStatus() {
		return this.status;
	}
	
	public void setReceiptNo(int recNo) {
		this.receiptNo = recNo;
	}
	
	public void setDueDate(Date date) {
		this.dueDate = date;
	}
	
	public void setOrderDate(Date date) {
		this.orderDate = date;
	}
	
	public void setBalance(double bal) {
		this.balance = bal;
	}
	
	public void setPickupLocation(String location) {
		this.pickupLocation = location;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Iterator<OrderItem> getItemList() {
		return items.iterator();
	}
	
	/* adds an OrderItem to the list of Orders */
	public void addOrderItem(OrderItem item) {
		items.add(item);
		totalPrice += item.getPrice();
	}
	
	/* removes an OrderItem to the list of Orders*/
	public void removeItem(OrderItem item) {
		items.remove(item);
		totalPrice -= item.getPrice();
	}
}
