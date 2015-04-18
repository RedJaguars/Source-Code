package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

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
import java.awt.event.MouseListener;

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
import view.SalesFrame.doActionListener;
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
	private JButton btnModifyOrder;
	private JButton btnAddOrder;
	private JButton btnCancelOrder;
	
	private JList  clientOrderList;
	private OrderList selectedOrderList;
	
	private OrderController orderController;
	
	private JPanel panelList, panel_1;
	
	public OrderFrame() {
		orderController = new OrderController();
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#D3D27C"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#677B42"));
		panel.setBounds(0, 0, 292, 721);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		
		btnOrder = new JButton("Orders");
		btnOrder.setBounds(30, 209, 200, 50);
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrder.setBackground(Color.decode("#F4F2AB"));
		btnOrder.setFocusPainted(false);
		btnOrder.setBorderPainted(false);
		btnOrder.addActionListener(new doActionListener());
		panel.add(btnOrder);
		
		btnItems = new JButton("Items");
		btnItems.setBounds(30, 280, 200, 50);
		btnItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnItems.setBackground(Color.decode("#A8A76D"));
		btnItems.setFocusPainted(false);
		btnItems.setBorderPainted(false);
		btnItems.addActionListener(new doActionListener());
		panel.add(btnItems);
		
		btnSales = new JButton("Sales");
		btnSales.setBounds(30, 352, 200, 50);
		btnSales.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSales.setBackground(Color.decode("#A8A76D"));
		btnSales.setFocusPainted(false);
		btnSales.setBorderPainted(false);
		btnSales.addActionListener(new doActionListener());
		panel.add(btnSales);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(30, 424, 200, 50);
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangePassword.setBackground(Color.decode("#A8A76D"));
		btnChangePassword.setFocusPainted(false);
		btnChangePassword.setBorderPainted(false);
		btnChangePassword.addActionListener(new doActionListener());
		panel.add(btnChangePassword);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new doActionListener());
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(30, 612, 200, 50);
		btnExit.setBackground(Color.decode("#A8A76D"));
		btnExit.setFocusPainted(false);
		btnExit.setBorderPainted(false);
		panel.add(btnExit);
		
		panel_1 = new JPanel();
		panel_1.setBounds(292, 0, 1070, 721);
		panel_1.setBackground(Color.decode("#E5EDB8"));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon icon;
		
		btnAddOrder = new JButton("Add");
		btnAddOrder.addActionListener(new doActionListener());
		icon = new ImageIcon("src/images/add.png");
		btnAddOrder.setIcon(icon);
		btnAddOrder.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnAddOrder.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddOrder.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//btnAddOrder.setFocusPainted(false);
		btnAddOrder.setBorderPainted(false);
		btnAddOrder.setContentAreaFilled(false);
		btnAddOrder.setBounds(720, 7, 70, 68);
		panel_1.add(btnAddOrder);
		
		JLabel lblNewLabel = new JLabel("Orders");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(40, 33, 150, 21);
		panel_1.add(lblNewLabel);
		
		btnChangeStatus = new JButton("Change Status");
		btnChangeStatus.addActionListener(new doActionListener());
		icon = new ImageIcon("src/images/change.png");
		btnChangeStatus.setIcon(icon);
		btnChangeStatus.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnChangeStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChangeStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnChangeStatus.setIcon(icon);
		//btnChangeStatus.setFocusPainted(false);
		btnChangeStatus.setBorderPainted(false);
		btnChangeStatus.setContentAreaFilled(false);;
		btnChangeStatus.setBounds(930, 7, 120, 68);
		//btnChangeStatus.setEnabled(false);
		panel_1.add(btnChangeStatus);
		
		JButton btnCancelOrder = new JButton("Cancel");
		icon = new ImageIcon("src/images/cancel.png");
		btnCancelOrder.setIcon(icon);
		btnCancelOrder.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnCancelOrder.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelOrder.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//btnCancelOrder.setFocusPainted(false);
		btnCancelOrder.setBorderPainted(false);
		btnCancelOrder.setContentAreaFilled(false);
		btnCancelOrder.setBounds(798, 7, 70, 68);
		panel_1.add(btnCancelOrder);
		
		btnModifyOrder = new JButton("Modify");
		btnModifyOrder.addActionListener(new doActionListener());
		icon = new ImageIcon("src/images/modify.png");
		btnModifyOrder.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnModifyOrder.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModifyOrder.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifyOrder.setIcon(icon);
		//btnModifyOrder.setFocusPainted(false);
		btnModifyOrder.setBorderPainted(false);
		btnModifyOrder.setContentAreaFilled(false);
		btnModifyOrder.setBounds(870, 7, 80, 68);
		//btnModifyOrder.setEnabled(false);
		panel_1.add(btnModifyOrder);
		
		txtAreaOrderDetails = new JTextArea();
		txtAreaOrderDetails.setBounds(37, 500, 500, 183);
		panel_1.add(txtAreaOrderDetails);
		txtAreaOrderDetails.setColumns(10);
		txtAreaOrderDetails.setEditable(false);
		
		JLabel lblOrderDetails = new JLabel("Order Details:");
		lblOrderDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOrderDetails.setBounds(40, 472, 150, 16);
		panel_1.add(lblOrderDetails);
		
		panelList = new JPanel();
		panelList.setBackground(Color.decode("#C8CF9B"));
		panelList.setBounds(565, 500, 470, 183);
		panel_1.add(panelList);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(37, 75, 1000, 380);
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
        tableOrder.setBounds(10, 50, 555, 240);
        orderPane = new JScrollPane(tableOrder);
        panel_2.add(orderPane);
		
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
			} else if(e.getSource() == btnExit) {
				new Login();
				dispose();
			} else if(e.getSource() == btnModifyOrder) {
				new ModifyOrder(selectedOrderList);
			} else if(e.getSource() == btnAddOrder) {
				new AddOrderFrame();
			}
//			else if(e.getSource() == btnCancelOrder){
//				orderController.cancelOrder(tableOrder.getModel());
//				
//			}
			
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
						//txtAreaOrderDetails.setText(orderController.getOrderListData(selectedRow));
						createJList();
						setSelectedOrderList(orderController.getSelectedOrderList(selectedRow));
						btnChangeStatus.setEnabled(true);
						btnModifyOrder.setEnabled(true);
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
	
	public void setSelectedOrderList(OrderList orderList) {
		selectedOrderList = orderList;
	}
	
	public void createJList() {
		ArrayList<Integer> orderItemIdList;
		Integer[] list = null;
		try {
			orderItemIdList = orderController.getOrderItemIDList(selectedOrderList);
			list = new Integer[orderItemIdList.size()];
			list = orderItemIdList.toArray(list);
			clientOrderList = new JList(list);
			clientOrderList.setFont(new Font("Tahoma",Font.PLAIN, 13));
			clientOrderList.addMouseListener(new ClickActionListener());
			clientOrderList.setBounds(565, 500, 470, 183);
			panel_1.remove(panelList);
			panel_1.add(clientOrderList);
			panel_1.revalidate();
			panel_1.repaint();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class ClickActionListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getClickCount() == 1) {
				int index = clientOrderList.locationToIndex(e.getPoint());
				try {
					int itemID = (int) clientOrderList.getSelectedValue();
					String orderDetails = orderController.getOrderItemDetails(selectedOrderList, index, itemID);
					txtAreaOrderDetails.setText(orderDetails);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}