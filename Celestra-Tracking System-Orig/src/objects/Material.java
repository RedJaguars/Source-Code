package objects;

public class Material {
	private int inventoryID;
	private String inventoryName;
	private double quantityInStock;
	private String description;
	private Unit unit;
	
	public Material(){}

	
	public Material(int inventoryID, String inventoryName, double quantityInStock, String description, Unit unit) {
		this.inventoryID = inventoryID;
		this.inventoryName = inventoryName;
		this.quantityInStock = quantityInStock;
		this.description = description;
		this.unit = unit;
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

	public double getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(double quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Unit getUnit() {
		return unit;
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
