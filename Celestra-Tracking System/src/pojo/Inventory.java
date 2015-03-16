package pojo;

public class Inventory {
    private int inventoryID;
    private String inventoryName;
    private double quantityInStock;
    private String description;
    private String unit;

    public Inventory(){}

    public Inventory(int inventoryID, String inventoryName, double quantityInStock, String description, String unit) {
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
    
    public String getUnit() {
        return unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
