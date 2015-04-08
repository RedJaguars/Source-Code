package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.*;
import objects.OrderList;
import controller.OrderController;

public class ChangeOrderStatus extends JFrame{
	private JTextArea txtAreaOrderStatus;
	private JFormattedTextField textField;
	private NumberFormat numberFormat;
	
	private JRadioButton cancelled;
	private JRadioButton pending;
	private JRadioButton fulfilled;
	private ButtonGroup status;
	
	
	private JButton btnSubmit;
	private JButton btnCancel;
	
	private int selectedRow;
	
	private OrderController orderController;
	
	public ChangeOrderStatus(int row) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		
		selectedRow = row;
		
		orderController = new OrderController();
		
		getContentPane().setLayout(null);
		
		JLabel lblAddNewItem = new JLabel("Change Order Status");
		lblAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddNewItem.setBounds(25, 53, 209, 30);
		getContentPane().add(lblAddNewItem);
		
		status = new ButtonGroup();
		pending = new JRadioButton("PENDING", true);
		cancelled = new JRadioButton("CANCELLED");
		fulfilled = new JRadioButton("FULFILLED");
		pending.setBounds(30, 165, 100, 20);
		cancelled.setBounds(130, 165, 130, 20);
		fulfilled.setBounds(260, 165, 100, 20);
		pending.setActionCommand("PENDING");
		cancelled.setActionCommand("CANCELLED");
		fulfilled.setActionCommand("FULFILLED");
		status.add(pending);
		status.add(cancelled);
		status.add(fulfilled);
		
		getContentPane().add(pending);
		getContentPane().add(cancelled);
		getContentPane().add(fulfilled);
		
//		txtAreaOrderStatus = new JTextArea();
//		txtAreaOrderStatus.setColumns(10);
//		txtAreaOrderStatus.setBounds(29, 165, 367, 212);
//		getContentPane().add(txtAreaOrderStatus);
		
//		textField_2 = new JFormattedTextField(numberFormat);
//		textField_2.setColumns(10);
//		textField_2.setBounds(155, 417, 241, 22);
//		getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Order Details:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 115, 103, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblQuantity = null;
		try {
			lblQuantity = new JLabel("Current balance:" + orderController.getSelectedOrderList(selectedRow).getBalance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(25, 420, 200, 16);
		getContentPane().add(lblQuantity);
		
		
		
		
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new doActionListener());
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(51, 535, 149, 36);
		getContentPane().add(btnSubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new doActionListener());
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(231, 535, 149, 36);
		getContentPane().add(btnCancel);
		
		JLabel lblNewBalance = new JLabel("New Balance: ");
		lblNewBalance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewBalance.setBounds(25, 460, 118, 16);
		getContentPane().add(lblNewBalance);
		
		textField = new JFormattedTextField(numberFormat);
		textField.setColumns(10);
		textField.setBounds(155, 458, 241, 22);
		getContentPane().add(textField);
		
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
			if(e.getSource() == btnSubmit) {
				//checks if successfully altered
				OrderList originalOrderList = null;
				String selectedStatus;
				selectedStatus =  status.getSelection().getActionCommand();
				
				try {
					originalOrderList = orderController.getSelectedOrderList(selectedRow);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {

					orderController.modifyOrder(originalOrderList, orderController.createModifiedOrderList(originalOrderList, selectedStatus, Double.parseDouble(textField.getText())));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new OrderFrame();
				dispose();
			} else if(e.getSource() == btnCancel) {
				new OrderFrame();
				dispose();
			} 
			
		}
	}
}
