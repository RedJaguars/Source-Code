package exception;

public class EmptyItemListException extends Exception {
	public String getMessage() {
        return "There is no item in the inventory.";
    }
}
