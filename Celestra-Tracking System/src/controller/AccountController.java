package controller;

import model.AccountModel;

public class AccountController extends Controller {
	 public AccountController() {
		 model = new AccountModel();
	 }
	 
	 public void changePassword(String newPass, String oldPassword, String confirmNewPassword) throws Exception{
		 ((AccountModel) model).changePassword(newPass, oldPassword, confirmNewPassword);
	 }
	 public boolean login(int user, String password) throws Exception{
		return ((AccountModel) model).login(user, password);
	 }
	 public int getUserCount(){
		 return ((AccountModel) model).getUserCount();
	 }
}
