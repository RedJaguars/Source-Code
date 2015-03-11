
public class OrderItem {
	private int itemID;
	private int quantity;
	private double itemPrice;
	
	public OrderItem(int qty, double price) {
		this.quantity = qty;
		this.itemPrice = price;
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
