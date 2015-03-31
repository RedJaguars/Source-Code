package controller;

import objects.Material;
import model.InventoryModel;
import objects.Unit;

public class InventoryController extends Controller {

	public InventoryController() {
		super();
		model = new InventoryModel();
	}
	
	public void addInventory(String inventoryName, double quantityInStock, String description, String unit) throws Exception {
		Material mat = new Material(0, inventoryName, quantityInStock, description, Unit.getUnit(unit));
		((InventoryModel)model).addInventory(mat);
	}
}
