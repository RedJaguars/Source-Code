package objects;

public class OrderDetail {
	private int quantity;
	private String type;
	private int itemID;
	private String detail;

	public OrderDetail(int quantity, int itemID, String type, String detail) {
		this.quantity = quantity;
		this.itemID = itemID;
		this.type = type;
		this.detail = detail;
	}
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String toString() {
		return quantity + "-" + type;
	}
	
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
