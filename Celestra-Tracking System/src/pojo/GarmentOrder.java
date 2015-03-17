package pojo;
import java.util.ArrayList;
import java.util.Iterator;

public class GarmentOrder extends OrderItem{
	private Garment garment;
	private Gender gender;
	private String material;
	private String specialInstruction;
	private ArrayList<Measurement> measurements;
	
	public GarmentOrder(GarmentOrderBuilder builder) {
		super(builder.qty, builder.price);
		this.garment = builder.garment;
		this.gender = builder.gender;
		this.material = builder.material;
		this.specialInstruction = builder.specialInstruction;
		measurements = new ArrayList<>();
		do {
			measurements.add(builder.measure.next());
		} while(builder.measure.hasNext());
	}
	
	/*Builder for GarmentOrder*/
	public static class GarmentOrderBuilder extends OrderItem.OrderBuilder {
		private final Garment garment;
		private final Gender gender;
		private final Iterator<Measurement> measure;
		
		private String material = null;
		private String specialInstruction = null;
		
		public GarmentOrderBuilder(int qty, double price, Garment garment, Gender gender, Iterator<Measurement> measure) {
			super(qty, price);
			this.garment = garment;
			this.gender = gender;
			this.measure = measure;
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
	
	public Garment getGarment() {
		return this.garment;
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
	
	public BottomMeasurement getBottomMeasurement() {
		for(Measurement tempMeasure: measurements) {
			if(tempMeasure instanceof BottomMeasurement)
				return (BottomMeasurement) tempMeasure;
		}
		
		return null;
	}
	
	public TopMeasurement getTopMeasurement() {
		for(Measurement tempMeasure: measurements) {
			if(tempMeasure instanceof TopMeasurement)
				return (TopMeasurement) tempMeasure;
		}
		
		return null;
	}
	
	public void setGarmentType(Garment type) {
		this.garment = type;
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
	
	public boolean hasBottomMeasurement() {
		for(Measurement tempMeasure: measurements) {
			if(tempMeasure instanceof BottomMeasurement)
				return true;
		}
		
		return false;
	}
	
	public boolean hasTopMeasurement() {
		for(Measurement tempMeasure: measurements) {
			if(tempMeasure instanceof TopMeasurement)
				return true;
		}
		
		return false;
	}
}
 