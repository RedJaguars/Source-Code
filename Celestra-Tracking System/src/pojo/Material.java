
public class Material {
	private int inventoryID;
	private String inventoryName;
	private int quantityInStock;
	private String description;
	
	public Material(){}

	
	public Material(int inventoryID, String inventoryName, int quantityInStock, String description) {
		this.inventoryID = inventoryID;
		this.inventoryName = inventoryName;
		this.quantityInStock = quantityInStock;
		this.description = description;
	}

	
	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
