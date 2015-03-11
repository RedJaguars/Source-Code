public class GarmentOrder extends OrderItem{
	private String garmentType;
	private String gender;
	private String material;
	private String specialInstruction;
	private TopMeasurement topMeasure;
	private BottomMeasurement bottomMeasure;
	
	public GarmentOrder(int qty, double price, String garmentType, String gender) {
		super(qty, price);
		this.garmentType = garmentType;
		this.gender = gender;
	}
	
	public String getGarmentType() {
		return this.garmentType;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public String getMaterial() {
		return this.material;
	}
	
	public String getSpecialInstruction() {
		return this.specialInstruction;
	}
	
	public TopMeasurement getTopMeasurement() {
		return this.topMeasure;
	}
	
	public BottomMeasurement getBottomMeasurement() {
		return this.bottomMeasure;
	}
	
	public void setGarmentType(String type) {
		this.garmentType = type;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void setSpecialInstruction(String instruction) {
		this.specialInstruction = instruction;
	}
	
	public void setTopMeasurement(TopMeasurement measure) {
		this.topMeasure = measure;
	}
	
	public void setBottomMeasurement(BottomMeasurement measure) {
		this.bottomMeasure = measure;
	}
}
 