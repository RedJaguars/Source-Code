package exception;

public class EmptyContactNoException extends Exception {
	public String getMessage(){
		return "Error: Contact number is required.";
		
	}
}
