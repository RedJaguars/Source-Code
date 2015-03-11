import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderList {
	private int receiptNo;
	private Date dueDate;
	private Date orderDate;
	private double totalPrice;
	private double balance;
	private String pickupLocation;
	private Client client;
	private ArrayList<OrderItem> items;
	
	public OrderList() {
		items = new ArrayList<>();
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
	
	public Iterator<OrderItem> getItemList() {
		return items.iterator();
	}
	
	/* adds an OrderItem to the list of Orders */
	public void addOrderItem(OrderItem item) {
		items.add(item);
	}
	
	/* removes an OrderItem to the list of Orders*/
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
}
