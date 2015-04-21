package view;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import objects.SalesInfo;

public class SalesCellEditor extends AbstractCellEditor implements
		TableCellEditor {
	
	private static final long serialVersionUID = 1L;
	private Object value;
	
	public SalesCellEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1,
			boolean arg2, int row, int column) {
		JLabel content;
		value = arg1;
		SalesInfo saleContent = (SalesInfo)arg1;
		
		switch(column) {
			case 0: content = new JLabel(saleContent.getUnit()); break;
			case 1: content = new JLabel(""+saleContent.getTotalPrice()); break;
			case 2: content = new JLabel(""+saleContent.getBalance()); break;
			default: content = new JLabel("Something went wrong here");
		}
		
		return content;
	}

}
