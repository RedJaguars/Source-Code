package pojo;
public class TopMeasurement extends Measurement{
	private double upperLength;
	private double shoulder;
	private double armLength;
	private double wrist;
	private double armHole;
	private double frontChest;
	private double backChest;
	private double waist;
	private double hips;
	private double neckDeep;
	
	public TopMeasurement(TopMeasurementBuilder builder) {
		super(builder);
		this.upperLength = builder.upperLength;
		this.shoulder = builder.shoulder;
		this.armLength = builder.armLength;
		this.wrist = builder.wrist;
		this.armHole = builder.armHole;
		this.frontChest = builder.frontChest;
		this.backChest = builder.backChest;
		this.waist = builder.waist;
		this.hips = builder.hips;
		this.neckDeep = builder.neckDeep;
	}
	
	public static class TopMeasurementBuilder extends Measurement.MeasurementBuilder {
		private double upperLength;
		private double shoulder;
		private double armLength;
		private double wrist;
		private double armHole;
		private double frontChest;
		private double backChest;
		private double waist;
		private double hips;
		private double neckDeep;
		
		public TopMeasurementBuilder(double upperLength, double shoulder, double armLength, double wrist,
							double armHole, double frontChest, double backChest,
							double waist, double hips, double neckDeep) {
			this.upperLength = upperLength;
			this.shoulder = shoulder;
			this.armLength = armLength;
			this.wrist = wrist;
			this.armHole = armHole;
			this.frontChest = frontChest;
			this.backChest = backChest;
			this.waist = waist;
			this.hips = hips;
			this.neckDeep = neckDeep;
		}
		
		public TopMeasurement build() {
			return new TopMeasurement(this);
		}
	}
	
	public double getUpperLength() {
		return upperLength;
	}

	public void setUpperLength(double upperLength) {
		this.upperLength = upperLength;
	}

	public double getShoulder() {
		return shoulder;
	}

	public void setShoulder(double shoulder) {
		this.shoulder = shoulder;
	}
	
	public double getFrontChest() {
		return frontChest;
	}
	
	public void setFrontChest(double frontChest) {
		this.frontChest = frontChest;
	}
	
	public double getBackChest() {
		return backChest;
	}
	
	public void setBackChest(double backChest) {
		this.backChest = backChest;
	}

	public double getWaist() {
		return waist;
	}

	public void setWaist(double upperWaist) {
		this.waist = upperWaist;
	}

	public double getHips() {
		return hips;
	}

	public void setHips(double upperHips) {
		this.hips = upperHips;
	}

	public double getArmLength() {
		return armLength;
	}

	public void setArmLength(double armLength) {
		this.armLength = armLength;
	}

	public double getArmHole() {
		return armHole;
	}

	public void setArmHole(double armHole) {
		this.armHole = armHole;
	}
	
	public double getWrist() {
		return this.wrist;
	}
	
	public void setWrist(double wrist) {
		this.wrist = wrist;
	}
	
	public double getNeckDeep() {
		return neckDeep;
	}
	
	public void setNeckDeep(double neckDeep) {
		this.neckDeep = neckDeep;
	}
}
