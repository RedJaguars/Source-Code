package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import database.DatabaseConnection;
import objects.Client;

public class ClientModel extends Model {

	public ClientModel() {
		super();
	}
	
	public static Client getClientByID(int id) throws SQLException {
		Client client;
		
		ResultSet clientSet = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT * FROM clients WHERE clientID = " + id).executeQuery();
		clientSet.first();
		
		client = new Client.ClientBuilder(clientSet.getString("lastName"), clientSet.getString("firstName"), clientSet.getString("gender"), clientSet.getString("contactNo"))
							.clientID(id)
							.build();
		return client;
	}
	
	@Override
	public Iterator<?> getModelList() throws SQLException {
		modelList.removeAll(modelList);
		ResultSet clientList = con.getConnection().prepareStatement("SELECT * FROM clients").executeQuery();
		
		while(clientList.next()) {
			modelList.add(getClientByID(clientList.getInt("clientID")));
		}
		return modelList.iterator();
	}

}
