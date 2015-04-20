package view;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import objects.Sales;

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
		Sales saleContent = (Sales)value;
		this.value = value;
		
		switch(column) {
			case 0: content = new JLabel(""+saleContent.getOrderList().getReceiptNo()); break;
			case 1: content = new JLabel(saleContent.getOrderList().getOrderDate().toString()); break;
			case 2: content = new JLabel(""+saleContent.getOrderList().getTotalPrice()); break;
			case 3: content = new JLabel(""+saleContent.getOrderList().getBalance()); break;
			case 4: content = new JLabel(saleContent.getOrderList().getStatus().toString()); break;
			default: content = new JLabel("Something went wrong here");
		}
		
		return content;
	}

}
