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
public class NoRecordFoundException extends Exception {
    public NoRecordFoundException(){

    }
    
    public String getMessage() {
        return "Invalid: No record found.";
    }
}
