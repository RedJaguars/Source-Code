package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.UIManager;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import controller.SalesController;
import objects.OrderList;
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
	
	private SalesController salesController;
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
		
		btnOrder = new JButton("Order");
		btnOrder.setBounds(28, 209, 200, 50);
		btnOrder.setBackground(Color.decode("#A8A76D"));
		btnOrder.setFocusPainted(false);
		btnOrder.setBorderPainted(false);
		btnOrder.addActionListener(new doActionListener());
		panel.add(btnOrder);
		
		btnItems = new JButton("Items");
		btnItems.setBounds(28, 280, 200, 50);
		btnItems.setBackground(Color.decode("#A8A76D"));
		btnItems.setFocusPainted(false);
		btnItems.setBorderPainted(false);
		btnItems.addActionListener(new doActionListener());
		panel.add(btnItems);
		
		btnSales = new JButton("Sales");
		btnSales.setBounds(28, 352, 200, 50);
		btnSales.setBackground(Color.decode("#F4F2AB"));
		btnSales.setFocusPainted(false);
		btnSales.setBorderPainted(false);
		btnSales.addActionListener(new doActionListener());
		panel.add(btnSales);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(28, 424, 200, 50);
		btnChangePassword.setBackground(Color.decode("#A8A76D"));
		btnChangePassword.setFocusPainted(false);
		btnChangePassword.setBorderPainted(false);
		btnChangePassword.addActionListener(new doActionListener());
		panel.add(btnChangePassword);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new doActionListener());
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
		btnViewDailyReport.setBounds(324, 42, 200, 50);
		btnViewDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		icon = new ImageIcon("src/images/sales.png");
		btnViewDailyReport.setIcon(icon);
		btnViewDailyReport.setContentAreaFilled(false);
		btnViewDailyReport.setBackground(Color.decode("#A8A76D"));
		//btnViewDailyReport.setFocusPainted(false);
		btnViewDailyReport.setBorderPainted(false);
		panel_1.setLayout(null);
		panel_1.add(btnViewDailyReport);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setBounds(53, 57, 115, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(53, 500, 886, 183);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblOrderDetails = new JLabel("Transaction Details");
		lblOrderDetails.setBounds(53, 458, 100, 16);
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblOrderDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(53, 114, 886, 314);
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		salesTable = new JTable();
		try {
			salesTable = createTable(salesController.retrieveSalesList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salesPane =new JScrollPane(salesTable);
		salesPane.setBounds(0, 0, 886, 314);
		
		panel_2.add(salesPane);
		
		
		
		JButton btnViewMonthlyReport = new JButton("View Monthly Report");
		icon = new ImageIcon("src/images/sales.png");
		btnViewMonthlyReport.setIcon(icon);
		btnViewMonthlyReport.setBounds(733, 42, 200, 50);
		btnViewMonthlyReport.setContentAreaFilled(false);
		btnViewMonthlyReport.setBackground(Color.decode("#A8A76D"));
		//btnViewMonthlyReport.setFocusPainted(false);
		btnViewMonthlyReport.setBorderPainted(false);
		panel_1.add(btnViewMonthlyReport);
		
		JButton btnViewWeeklyReport = new JButton("View Weekly Report");
		icon = new ImageIcon("src/images/sales.png");
		btnViewWeeklyReport.setIcon(icon);
		btnViewWeeklyReport.setBounds(529, 42, 200, 50);
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
	}
	
		
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
