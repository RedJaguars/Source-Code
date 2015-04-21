package exception;

public class EmptyMaterialsException extends Exception {
	public String getMessage(){
		return "Error: Materials is required.";
	}
}
