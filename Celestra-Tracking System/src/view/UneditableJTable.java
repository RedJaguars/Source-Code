package view;

import javax.swing.JTable;

public class UneditableJTable extends JTable {

	private static final long serialVersionUID = 8936551049667332177L;
	
	public UneditableJTable(int row, int column) {
            super(row, column);
	}
	
	public boolean isCellEditable(int row, int col) {
            return false;
	}
}
