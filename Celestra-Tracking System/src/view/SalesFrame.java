package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import controller.SalesController;
import objects.Sales;
import view.ItemFrame.doActionListener;

public class SalesFrame extends JFrame{
	private JTextField textField;
	
	private JButton btnOrder;
	private JButton btnItems;
	private JButton btnSales;
	private JButton btnChangePassword;
	private JButton btnExit;
	
	private JTable salesTable;
	private JScrollPane salesPane;
	private JPanel panel_2;
	
	private SalesController salesController;
	private DefaultTableModel salesTableModel;
	
	String headers[] = new String[]{"Receipt No.", "OrderDate", "Total Price", "Down Payment", "Status"};
	
	public SalesFrame() {
		salesController = new SalesController();
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#D3D27C"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#677B42"));
		panel.setBounds(0, 0, 292, 721);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		
		btnOrder = new JButton("Orders");
		btnOrder.setBounds(28, 209, 200, 50);
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrder.setBackground(Color.decode("#A8A76D"));
		btnOrder.setFocusPainted(false);
		btnOrder.setBorderPainted(false);
		btnOrder.addActionListener(new doActionListener());
		panel.add(btnOrder);
		
		btnItems = new JButton("Items");
		btnItems.setBounds(28, 280, 200, 50);
		btnItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnItems.setBackground(Color.decode("#A8A76D"));
		btnItems.setFocusPainted(false);
		btnItems.setBorderPainted(false);
		btnItems.addActionListener(new doActionListener());
		panel.add(btnItems);
		
		btnSales = new JButton("Sales");
		btnSales.setBounds(28, 352, 200, 50);
		btnSales.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSales.setBackground(Color.decode("#F4F2AB"));
		btnSales.setFocusPainted(false);
		btnSales.setBorderPainted(false);
		btnSales.addActionListener(new doActionListener());
		panel.add(btnSales);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(28, 424, 200, 50);
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangePassword.setBackground(Color.decode("#A8A76D"));
		btnChangePassword.setFocusPainted(false);
		btnChangePassword.setBorderPainted(false);
		btnChangePassword.addActionListener(new doActionListener());
		panel.add(btnChangePassword);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new doActionListener());
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(28, 612, 200, 50);
		btnExit.setBackground(Color.decode("#A8A76D"));
		btnExit.setFocusPainted(false);
		btnExit.setBorderPainted(false);
		panel.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(292, 0, 1070, 721);
		panel_1.setBackground(Color.decode("#E5EDB8"));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon icon;
		
		JButton btnViewDailyReport = new JButton("View Daily Report");
		btnViewDailyReport.setBounds(690, 7, 140, 68);
		btnViewDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		icon = new ImageIcon("src/images/sales.png");
		btnViewDailyReport.setIcon(icon);
		btnViewDailyReport.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnViewDailyReport.setHorizontalTextPosition(SwingConstants.CENTER);
		btnViewDailyReport.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnViewDailyReport.setContentAreaFilled(false);
		btnViewDailyReport.setBackground(Color.decode("#A8A76D"));
		//btnViewDailyReport.setFocusPainted(false);
		btnViewDailyReport.setBorderPainted(false);
		panel_1.setLayout(null);
		panel_1.add(btnViewDailyReport);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setBounds(40, 33, 300, 30);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(37, 500, 886, 183);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblOrderDetails = new JLabel("Transaction Details:");
		lblOrderDetails.setBounds(40, 472, 300, 16);
		lblOrderDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblOrderDetails);
		
		panel_2 = new JPanel();
		panel_2.setBounds(37, 75, 1000, 380);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		salesTableModel = new DefaultTableModel(headers, 0);
		salesTable = new JTable(salesTableModel);
		salesTable.setDefaultRenderer(salesTable.getColumnClass(0), new SalesCellRenderer());
		salesTable.setBounds(57, 126, 847, 302);
		if(salesPane != null) {
            panel_2.remove(salesPane);
        }
		/*try {
			salesTable = createTable(salesController.retrieveSalesList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		salesTable.setBounds(15, 50, 555, 240);
		salesPane = new JScrollPane(salesTable);
		panel_2.add(salesPane);
		
		JButton btnViewMonthlyReport = new JButton("View Monthly Report");
		icon = new ImageIcon("src/images/sales.png");
		btnViewMonthlyReport.setIcon(icon);
		btnViewMonthlyReport.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnViewMonthlyReport.setHorizontalTextPosition(SwingConstants.CENTER);
		btnViewMonthlyReport.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnViewMonthlyReport.setBounds(910, 7, 140, 68);
		btnViewMonthlyReport.setContentAreaFilled(false);
		btnViewMonthlyReport.setBackground(Color.decode("#A8A76D"));
		//btnViewMonthlyReport.setFocusPainted(false);
		btnViewMonthlyReport.setBorderPainted(false);
		panel_1.add(btnViewMonthlyReport);
		
		JButton btnViewWeeklyReport = new JButton("View Weekly Report");
		icon = new ImageIcon("src/images/sales.png");
		btnViewWeeklyReport.setIcon(icon);
		btnViewWeeklyReport.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnViewWeeklyReport.setHorizontalTextPosition(SwingConstants.CENTER);
		btnViewWeeklyReport.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnViewWeeklyReport.setBounds(800, 7, 140, 68);
		btnViewWeeklyReport.setContentAreaFilled(false);
		btnViewWeeklyReport.setBackground(Color.decode("#A8A76D"));
		//btnViewWeeklyReport.setFocusPainted(false);
		btnViewWeeklyReport.setBorderPainted(false);
		panel_1.add(btnViewWeeklyReport);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		
		this.setSize(screenWidth, screenHeight - taskBarSize);
		this.setResizable(false);
		this.setTitle("Celestra Tailoring and Embroidery");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			updateTable(salesController.retrieveSalesList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	public JTable createTable(Iterator<?> sales) {
		int size = 0;
		List<Sales> list = new ArrayList<Sales>();
		while(sales.hasNext()) {
			list.add((Sales) sales.next());
			size++;
		}
		
		JTable salesListTable = new UneditableJTable(size, 5);
		
		
		TableColumnModel columnModel = salesListTable.getColumnModel();
		TableModel model = salesListTable.getModel();
		
		
		String[] headers = new String[]{"Receipt No.", "OrderDate", "Total Price", "Down Payment", "Status"};		
		
		for(int i = 0; i < salesListTable.getColumnCount(); i++) {
			TableColumn column = salesListTable.getTableHeader().getColumnModel().getColumn(i);
			column.setHeaderValue(headers[i]);
			columnModel.getColumn(i).setWidth(111);
		}
		
		for(int i = 0; i < list.size(); i++) {
			model.setValueAt(list.get(i).getOrderList().getReceiptNo(), i, 0);
			model.setValueAt(list.get(i).getOrderList().getOrderDate(), i, 1);
			model.setValueAt(list.get(i).getOrderList().getTotalPrice(), i, 2);
			model.setValueAt(list.get(i).getOrderList().getBalance(), i, 3);
			model.setValueAt(list.get(i).getOrderList().getStatus(), i, 4);
		}
		
		return salesListTable;
	}*/
	
	public void updateTable(Iterator<?> SalesList){
		//salesTable is the JTable
		//salesTableModel is the DefaultTableModel
		for(int i = salesTable.getRowCount(); i != 0 ; i--) {

			salesTableModel.removeRow(i - 1);
		}
		
		//salesTableModel = new DefaultTableModel(headers, 0);
		while(SalesList.hasNext()) {
			Sales saleToAdd = (Sales)SalesList.next();
			Object[] rowData = new Object[5];
			
			rowData[0] = saleToAdd;
			rowData[1] = saleToAdd;
			rowData[2] = saleToAdd;
			rowData[3] = saleToAdd;
			rowData[4] = saleToAdd;
			
			salesTableModel.addRow(rowData);
		}
	}
	
	public class doActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnOrder) {
				new OrderFrame();
				dispose();
			} else if(e.getSource() == btnItems) {
				new ItemFrame();
				dispose();
			} else if(e.getSource() == btnSales) {
				//nothing happens. stays on this frame.
			} else if(e.getSource() == btnChangePassword) {
				new ChangePassword();
			} else if(e.getSource() == btnExit) {
				new Login();
				dispose();
			}
			
		}
	}
}
