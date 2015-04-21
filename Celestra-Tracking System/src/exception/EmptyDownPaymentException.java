package exception;

public class EmptyDownPaymentException extends Exception {
	public String getMessage(){
		return "Error: Down Payment is required.";
	}
}
