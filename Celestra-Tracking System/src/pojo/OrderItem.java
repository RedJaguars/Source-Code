package pojo;

public class OrderItem {
	protected int itemID;
	private int quantity;
	private OrderStatus state;
	private double itemPrice;
	
	protected OrderItem(int qty, double price) {
		this.quantity = qty;
		this.itemPrice = price;
	}
	
	public static abstract class OrderBuilder {
		protected final int qty;
		protected final double price;
		protected int orderID = 0;
		
		public OrderBuilder(int qty, double price) {
			this.qty = qty;
			this.price = price;
		}
		
		public OrderBuilder itemID(int id) {
			this.orderID = id;
			return this;
		}
		
		public abstract OrderItem build();
	}
	
	public int getItemID() {
		return this.itemID;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public double getPrice() {
		return this.itemPrice;
	}
	
	public OrderStatus getStatus() {
		return this.state;
	}
	
	public void setItemID(int id) {
		this.itemID = id;
	}
	
	public void setQuantity(int qty) {
		this.quantity = qty;
	}
	
	public void setPrice(double price) {
		this.itemPrice = price;
	}
	
	public void setStatus(OrderStatus status) {
		this.state = status;
	}
}
