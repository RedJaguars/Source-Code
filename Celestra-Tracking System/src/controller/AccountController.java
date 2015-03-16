/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Camille
 */
import db.DatabaseConnection;
import exception.ConfirmPasswordException;
import exception.InvalidOldPasswordException;
import exception.SameOldNewPasswordException;
import exception.ShortPasswordException;
import exception.SpacePasswordException;
import model.AccountModel;
import model.ModelItem;

public class AccountController extends Controller {

    public AccountController() {
    }

    public boolean changePassword(int accountID, String oldPassword,
            String newPassword, String confirmNewPassword) throws Exception {
        
    	//Password too short
    	if(newPassword.length() < 6){
    		throw new ShortPasswordException();
    	}
    	//Password format error(Contains space)
    	if(newPassword.contains(" ")){
    		throw new SpacePasswordException();
    	}
    	
    	// Failed confirmation of new password.
    	if(!newPassword.equals(confirmNewPassword)) {
            throw new ConfirmPasswordException();
        }
       
        // Same old and new password.
        if(oldPassword.equals(newPassword)) {
            throw new SameOldNewPasswordException();
        }
        
        AccountModel accountModel = new AccountModel();
        accountModel.getItem(AccountModel.ACCOUNT_ID).setValue(accountID);
        accountModel.retrieve(DatabaseConnection.getInstance().getConnection());
        
        ModelItem passwordItem = accountModel.getItem(AccountModel.PASSWORD);
        String retrievedOldPassword = passwordItem.getValue().toString();
        
        // Invalid old password.
        if(!oldPassword.equals(retrievedOldPassword)) {
            throw new InvalidOldPasswordException();
        }
        
        passwordItem.setValue(newPassword);
        accountModel.setUpdateFields(AccountModel.PASSWORD);
        accountModel.update(DatabaseConnection.getInstance().getConnection());
        //Returns true if no Exceptions were thrown
        return true;
    }
    
    public void addAccount(int accountID, String password) throws Exception{
        AccountModel accountModel = new AccountModel();
        accountModel.getItem(AccountModel.ACCOUNT_ID).setValue(accountID);
        accountModel.getItem(AccountModel.PASSWORD).setValue(password);
        accountModel.setInsertFields(AccountModel.PASSWORD);
        accountModel.insert(DatabaseConnection.getInstance().getConnection());
    }
/*
    public boolean checkPassword(int accountID, String password){
        return theAccountModel.checkPassword(accountID, password);
    }

    public boolean checkPassword(int accountID, String password){
        for(Object account: modelList){
            if(((Account)account).getAccountID() == accountID){
                if(((Account)account).getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }

    public void changePassword(String newPassword, int accountID, String oldPassword, String confirmNewPassword) throws Exception{
        boolean isValid = false;
        for(Object account: modelList){
            if(((Account)account).getAccountID() == accountID){
                if(((Account)account).getPassword().equals(oldPassword) && newPassword.equals(confirmNewPassword)){
                    isValid = true;
                    break;
                }
            }	
        }

        if(isValid){
            query = "UPDATE account SET password=?  WHERE accountID=?";
            theStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
            theStatement.setString(1, newPassword);
            theStatement.setInt(2, accountID);
            if(theStatement.executeUpdate() == 0)
                throw new SQLException();
        }
        else{
            throw new PasswordException();	
        }
    }

    public void updateModelList() throws SQLException {
        query = "SELECT * FROM account";
        Account account;
        theStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        theResultSet = theStatement.executeQuery();
        while(theResultSet.next()){
            account = new Account(theResultSet.getInt("accountID"), theResultSet.getString("password"));
            modelList.add(account);
        }
    }

    public Iterator<Object> getModelList() throws SQLException {
        query = "SELECT * FROM account";
        Account account;
        theStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        theResultSet = theStatement.executeQuery();
        while(theResultSet.next()){
            account = new Account(Integer.parseInt(theResultSet.getString("accountID")), theResultSet.getString("password"));
            modelList.add(account);
        }
        Iterator<Object> i = modelList.iterator();
        return i;
    }
*/
}
