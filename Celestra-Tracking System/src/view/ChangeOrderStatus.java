package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import objects.OrderList;
import controller.OrderController;

public class ChangeOrderStatus extends JFrame{
	private JButton btnBack, btnConfirm, btnCancel;
	private JList orderList;
	private JRadioButton rbPending, rbFulfilled;
	private ButtonGroup bgStatus;
	private JTextField txtAmountDue;
	private JLabel lblTotalAmountDue, lblTotalAmountDue2, lblInitialDeposit, lblInitialDeposit2, lblRemainingBalance, lblRemainingBalance2, lblAmountDue;;
	private JLabel lblOrderDetails, lblChangeStatus, lblHeader;
	private JPanel panel_1;
	private OrderController orderController;
	private int selectedRow;
	private double totalAmount;
	private double balance;
	OrderFrame mainFrame;
	
	public ChangeOrderStatus(int row, OrderFrame orderFrame) {
		mainFrame = orderFrame;
		orderController = new OrderController();
		try {
			totalAmount =  orderController.getSelectedOrderList(row).getTotalPrice();
			balance = orderController.getSelectedOrderList(row).getBalance();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#D3D27C"));
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		
		selectedRow = row;
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#677B42"));
		panel.setBounds(0, 0, 200, 721);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		ImageIcon icon;
		
		btnBack = new JButton("Go Back");
		btnBack.setBounds(70, 10, 150, 50);
		icon = new ImageIcon("src/images/back.png");
		btnBack.setIcon(icon);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBackground(Color.decode("#A8A76D"));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(new doActionListener());
		panel.add(btnBack);
		
		panel_1 = new JPanel();
		panel_1.setBounds(200, 0, 1200, 721);
		panel_1.setBackground(Color.decode("#E5EDB8"));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblHeader = new JLabel("Change Order Status");
		lblHeader.setBounds(40,10,250,40);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblHeader);
		
		lblChangeStatus = new JLabel("Change Status:");
		lblChangeStatus.setBounds(40,50,150,40);
		lblChangeStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblChangeStatus);
		
		rbPending = new JRadioButton("Pending");
		rbFulfilled = new JRadioButton("Fulfilled");
		rbFulfilled.setEnabled(false);
		rbPending.setSelected(true);	
		rbPending.setActionCommand("PENDING");
		rbFulfilled.setActionCommand("FULFILLED");
		rbPending.setBounds(100,85,100,30);
		rbFulfilled.setBounds(300,85,100,30);
		rbPending.setContentAreaFilled(false);
		rbFulfilled.setContentAreaFilled(false);
		rbPending.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFulfilled.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bgStatus = new ButtonGroup();
		bgStatus.add(rbPending);
		bgStatus.add(rbFulfilled);
		panel_1.add(rbPending);
		panel_1.add(rbFulfilled);
		
		lblOrderDetails = new JLabel("Order Details:");
		lblOrderDetails.setBounds(40,110,150,40);
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblOrderDetails);
		
		lblTotalAmountDue = new JLabel("Total Amount Due:");
		lblTotalAmountDue.setBounds(40,460,150,40);
		lblTotalAmountDue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblTotalAmountDue);
		
		lblTotalAmountDue2 = new JLabel(String.valueOf(totalAmount));
		lblTotalAmountDue2.setBounds(180,460,150,40);
		lblTotalAmountDue2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblTotalAmountDue2);
		
		lblInitialDeposit = new JLabel("Initial Deposit:");
		lblInitialDeposit.setBounds(40,483,150,40);
		lblInitialDeposit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblInitialDeposit);
		
		lblInitialDeposit2 = new JLabel(String.valueOf(balance));
		lblInitialDeposit2.setBounds(180,483,150,40);
		lblInitialDeposit2.setForeground(Color.decode("#188A0F")); //green
		lblInitialDeposit2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblInitialDeposit2);
		
		lblRemainingBalance = new JLabel("Amount Due:");
		lblRemainingBalance.setBounds(40,506,150,40);
		lblRemainingBalance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblRemainingBalance);
		
		lblRemainingBalance2 = new JLabel(String.valueOf(totalAmount-balance));
		lblRemainingBalance2.setBounds(180,506,150,40);
		lblRemainingBalance2.setForeground(Color.decode("#B90A0A")); //red
		lblRemainingBalance2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblRemainingBalance2);
		
		lblAmountDue = new JLabel("Initial Deposit:");
		lblAmountDue.setBounds(40,529,150,40);
		lblAmountDue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblAmountDue);
		txtAmountDue = new JTextField();
		txtAmountDue.setBounds(180,539,140,20);
		txtAmountDue.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(totalAmount-balance == Double.parseDouble(txtAmountDue.getText()))
					rbFulfilled.setEnabled(true);
				else rbFulfilled.setEnabled(false);
		        System.out.println("Text=" + txtAmountDue.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(balance == Double.parseDouble(txtAmountDue.getText()))
					rbFulfilled.setEnabled(true);
				else rbFulfilled.setEnabled(false);
		        System.out.println("Text=" + txtAmountDue.getText());
		        
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
				if(balance == Double.parseDouble(txtAmountDue.getText()))
					rbFulfilled.setEnabled(true);
				else rbFulfilled.setEnabled(false);
		        System.out.println("Text=" + txtAmountDue.getText());
			}
			
		});
		txtAmountDue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(txtAmountDue);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(40, 600, 150, 40);
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConfirm.setBorderPainted(false);
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBackground(Color.decode("#A8A76D"));
		btnConfirm.addActionListener(new doActionListener());
		panel_1.add(btnConfirm);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(250, 600, 150, 40);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBorderPainted(false);
		btnCancel.setFocusPainted(false);
		btnCancel.setBackground(Color.decode("#A8A76D"));
		btnCancel.addActionListener(new doActionListener());
		panel_1.add(btnCancel);
		
		orderList = new JList();
		orderList.setBounds(40, 150, 360, 300);
		orderList.setBackground(Color.WHITE);
		orderList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(orderList);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		
		this.setSize(screenWidth, screenHeight - taskBarSize);
		this.setResizable(false);
		this.setTitle("Celestra Tailoring and Embroidery");
		this.setVisible(true);
	} 
	
	public class doActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent action) {
			if(action.getSource() == btnBack) {
				dispose();
			} else if(action.getSource() == btnConfirm) {
				//checks if successfully altered
				OrderList originalOrderList = null;
				String selectedStatus;
				selectedStatus = bgStatus.getSelection().getActionCommand();
				
				try {
					originalOrderList = orderController.getSelectedOrderList(selectedRow);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					
					orderController.modifyOrder(originalOrderList, orderController.createModifiedOrderList(originalOrderList, selectedStatus, Double.parseDouble(txtAmountDue.getText())));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mainFrame.updateTable();
				dispose();
			} else if(action.getSource() == btnCancel) {
				dispose();
			} 
		}
	}
}
