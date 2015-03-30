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
public class ConfirmPasswordException extends Exception {
    public ConfirmPasswordException(){

    }
    
    public String getMessage() {
        return "Invalid: Password does not match.";
    }
}
