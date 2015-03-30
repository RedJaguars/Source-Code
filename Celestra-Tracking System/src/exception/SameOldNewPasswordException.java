/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Camille
 */
public class SameOldNewPasswordException extends Exception {
    public SameOldNewPasswordException(){

    }
    
    public String getMessage() {
        return "Invalid: Current password is the same as the new password.";
    }
}
