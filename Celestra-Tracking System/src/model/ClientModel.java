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
	
	public Client addClient(Client client) throws SQLException {
		String statement = "INSERT INTO clients(lastName, firstName, gender, contactNo, email) VALUES(?, ? , ?, ?, ?)";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		ps.setString(1, client.getLastName());
		ps.setString(2, client.getFirstName());
		ps.setString(3, client.getGender());
		ps.setString(4, client.getContactNo());
		ps.setString(5, client.getEmail());
		ps.executeUpdate();
		
		String statement1 = "SELECT * FROM clients CL ORDER BY clientID DESC LIMIT 1";
		PreparedStatement ps1 = con.getConnection().prepareStatement(statement1);
		ResultSet rs1 = ps1.executeQuery();
		
		while(rs1.next()) {
			Client client1 = new Client.ClientBuilder(rs1.getString("CL.lastName"), rs1.getString("CL.firstName"), 
					rs1.getString("CL.gender"), rs1.getString("CL.contactNo")).email(rs1.getString("CL.email"))
					.clientID(rs1.getInt("CL.clientID"))
					.build();
			return client1;
		}
		return null;
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
