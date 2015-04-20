package view;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import objects.OrderList;

public class OrderTableCellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	private Object value;
	public OrderTableCellRenderer() {
		// TODO Auto-generated constructor stub
	}
	
	public Object getValue() {
		return this.value;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		JLabel content;
		OrderList orderContent = (OrderList)value;
		this.value = value;
		
		switch(column) {
			case 0: content = new JLabel(""+orderContent.getReceiptNo()); break;
			case 1: content = new JLabel(orderContent.getOrderDate().toString()); break;
			case 2: content = new JLabel(orderContent.getStatus().toString()); break;
			default: content = new JLabel("Something went wrong here");
		}
		
		return content;
	}
}
