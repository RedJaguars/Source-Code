package exception;

public class QunatityUnderflowException extends Exception {
	
	public String getMessage() {
        return "Error: Can't decrease stock quantity anymore.";
    }
}
