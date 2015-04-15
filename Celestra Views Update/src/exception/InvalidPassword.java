package exception;

public class InvalidPassword extends Exception {
	 public InvalidPassword(){

	    }
	    
	    public String getMessage() {
	        return "Invalid password. Please check the password input.";
	    }
}
