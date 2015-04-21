package objects;

public class SalesInfo {

	private double balance;
	private double total;
	private String unit;
	
	public SalesInfo(double balance, double total, String unit) {
		this.balance = balance;
		this.total = total;
		this.unit = unit;
	}
	
	public SalesInfo(String unit) {
		this.balance = 0.0;
		this.total = 0.0;
		this.unit = unit;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getTotalPrice() {
		return this.total;
	}
	
	public String getUnit() {
		return this.unit;
	}
	
	public void addToBalance(double toAdd) {
		balance += toAdd;
	}
	
	public void addToTotal(double toAdd) {
		total +=toAdd;
	}
}
