
public class Alteration extends OrderItem{
	private String garmentType;
	private String specialInstruction;
	
	public Alteration(int qty, double price, String garmentType, String instruction) {
		super(qty, price);
		this.garmentType = garmentType;
		this.specialInstruction = instruction;
	}
	
	public String getGarmentType() {
		return this.garmentType;
	}
	
	public String getInstruction() {
		return this.specialInstruction;
	}
	
	public void setGarmentType(String type) {
		this.garmentType = type;
	}
	
	public void setInstruction(String instruction) {
		this.specialInstruction = instruction;
	}
}
