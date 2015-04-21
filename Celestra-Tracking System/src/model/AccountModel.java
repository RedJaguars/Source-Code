package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import database.DatabaseConnection;
import exception.ConfirmPasswordException;
import exception.InvalidOldPasswordException;
import exception.InvalidPassword;
import exception.InvalidUserNameException;
import exception.SameOldNewPasswordException;
import exception.ShortPasswordException;
import exception.SpacePasswordException;
import objects.Account;


public class AccountModel extends Model{
	private ResultSet theResultSet;
	private PreparedStatement theStatement;
	private int loggedAccountID;
	public AccountModel() {
		super();
		try {
			updateModelList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public int getUserCount(){
		int userCount = 0;
		String query = "SELECT COUNT(accountID) FROM account";
		try {
			theStatement = con.getConnection().prepareStatement(query);
			theResultSet = theStatement.executeQuery();
			while(theResultSet.next())
				userCount = theResultSet.getInt("COUNT(accountID)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userCount;
			
		
	}
	
	public boolean login(int user, String password) throws Exception{
		String query;
		query = "SELECT * FROM account";
		try {
			theStatement = con.getConnection().prepareStatement(query);
			theResultSet = theStatement.executeQuery();
			while(theResultSet.next()){
				if(theResultSet.getString("password").equals(password)){
					loggedAccountID = theResultSet.getInt("accountID");
					System.out.println("Logged in as: "+loggedAccountID);
					storeLoggedUser(loggedAccountID);
					return true;
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		throw new InvalidPassword();
	}
	
	private void storeLoggedUser(int id) {
		String query = "CREATE TEMPORARY TABLE logged_user (userID int NOT NULL)";
		try {
			theStatement = con.getConnection().prepareStatement(query);
			theStatement.execute();
			query = "INSERT INTO logged_user(userID) VALUES(?)";
			theStatement = con.getConnection().prepareStatement(query);
			theStatement.setInt(1, id);
			theStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void logOut(){
		String query = "DROP TABLE logged_user";
		try {
			theStatement = con.getConnection().prepareStatement(query);
			theStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void addAccount(Account newAccount){
		String query = "INSERT INTO account VALUES(?,?)";
		try{
			theStatement = con.getConnection().prepareStatement(query);
			theStatement.setInt(1, newAccount.getAccountID());
			theStatement.setString(2, newAccount.getPassword());
		}catch(SQLException e){
			System.out.println("Error in inserting new account into database!");
		}
		try {
			updateModelList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	public void changePassword(String newPassword, String oldPassword, String confirmNewPassword) throws Exception{// not sure if the checking of the oldPassword and the confirmNewPassword is done here
		
		
		String oldPasswordFromDB = null;
		String query;
		
		query = "SELECT userID FROM logged_user";
		theStatement = con.getConnection().prepareStatement(query);
		theResultSet = theStatement.executeQuery();
		
		while(theResultSet.next()){
			loggedAccountID = theResultSet.getInt(1);
			System.out.println("Logged from SQL: " + loggedAccountID);
		}
		
		
		
		query = "SELECT password FROM account WHERE accountID = ?";
		System.out.println("GETTING PASSFROM USER: " + loggedAccountID);
		try {
			theStatement = con.getConnection().prepareStatement(query);
			theStatement.setInt(1, loggedAccountID);
			theResultSet = theStatement.executeQuery();
			while(theResultSet.next()){
				oldPasswordFromDB = theResultSet.getString("password");
			}
			System.out.println(oldPasswordFromDB + " ?= " + oldPassword );
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(!oldPassword.equals(oldPasswordFromDB)){
			throw new InvalidOldPasswordException();
		}
		if(!newPassword.equals(confirmNewPassword)){
			throw new ConfirmPasswordException();
		}
		if(newPassword.equals(oldPassword)){
			throw new SameOldNewPasswordException();
		}
		if(newPassword.contains(" ")){
			throw new SpacePasswordException();	
		}
		if(newPassword.length()<6){
			throw new ShortPasswordException();
		}
		
		
		query = "UPDATE account SET password=?  WHERE accountID=?";
		try{
			theStatement = con.getConnection().prepareStatement(query);
			theStatement.setString(1, newPassword);
			theStatement.setInt(2, loggedAccountID);
			theStatement.execute();
		}catch(SQLException e){
			System.out.println("Error in updating new password in the database!");
			
		}
		
	}
	
	public Iterator<Object> updateModelList() throws SQLException {
		String query = "SELECT * FROM account";
		Account account;
		theStatement = con.getConnection().prepareStatement(query);
		theResultSet = theStatement.executeQuery();
		while(theResultSet.next()){
			account = new Account(Integer.parseInt(theResultSet.getString("accountID")), theResultSet.getString("password"));
			modelList.add(account);
		}
		Iterator<Object> i = modelList.iterator();
		return i;
	}

	@Override
	public Iterator<?> getModelList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
