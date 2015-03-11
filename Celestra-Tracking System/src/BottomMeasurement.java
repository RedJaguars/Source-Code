
public class BottomMeasurement extends Measurement{
	private double bottomLength;
	private double waist;
	private double hips;
	private double thigh;
	private double knee;
	private double buttom;
	private double crotch;
	
	public BottomMeasurement(double bottomLength, double waist, double hips, double thigh, 
							double knee, double buttom, double crotch) {
		super();
		this.bottomLength = bottomLength;
		this.waist = waist;
		this.hips = hips;
		this.thigh = thigh;
		this.knee = knee;
		this.buttom = buttom;
		this.crotch = crotch;
	}
	
	public double getBottomLength() {
		return bottomLength;
	}

	public void setBottomLength(double bottomLength) {
		this.bottomLength = bottomLength;
	}

	public double getWaist() {
		return waist;
	}

	public void setWaist(double bottomWaist) {
		this.waist = bottomWaist;
	}
	
	public double getHips() {
		return hips;
	}
	
	public void setHips(double hips) {
		this.hips = hips;
	}

	public double getThigh() {
		return thigh;
	}

	public void setThigh(double thigh) {
		this.thigh = thigh;
	}

	public double getKnee() {
		return knee;
	}

	public void setKnee(double knee) {
		this.knee = knee;
	}

	public double getButtom() {
		return buttom;
	}

	public void setButtom(double buttom) {
		this.buttom = buttom;
	}

	public double getCrotch() {
		return crotch;
	}

	public void setCrotch(double crotch) {
		this.crotch = crotch;
	}
}
