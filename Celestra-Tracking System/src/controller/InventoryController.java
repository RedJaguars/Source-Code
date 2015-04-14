package controller;

import java.sql.SQLException;
import java.util.Iterator;

import objects.Material;
import model.InventoryModel;
import objects.Unit;

public class InventoryController extends Controller {

	public InventoryController() {
		super();
		model = new InventoryModel();
		model.register(this);
	}
	
	public void addInventory(String inventoryName, double quantityInStock, String description, String unit) throws Exception {
		Material mat = new Material(0, inventoryName, quantityInStock, description, Unit.getUnit(unit));
		((InventoryModel)model).addInventory(mat);
	}
	
	public Iterator<?> retrieveInventoryList() throws SQLException {
		return ((InventoryModel)model).getModelList();
	}
	
	public String getData(int row) throws SQLException {
		return ((InventoryModel)model).getData(row);
	}
	public void decreaseStock(int[] stocksToReduce, double quantity) throws SQLException{
		((InventoryModel)model).decreaseStock(stocksToReduce, quantity);
	}
}
