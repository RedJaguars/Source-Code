package objects;

import java.util.ArrayList;
import java.util.Iterator;

public class SalesInfo {

	private double balance;
	private double total;
	private String unit;
	private ArrayList<Sales> salesList;
	
	public SalesInfo(double balance, double total, String unit) {
		salesList = new ArrayList<>();
		this.balance = balance;
		this.total = total;
		this.unit = unit;
	}
	
	public SalesInfo(String unit) {
		salesList = new ArrayList<>();
		this.balance = 0.0;
		this.total = 0.0;
		this.unit = unit;
	}
	
	public Iterator<?> getSales() {
		return salesList.iterator();
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
	
	public void addToSales(Sales toAdd) {
		salesList.add(toAdd);
	}
}
