package exception;

public class NoneSelectedException extends Exception {
	public String getMessage() {
        return "Error: Please select an item";
    }
}
