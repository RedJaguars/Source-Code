package exception;

public class ShortPasswordException extends Exception {
	public ShortPasswordException(){

    }
    
    public String getMessage() {
        return "Invalid: The new password must have at least 6 characters.";
    }
}
