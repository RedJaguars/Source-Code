package exception;

public class EmptyReceiptNoException extends Exception {
	public String getMessage(){
		return "Error: Receipt Number is required.";
	}
}
