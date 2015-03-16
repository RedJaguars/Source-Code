package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//put package here

import javax.swing.*;
import controller.AccountController;

/**
 *
 * @author Camille
 */
public class ChangePasswordView {
    
    private JButton enterbutton;
    private JPasswordField oldpassfield, newpassfield, confirmpassfield;
    private AccountController accountController;
    
    public ChangePasswordView() {
        accountController = new AccountController();
        showPane();
    }
    
    public void showPane() {
        oldpassfield = new JPasswordField();
        newpassfield = new JPasswordField();
        confirmpassfield = new JPasswordField();
            
        Object [] oldinfo = {
            "Enter old password:", oldpassfield,
            "Enter new password:", newpassfield,
            "Confirm new password:", confirmpassfield,
        };
        
        /*Shows the pane*/
        int option = JOptionPane.showConfirmDialog(null, oldinfo, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION){
            try {
                if(accountController.changePassword(1, oldpassfield.getText(), newpassfield.getText(), confirmpassfield.getText()))
                	JOptionPane.showMessageDialog(null, "Password has been successfully Changed.", "Notice", 1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 2);
                e.printStackTrace();
            }
        }
    }
  
}
