package view;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import objects.Sales;
import objects.SalesInfo;

public class SalesCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object value;
	public SalesCellRenderer() {
		// TODO Auto-generated constructor stub
	}
	
	public Object getValue() {
		return this.value;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		JLabel content;
		SalesInfo saleContent = (SalesInfo)value;
		this.value = value;
		
		switch(column) {
			case 0: content = new JLabel(saleContent.getUnit()); break;
			case 1: content = new JLabel(""+saleContent.getTotalPrice()); break;
			case 2: content = new JLabel(""+saleContent.getBalance()); break;
			default: content = new JLabel("Something went wrong here");
		}
		
		return content;
	}

}
