package exception;

public class SpacePasswordException extends Exception {
	public SpacePasswordException(){

    }
    
    public String getMessage() {
        return "Please check the password format. The password cannot contain a space.";
    }
}
