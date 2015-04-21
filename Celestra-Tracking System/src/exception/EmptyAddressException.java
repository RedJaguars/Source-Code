package exception;

public class EmptyAddressException extends Exception {
	public String getMessage(){
		return "Error: Address is required.";
	}
}
