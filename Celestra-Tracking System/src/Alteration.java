
public class Alteration extends OrderItem{
	private GarmentType garmentType;
	private String specialInstruction;
	
	private Alteration(AlterationBuilder builder) {
		super(builder.qty, builder.price);
		this.garmentType = builder.garmentType;
		this.specialInstruction = builder.instruction;
		this.itemID = builder.orderID;
	}
	
	public static class AlterationBuilder extends OrderItem.OrderBuilder{
		private final GarmentType garmentType;
		private final String instruction;
		
		public AlterationBuilder(int qty, double price, GarmentType garmentType, String instruction) {
			super(qty, price);
			this.garmentType = garmentType;
			this.instruction = instruction;
		}
		
		public OrderItem build() {
			return new Alteration(this);
		}
	}
	
	public GarmentType getGarmentType() {
		return this.garmentType;
	}
	
	public String getInstruction() {
		return this.specialInstruction;
	}
	
	public void setGarmentType(GarmentType type) {
		this.garmentType = type;
	}
	
	public void setInstruction(String instruction) {
		this.specialInstruction = instruction;
	}
}
