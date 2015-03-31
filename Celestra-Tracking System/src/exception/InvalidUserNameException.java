package exception;

public class InvalidUserNameException extends Exception {
	 public InvalidUserNameException(){

	    }
	    
	    public String getMessage() {
	        return "Invalid username. Please check the username input.";
	    }
}
