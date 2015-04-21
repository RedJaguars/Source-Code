package exception;

public class EmptyItemNameException extends Exception {
	public String getMessage(){
		return "Error: Item name is required";
		
	}
}
