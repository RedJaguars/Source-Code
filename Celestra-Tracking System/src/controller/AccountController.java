package controller;

import model.AccountModel;

public class AccountController extends Controller {
	 public AccountController() {
		 model = new AccountModel();
	 }
	 
	 public void changePassword(int id, String newPass) {
		 ((AccountModel) model).changePassword(newPass, id);
	 }
	
}
