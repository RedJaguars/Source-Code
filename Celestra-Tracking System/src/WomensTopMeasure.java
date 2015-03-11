
public class WomensTopMeasure extends TopMeasurement{
	private double frontFigure;
	private double bustPoint;
	private double bustDistance;
	private double backFigure;
	
	public WomensTopMeasure(double upperLength, double shoulder, double armLength, double wrist,
			double armHole, double chest, double frontChest, double backChest,
			double waist, double hips, double neckDeep, double frontFigure, double bustPoint,
			double bustDistance, double backFigure) {
		super(upperLength, shoulder, armLength, wrist, armHole, chest, frontChest, backChest, waist, hips, neckDeep);
		this.frontFigure = frontFigure;
		this.bustDistance = bustDistance;
		this.bustPoint = bustPoint;
		this.backFigure = backFigure;
	}
	
	public double getBustDistance() {
		return bustDistance;
	}

	public void setBustDistance(double bustDistance) {
		this.bustDistance = bustDistance;
	}

	public double getBustPoint() {
		return bustPoint;
	}

	public void setBustPoint(double bustPoint) {
		this.bustPoint = bustPoint;
	}
	
	public double getFrontFigure() {
		return frontFigure;
	}

	public void setFrontFigure(double frontFigure) {
		this.frontFigure = frontFigure;
	}
	
	public double getBackFigure() {
		return backFigure;
	}

	public void setBackFigure(double backFigure) {
		this.backFigure = backFigure;
	}

}
