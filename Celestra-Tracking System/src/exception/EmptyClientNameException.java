package exception;

import sun.security.action.GetBooleanAction;

public class EmptyClientNameException extends Exception {
	public String getMessage() {
        return "Error: Client's name is required.";
    }
	
}
