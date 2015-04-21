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
				if(theResultSet.getString("password").equals(password))
					return true;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		throw new InvalidPassword();
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
		query = "SELECT password FROM account WHERE accountID = 1";
		try {
			theStatement = con.getConnection().prepareStatement(query);
			theResultSet = theStatement.executeQuery();
			while(theResultSet.next()){
				oldPasswordFromDB = theResultSet.getString("password");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(!oldPassword.equals(oldPasswordFromDB)){
			System.out.println("1");
			throw new InvalidOldPasswordException();
		}
		if(!newPassword.equals(confirmNewPassword)){
			System.out.println("2");
			throw new ConfirmPasswordException();
		}
		if(newPassword.equals(oldPassword)){
			System.out.println("3");
			throw new SameOldNewPasswordException();
		}
		if(newPassword.contains(" ")){
			System.out.println("4");
			throw new SpacePasswordException();	
		}
		if(newPassword.length()<6){
			System.out.println("5");
			throw new ShortPasswordException();
		}
		
		
		query = "UPDATE account SET password=?  WHERE accountID=?";
		try{
			theStatement = con.getConnection().prepareStatement(query);
			theStatement.setString(1, newPassword);
			theStatement.setInt(2, 1);
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
