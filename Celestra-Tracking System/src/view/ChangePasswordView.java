package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//put package here

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.AccountController;

/**
 *
 * @author Camille
 */
public class ChangePasswordView implements ActionListener{
    
    private JButton enterbutton;
    private JPasswordField oldpassfield, newpassfield, confirmpassfield;
    private AccountController accountController;
    private JLabel oldPassLabel, newPassLabel, confirmPassLabel;
    private JButton submitButton, cancelButton;
    public ChangePasswordView() {
    	oldpassfield = new JPasswordField();
        newpassfield = new JPasswordField();
        confirmpassfield = new JPasswordField();
        oldPassLabel = new JLabel("Enter old password:");
        newPassLabel = new JLabel("Enter new password:");
        confirmPassLabel =  new JLabel("Confirm new password:");
        submitButton  = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        
        
        
        
        
        
        
    }
    
    public void showPane() {
        oldpassfield = new JPasswordField();
        newpassfield = new JPasswordField();
        confirmpassfield = new JPasswordField();
        oldPassLabel = new JLabel("Enter old password:");
        newPassLabel = new JLabel("Enter new password:");
        confirmPassLabel =  new JLabel("Confirm new password:");
        
        Object [] oldinfo = {
            "Enter old password:", oldpassfield,
            "Enter new password:", newpassfield,
            "Confirm new password:", confirmpassfield,
        };
        
        //int option = JOptionPane.showConfirmDialog(null, oldinfo, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION);
        //if(option == JOptionPane.OK_OPTION){
            try {
                if(accountController.changePassword(1, oldpassfield.getPassword(). toString(), newpassfield.getPassword().toString(), confirmpassfield.getPassword().toString()))
                	JOptionPane.showMessageDialog(null, "Password has been successfully changed.", "Notice", 1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 2);
                e.printStackTrace();
           // }
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
  
}
