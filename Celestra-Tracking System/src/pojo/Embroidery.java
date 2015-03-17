package pojo;
import javax.swing.ImageIcon;

public class Embroidery extends OrderItem {
	private ImageIcon logo;
	private double size;
	private int numOfColors;	
	private EmbroideryType embroideryType;
	private byte[] logoBytes;
	
	public Embroidery(EmbroideryBuilder builder) {
		super(builder.qty, builder.price);
		this.logo = new ImageIcon(builder.logo);
		this.logoBytes = builder.logo;
		this.size = builder.size;
		this.numOfColors = builder.numOfColors;
		this.embroideryType = builder.type;
		this.itemID = builder.orderID;
	}
	
	public static class EmbroideryBuilder extends OrderItem.OrderBuilder {
		private final byte[] logo;
		private final double size;
		private final int numOfColors;
		private final EmbroideryType type;
		
		public EmbroideryBuilder(int qty, double price, byte[] logo, double size, int numOfColors, EmbroideryType type) {
			super(qty, price);
			this.logo = logo;
			this.size = size;
			this.numOfColors = numOfColors;
			this.type = type;
		}
		
		public OrderItem build() {
			return new Embroidery(this);
		}
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
	
	public EmbroideryType getEmbroideryType() {
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
	
	public void setEmbroideryType(EmbroideryType type) {
		this.embroideryType = type;
	}
}
