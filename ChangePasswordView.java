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
public class ChangePasswordView{
    private JButton enterbutton;
    private JPasswordField oldpassfield, newpassfield, confirmpassfield;
    private Account account;
    public ChangePasswordView(){
        account = new Account();
        showPane(account);
    }
    
    public void showPane(Account account){
        
        /*Creates the optionpane for the old password*/
        oldpassfield = new JPasswordField();
        Object [] oldinfo = {
            "Enter old password:", oldpassfield,
        };
        /*Shows the pane*/
        int option = JOptionPane.showConfirmDialog(null, oldinfo, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION && oldpassfield.getText().equals(account.getPassword())){
            newpassfield = new JPasswordField(); /*Creates the optionpane for changing password*/
            confirmpassfield = new JPasswordField();
        
            Object [] newinfo = {
                "Enter new password:", newpassfield,
                "Confirm new password:", confirmpassfield,
            };
            /*Shows the pane*/
            int option2 = JOptionPane.showConfirmDialog(null, newinfo, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION);
            if(option2 == JOptionPane.OK_OPTION && newpassfield.getText().equals(confirmpassfield.getText())){
                account.setPassword(newpassfield.getText());
            }else if(option2 !=JOptionPane.CANCEL_OPTION){/*newpassfield doesn't match the confirmpassfield*/
                JOptionPane.showMessageDialog(null, "Password does not match!");
            }
        }else if(option !=JOptionPane.CANCEL_OPTION){/*oldpassfield doesn't match the old password of the user*/
            JOptionPane.showMessageDialog(null, "Password does not match with the old one!");
        }
    }
  
}
