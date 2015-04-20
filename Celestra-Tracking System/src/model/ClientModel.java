package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import database.DatabaseConnection;
import objects.Client;

public class ClientModel extends Model {

	public ClientModel() {
		super();
	}
	
	public void addClient(Client client) throws SQLException {
		String statement = "INSERT INTO clients(lastName, firstName, gender, contactNo, email) VALUES(?, ? , ?, ?, ?)";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		ps.setString(1, client.getLastName());
		ps.setString(2, client.getFirstName());
		ps.setString(3, client.getGender());
		ps.setString(4, client.getContactNo());
		ps.setString(5, client.getEmail());
		ps.executeUpdate();
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
