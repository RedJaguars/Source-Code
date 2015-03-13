import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AccountModel extends Model{
	private ArrayList<Account> accountList;
	private ResultSet theResultSet;
	private PreparedStatement theStatement;
	private DatabaseConnection connection;
	
	public void addAccount(Account newAccount){
		accountList.add(newAccount);
		String query = "INSERT INTO account VALUES(?,?)";
		try{
			theStatement = connection.getConnection().prepareStatement(query);
			theStatement.setInt(1, newAccount.getAccountID());
			theStatement.setString(2, newAccount.getPassword());
		}catch(SQLException e){
			System.out.println("Error in inserting new account into database!");
		}
	}
	
	
	public void getAccountsFromDB(){
		String query = "SELECT * FROM account";
		Account account;
		try {
			theStatement = connection.getConnection().prepareStatement(query);
			theResultSet = theStatement.executeQuery();
			while(theResultSet.next()){
				account = new Account(Integer.parseInt(theResultSet.getString("accountID")), theResultSet.getString("password"));
				accountList.add(account);
			}
			
		} catch (SQLException e) {
			System.out.println("Error in fetching all accounts from database!");
			e.printStackTrace();
		}
		
		
	}
	
	
	public void changePassword(String newPassword, int accountID){// not sure if the checking of the oldPassword and the confirmNewPassword is done here
		for(Account a:accountList){
			if(a.getAccountID() == accountID){
				a.setPassword(newPassword);
				break;
			}
		}
		
		String query = "UPDATE account SET password=?  WHERE accountID=?";
		
		try{
			theStatement = connection.getConnection().prepareStatement(query);
			theStatement.setString(1, newPassword);
			theStatement.setInt(2, accountID);
			theStatement.execute();
		}catch(SQLException e){
			System.out.println("Error in updating new password in the database!");
			
		}
		
	}
	
}
