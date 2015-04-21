package exception;

public class EmptyPriceException extends Exception {
	public String getMessage(){
		return "Error: Price is required.";
	}
}
