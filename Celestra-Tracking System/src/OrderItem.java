
public class OrderItem {
	private int itemID;
	private int quantity;
	private double itemPrice;
	
	private OrderItem(OrderItemBuilder builder) {
		this.quantity = builder.quantity;
		this.itemPrice = builder.itemPrice;
		this.itemID = builder.itemID;
	}
	
	public static class OrderItemBuilder {
		private int itemID = 0;
		private final int quantity;
		private final double itemPrice;
		
		public OrderItemBuilder(int qty, double price) {
			this.quantity = qty;
			this.itemPrice = price;
		}
		
		public OrderItemBuilder itemID(int id) {
			this.itemID = id;
			return this;
		}
		
		public OrderItem build() {
			return new OrderItem(this);
		}
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
	
	public void setItemID(int id) {
		this.itemID = id;
	}
	
	public void setQuantity(int qty) {
		this.quantity = qty;
	}
	
	public void setPrice(double price) {
		this.itemPrice = price;
	}
}
