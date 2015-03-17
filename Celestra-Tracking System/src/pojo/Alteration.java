package pojo;
public class Alteration extends OrderItem{
	private Garment garment;
	private String specialInstruction;
	
	private Alteration(AlterationBuilder builder) {
		super(builder.qty, builder.price);
		this.garment = builder.garment;
		this.specialInstruction = builder.instruction;
		this.itemID = builder.orderID;
	}
	
	public static class AlterationBuilder extends OrderItem.OrderBuilder{
		private final Garment garment;
		private final String instruction;
		
		public AlterationBuilder(int qty, double price, Garment garment, String instruction) {
			super(qty, price);
			this.garment = garment;
			this.instruction = instruction;
		}
		
		public OrderItem build() {
			return new Alteration(this);
		}
	}
	
	public Garment getGarment() {
		return this.garment;
	}
	
	public String getInstruction() {
		return this.specialInstruction;
	}
	
	public void setGarment(Garment type) {
		this.garment = type;
	}
	
	public void setInstruction(String instruction) {
		this.specialInstruction = instruction;
	}
}
