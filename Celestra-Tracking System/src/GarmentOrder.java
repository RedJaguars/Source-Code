public class GarmentOrder extends OrderItem{
	private GarmentType garmentType;
	private Gender gender;
	private String material;
	private String specialInstruction;
	private TopMeasurement topMeasure;
	private BottomMeasurement bottomMeasure;
	
	public GarmentOrder(GarmentOrderBuilder builder) {
		super(builder.qty, builder.price);
		this.garmentType = builder.garmentType;
		this.gender = builder.gender;
		this.material = builder.material;
		this.specialInstruction = builder.specialInstruction;
	}
	
	public static class GarmentOrderBuilder extends OrderItem.OrderBuilder {
		private final GarmentType garmentType;
		private final Gender gender;
		
		private String material = null;
		private String specialInstruction = null;
		private TopMeasurement topMeasure = null;
		private BottomMeasurement bottomMeasure = null;
		
		public GarmentOrderBuilder(int qty, double price, GarmentType garmentType, Gender gender) {
			super(qty, price);
			this.garmentType = garmentType;
			this.gender = gender;
		}
		
		public GarmentOrderBuilder material(String material) {
			this.material = material;
			return this;
		}
		
		public GarmentOrderBuilder instruction(String instruction) {
			this.specialInstruction = instruction;
			return this;
		}
		
		public OrderItem build() {
			return new GarmentOrder(this);
		}
	}
	
	public GarmentType getGarmentType() {
		return this.garmentType;
	}
	
	public Gender getGender() {
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
	
	public void setGarmentType(GarmentType type) {
		this.garmentType = type;
	}
	
	public void setGender(Gender gender) {
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
 