package controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import objects.Material;
import model.InventoryModel;
import objects.Unit;

public class InventoryController extends Controller {

	public InventoryController() {
		super();
		model = new InventoryModel();
		model.register(this);
	}
	
	public void addInventory(String inventoryName, double quantityInStock, String description, Unit unit) throws Exception {
		Material mat = new Material(0, inventoryName, quantityInStock, description, unit);
		((InventoryModel)model).addInventory(mat);
	}
	
	public Iterator<?> retrieveInventoryList() throws SQLException {
		return ((InventoryModel)model).getModelList();
	}
	
	public String getData(int row) throws SQLException {
		return ((InventoryModel)model).getData(row);
	}
	
	public void decreaseStock(int[] stocksToReduce, double quantity) throws Exception{
		((InventoryModel)model).decreaseStock(stocksToReduce, quantity);
	}
	
	public void increaseStock(int[] stocksToIncrease, double quantity) throws Exception{
		((InventoryModel)model).increaseStock(stocksToIncrease, quantity);
	}
	
	public Material getSelectedMaterial(List<Material> list, int selectedRow) throws SQLException {
		return ((InventoryModel)model).getSelectedMaterial(list, selectedRow);
	}
	
	public void modifyMaterial(Material material, Material newMaterial) throws SQLException {
		((InventoryModel)model).modifyMaterial(material, newMaterial);
	}
}
