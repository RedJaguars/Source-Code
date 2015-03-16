package pojo;

public class Account {
    private int accountID;
    private String password;

    public Account(int accountID, String password){
        this.accountID = accountID;
        this.password = password;
    }

    public Account() {
    }

    public int getAccountID(){
        return this.accountID;
    }

    public void setAccountID(int accountID){
        this.accountID = accountID;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
