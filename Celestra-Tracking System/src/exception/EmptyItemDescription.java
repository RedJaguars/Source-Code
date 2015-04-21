package exception;

public class EmptyItemDescription extends Exception {
	public String getMessage(){
		return "Error: Item description is required.";
		
	}
}
