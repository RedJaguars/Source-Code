package objects;

public abstract class Measurement {
	protected int measurementID;
	
	protected Measurement(MeasurementBuilder builder) {
		this.measurementID = builder.id;
	}
	
	public abstract static class MeasurementBuilder {
		protected int id = 0;
		
		public MeasurementBuilder() {
			
		}
		
		public MeasurementBuilder measurementID(int id) {
			this.id = id;
			return this;
		}
		
		public abstract Measurement build();
	}
	
	public int getID() {
		return this.measurementID;
	}
	
	public void setID(int id) {
		this.measurementID = id;
	}
}
