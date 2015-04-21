package exception;

public class IncompleteMeasurementException extends Exception {
	public String getMessage(){
		return "Error: All measurements are required.";
		
	}
}
