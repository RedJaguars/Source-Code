package exception;

public class EmptyInstructionException extends Exception {
	public String getMessage(){
		return "Error: Special Instruction is required.";
		
	}
}
