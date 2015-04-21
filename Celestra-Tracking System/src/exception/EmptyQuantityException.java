package exception;

public class EmptyQuantityException extends Exception {
	public String getMessage(){
		return "Error: Quantity is required.";
	}
}
