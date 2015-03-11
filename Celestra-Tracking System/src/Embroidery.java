import javax.swing.ImageIcon;

public class Embroidery extends OrderItem {
	private ImageIcon logo;
	private double size;
	private int numOfColors;	
	private String embroideryType;
	private byte[] logoBytes;
	
	public Embroidery(int qty, double price, byte[] logo, double size, int numOfColors, String type) {
		super(qty, price);
		this.logo = new ImageIcon(logo);
		this.logoBytes = logo;
		this.size = size;
		this.numOfColors = numOfColors;
		this.embroideryType = type;
	}
	
	public ImageIcon getLogo() {
		return this.logo;
	}
	
	public byte[] getLogoBytes() {
		return this.logoBytes;
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
	
	public void setLogo(byte[] logo) {
		this.logo = new ImageIcon(logo);
		this.logoBytes = logo;
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
