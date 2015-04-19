package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysql.jdbc.UpdatableResultSet;

import objects.Material;
import objects.Unit;

public class InventoryModel extends Model {

	public InventoryModel() {
		super();
	}
	
	public void addInventory(Material mat) throws SQLException {
        
		PreparedStatement ps;
		
		ps = con.getConnection().prepareStatement("INSERT INTO inventory(inventoryName, quantityInStock, description, unit) VALUES (?, ?, ?, ?)");
		ps.setString(1, mat.getInventoryName());
		ps.setDouble(2, mat.getQuantityInStock());
		ps.setString(3, mat.getDescription());
		ps.setString(4, mat.getUnit().toString());
		ps.executeUpdate();
		
		System.out.println("Successfully Added.");
	}
	
	@Override
	public Iterator<?> getModelList() throws SQLException {
		modelList.removeAll(modelList);
		PreparedStatement ps = con.getConnection().prepareStatement("SELECT * FROM inventory");
		ResultSet matSet = ps.executeQuery();
		
		while(matSet.next()) {
			Material mat = new Material(matSet.getInt("inventoryID"), matSet.getString("inventoryName"), matSet.getInt("quantityInStock"), matSet.getString("description"), Unit.getUnit(matSet.getString("unit")));
			modelList.add(mat);
		}
		
		return modelList.iterator();
	}
	
	public String getData(int row) throws SQLException {
		Iterator<?> inventoryItemList = getModelList();
		List<Material> list = new ArrayList<Material>();
		int size = 0;
		while(inventoryItemList.hasNext()) {
			list.add((Material) inventoryItemList.next());
			size++;
		}
        Material material = list.get(row);
        
        return "Inventory Name: " + material.getInventoryName() + '\n' +
               "Quantity in Stock: " + material.getQuantityInStock() + '\n' +
               "Description: " + material.getDescription() + '\n' +
               "Unit: " + material.getUnit();
    }

	public void decreaseStock(int[] stocksToReduce, double quantity) throws SQLException {
		String query = "UPDATE inventory SET quantityInStock = quantityInStock - ? WHERE inventoryID = ?";
		
		PreparedStatement statement = con.getConnection().prepareStatement(query);
		for(int i=0;i<stocksToReduce.length;i++){	
			statement.setDouble(1, quantity);
			statement.setInt(2, stocksToReduce[i]);
			System.out.println("Done added batch on: " + stocksToReduce[i]);
			statement.addBatch();
		}
		statement.executeBatch();
		getModelList();
		notifyObservers();
	}
	
	public void increaseStock(int[] stocksToIncrease, double quantity) throws SQLException {
		String query = "UPDATE inventory SET quantityInStock = quantityInStock + ? WHERE inventoryID = ?";
		
		PreparedStatement statement = con.getConnection().prepareStatement(query);
		for(int i=0;i<stocksToIncrease.length;i++){	
			statement.setDouble(1, quantity);
			statement.setInt(2, stocksToIncrease[i]);
			System.out.println("Done added batch on: " + stocksToIncrease[i]);
			statement.addBatch();
		}
		statement.executeBatch();
		getModelList();
		notifyObservers();
	}
	
	public Material getSelectedMaterial(List<Material> list, int selectedRow) throws SQLException {
		Material selectedMaterial = list.get(selectedRow);
		int materialID = selectedMaterial.getInventoryID();
		
		String query = "SELECT * FROM inventory IV WHERE inventoryID = ?";
		PreparedStatement statement = con.getConnection().prepareStatement(query);
		statement.setInt(1, materialID);
		ResultSet matSet = statement.executeQuery();
		
		while(matSet.next()) {
			selectedMaterial = new Material(matSet.getInt("IV.inventoryID"), matSet.getString("IV.inventoryName"), matSet.getInt("IV.quantityInStock"), matSet.getString("IV.description"), Unit.getUnit(matSet.getString("IV.unit")));
		}
		
		return selectedMaterial;
	}
	
	public void modifyMaterial(Material material, Material newMaterial) throws SQLException {
		String query = "UPDATE inventory SET inventoryName = ?, quantityInStock = ?, decription = ?, unit = ? WHERE inventoryID = ?";
		PreparedStatement statement = con.getConnection().prepareStatement(query);
		statement.setString(1, newMaterial.getInventoryName());
		statement.setDouble(2, newMaterial.getQuantityInStock());
		statement.setString(3, newMaterial.getDescription());
		statement.setString(4, newMaterial.getUnit().name());
		statement.setInt(5, material.getInventoryID());
		statement.executeUpdate();
		statement.close();
	}

}
