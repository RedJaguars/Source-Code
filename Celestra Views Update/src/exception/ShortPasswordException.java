package exception;

public class ShortPasswordException extends Exception {
	public ShortPasswordException(){

    }
    
    public String getMessage() {
        return "Password too short! Please make it at least a minimum of 6 Characters";
    }
}
