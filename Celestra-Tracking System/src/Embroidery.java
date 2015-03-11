import java.awt.Image;


public class Embroidery extends OrderItem {
	private Image logo;
	private double size;
	private int numOfColors;
	private String embroideryType;
	
	public Embroidery(int qty, double price, Image logo, double size, int numOfColors, String type) {
		super(qty, price);
		this.logo = logo;
		this.size = size;
		this.numOfColors = numOfColors;
		this.embroideryType = type;
	}
	
	public Image getLogo() {
		return this.logo;
	}
	
	public double getSize() {
		return this.size;
	}
	
	public int getNumOfColors() {
		return this.numOfColors;
	}
	
	public String getEmbroideryType() {
		return this.embroideryType;
	}
	
	public void setLogo(Image logo) {
		this.logo = logo;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public void setNumOfColors(int num) {
		this.numOfColors = num;
	}
	
	public void setEmbroideryType(String type) {
		this.embroideryType = type;
	}
}
