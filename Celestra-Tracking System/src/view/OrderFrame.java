package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import objects.Material;
import objects.OrderItem;
import objects.OrderList;
import objects.OrderList.OrderListBuilder;
import controller.OrderController;

public class OrderFrame extends JFrame{
	private int selectedRow;
	
	private JTextArea txtAreaOrderDetails;
	private JTable tableOrder;
	private JScrollPane orderPane;
	
	private JButton btnOrder;
	private JButton btnItems;
	private JButton btnSales;
	private JButton btnChangePassword;
	private JButton btnChangeStatus;
	private JButton btnExit;
	
	private OrderController orderController;
	
	public OrderFrame() {
		orderController = new OrderController();
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 292, 721);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnOrder = new JButton("Order");
		btnOrder.setBounds(28, 209, 200, 50);
		btnOrder.addActionListener(new doActionListener());
		panel.add(btnOrder);
		
		btnItems = new JButton("Items");
		btnItems.setBounds(28, 280, 200, 50);
		btnItems.addActionListener(new doActionListener());
		panel.add(btnItems);
		
		btnSales = new JButton("Sales");
		btnSales.setBounds(28, 352, 200, 50);
		btnSales.addActionListener(new doActionListener());
		panel.add(btnSales);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(28, 424, 200, 50);
		btnChangePassword.addActionListener(new doActionListener());
		panel.add(btnChangePassword);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new doActionListener());
		btnExit.setBounds(28, 612, 200, 50);
		panel.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(293, 0, 969, 721);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_4 = new JButton("Add New Order");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_4.setBounds(739, 40, 200, 50);
		panel_1.add(button_4);
		
		JLabel lblNewLabel = new JLabel("Orders");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 57, 150, 16);
		panel_1.add(lblNewLabel);
		
		txtAreaOrderDetails = new JTextArea();
		txtAreaOrderDetails.setBounds(53, 500, 557, 183);
		panel_1.add(txtAreaOrderDetails);
		txtAreaOrderDetails.setColumns(10);
		txtAreaOrderDetails.setEditable(false);
		
		JLabel lblOrderDetails = new JLabel("Order Details");
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrderDetails.setBounds(53, 458, 150, 16);
		panel_1.add(lblOrderDetails);
		
		btnChangeStatus = new JButton("Change Status");
		btnChangeStatus.addActionListener(new doActionListener());
		btnChangeStatus.setBounds(704, 500, 200, 50);
		btnChangeStatus.setEnabled(false);
		panel_1.add(btnChangeStatus);
		
		JButton button_6 = new JButton("Cancel Order");
		button_6.setBounds(704, 563, 200, 50);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("Modify Order");
		button_7.setBounds(704, 626, 200, 50);
		panel_1.add(button_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(57, 126, 847, 302);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tableOrder = new JTable();
		tableOrder.setBounds(57, 126, 847, 302);
		if(orderPane != null) {
            panel_2.remove(orderPane);
        }
        try {
        	tableOrder = createTable(orderController.retrieveOrderList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        tableOrder.setBounds(15, 50, 555, 240);
        orderPane = new JScrollPane(tableOrder);
        panel_2.add(orderPane);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		
		this.setSize(screenWidth, screenHeight - taskBarSize);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public class doActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnOrder) {
				//nothing happens. stays on this frame.
			} else if(e.getSource() == btnItems) {
				new ItemFrame();
				dispose();
			} else if(e.getSource() == btnSales) {
				new SalesFrame();
				dispose();
			} else if(e.getSource() == btnChangePassword) {
				new ChangePassword();
			} else if(e.getSource() == btnChangeStatus) {
				new ChangeOrderStatus(selectedRow);
				dispose();
			} else if(e.getSource() == btnExit) {
				new Login();
				dispose();
			}
			
		}
	}
	
	public JTable createTable(Iterator<?> orderList) {
		int size = 0;
		List<OrderList> list = new ArrayList<OrderList>();
		while(orderList.hasNext()) {
			list.add((OrderList) orderList.next());
			size++;
		}
		
		JTable orderItemListTable = new UneditableJTable(size, 7);
		orderItemListTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					JTable target = (JTable)e.getSource();
					selectedRow = target.getSelectedRow();
					try {
						txtAreaOrderDetails.setText(orderController.getData(selectedRow));
						btnChangeStatus.setEnabled(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		TableColumnModel columnModel = orderItemListTable.getColumnModel();
		TableModel model = orderItemListTable.getModel();
		
		String[] header = {"Receipt No.", "Due Date", "Order Date", "Balance", "Pickup Location", "Client", "Status"};
		
		for(int i = 0; i < orderItemListTable.getColumnCount(); i++) {
			TableColumn column = orderItemListTable.getTableHeader().getColumnModel().getColumn(i);
			column.setHeaderValue(header[i]);
			columnModel.getColumn(i).setWidth(111);
		}
		
		for(int i = 0; i < list.size(); i++) {
			model.setValueAt(list.get(i).getReceiptNo(), i, 0);
			model.setValueAt(list.get(i).getDueDate(), i, 1);
			model.setValueAt(list.get(i).getOrderDate(), i, 2);
			model.setValueAt(list.get(i).getBalance(), i, 3);
			model.setValueAt(list.get(i).getPickupLocation(), i, 4);
			model.setValueAt(list.get(i).getClient().getLastName(), i, 5);
			model.setValueAt(list.get(i).getStatus(), i, 6);
		}
		
		return orderItemListTable;
	}
}
