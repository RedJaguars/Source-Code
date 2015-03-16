/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Camille
 */
public class AccountModel extends Model {
    public static final String TABLE_NAME = "account";
    public static final String ACCOUNT_ID = "accountID";
    public static final String PASSWORD = "password";
    
    public AccountModel() {
        super();
    }
    
    @Override
    public void init() {
        setTableName(TABLE_NAME);
        addItem(ACCOUNT_ID, true, DataType.INT, 11).setIsPrimaryKey(true);
        addItem(PASSWORD, true, DataType.STRING, 45);
    }
}
