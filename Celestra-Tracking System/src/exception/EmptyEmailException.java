package exception;

public class EmptyEmailException extends Exception {
	public String getMessage(){
		return "Error: client e-mail is required.";
		
		
	}
}
