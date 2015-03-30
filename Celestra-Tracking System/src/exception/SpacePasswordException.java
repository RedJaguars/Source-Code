package exception;

public class SpacePasswordException extends Exception {
	public SpacePasswordException(){

    }
    
    public String getMessage() {
        return "Invalid: The password cannot contain a space.";
    }
}
