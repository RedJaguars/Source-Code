/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//put package here

import java.awt.*;

import javax.swing.*;

/**
 *
 * @author Nikko
 */
public class ChangePasswordView extends View{
    private JButton enterbutton;
    private JPasswordField oldpassfield, newpassfield, confirmpassfield;
    private Account account;
    String oldPassword;
    int accountID;
    String newPassword;
    String confirmNewPassword;
    public ChangePasswordView(AccountController controller){
        account = new Account();
        this.controller = controller; 
        showPane(account);
        
    }
    
    public void showPane(Account account, Controller controller){
        
        /*Creates the optionpane for the old password*/
        oldpassfield = new JPasswordField();
        Object [] oldinfo = {
            "Enter old password:", oldpassfield,
        };
        /*Shows the pane*/ 
        int user = Integer.parseInt(JOptionPane.showInputDialog("Input user id:"));
        int option = JOptionPane.showConfirmDialog(null, oldinfo, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION && ){
            oldPassword = 
        	newpassfield = new JPasswordField(); /*Creates the optionpane for changing password*/
            confirmpassfield = new JPasswordField();
        
            Object [] newinfo = {
                "Enter new password:", newpassfield,
                "Confirm new password:", confirmpassfield,
            };
            /*Shows the pane*/
            int option2 = JOptionPane.showConfirmDialog(null, newinfo, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION);
            if(option2 == JOptionPane.OK_OPTION && newpassfield.getPassword().equals(confirmpassfield.getPassword())){
                account.setPassword(newpassfield.getPassword().toString());
            }else if(option2 !=JOptionPane.CANCEL_OPTION){/*newpassfield doesn't match the confirmpassfield*/
                JOptionPane.showMessageDialog(null, "Password does not match!");
            }
        }/*else if(option !=JOptionPane.CANCEL_OPTION){oldpassfield doesn't match the old password of the user
            JOptionPane.showMessageDialog(null, "Password does not match with the old one!");
        }*/
    }
  
}
