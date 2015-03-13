import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class OrdersView extends JFrame implements ActionListener {
	private JTable tableOrders;
	private JTextArea orderDetails;
	private JPanel panel;
	
	private JButton btnAddNewOrder;
	private JButton btnModifyOrder;
	private JButton btnChangeStatus;
	private JButton btnCancelOrder;
	
	private JButton btnManageOrder;
	private JButton btnManageInventory;
	private JButton btnManageSales;
	private JButton btnExit;
	private JButton btnChangePassword;

	/**
	 * Create the panel.
	 */
	public OrdersView() {
		panel = new JPanel();
		
		this.setSize(new Dimension(800, 600));
		panel.setLayout(null);
		
		
		JLabel lblListOfOrders = new JLabel("List of Orders");
		lblListOfOrders.setBounds(225, 28, 119, 25);
		lblListOfOrders.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblListOfOrders);
		
		tableOrders = new JTable();
		tableOrders.setBounds(229, 64, 590, 311);
		panel.add(tableOrders);
		
		btnAddNewOrder = new JButton("Add new order");
		btnAddNewOrder.setName("newOrderButton\r\n");
		btnAddNewOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddNewOrder.setBounds(598, 31, 163, 23);
		panel.add(btnAddNewOrder);
		
		JLabel lblOrderDetails = new JLabel("Order Details");
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrderDetails.setBounds(225, 408, 119, 14);
		panel.add(lblOrderDetails);
		
		orderDetails = new JTextArea();
		orderDetails.setBounds(235, 433, 335, 115);
		panel.add(orderDetails);
		
		btnChangeStatus = new JButton("Change status");
		btnChangeStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChangeStatus.setBounds(580, 467, 181, 23);
		panel.add(btnChangeStatus);
		
		btnCancelOrder = new JButton("Cancel order");
		btnCancelOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelOrder.setBounds(580, 501, 181, 23);
		panel.add(btnCancelOrder);
		
		btnModifyOrder = new JButton("Modify order");
		btnModifyOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModifyOrder.setBounds(580, 432, 181, 23);
		panel.add(btnModifyOrder);
		
		btnManageOrder = new JButton("Manage Order");
		btnManageOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManageOrder.setBounds(29, 58, 168, 23);
		panel.add(btnManageOrder);
		
		btnManageInventory = new JButton("Manage Inventory");
		btnManageInventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManageInventory.setBounds(29, 111, 168, 23);
		panel.add(btnManageInventory);
		
		btnManageSales = new JButton("Manage Sales");
		btnManageSales.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManageSales.setBounds(29, 169, 168, 23);
		panel.add(btnManageSales);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChangePassword.setBounds(29, 231, 168, 23);
		panel.add(btnChangePassword);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(29, 469, 168, 23);
		panel.add(btnExit);
		
		btnAddNewOrder.addActionListener(this);
		btnModifyOrder.addActionListener(this);
		btnChangeStatus.addActionListener(this);
		btnCancelOrder.addActionListener(this);
		
		btnManageOrder.addActionListener(this);
		btnManageInventory.addActionListener(this);
		btnManageSales.addActionListener(this);
		btnExit.addActionListener(this);
		btnChangePassword.addActionListener(this);

	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.btnAddNewOrder){
			
		}
		else if(arg0.getSource() == this.btnCancelOrder){
			
		}
		else if(arg0.getSource() == this.btnChangePassword){
			
		}
		else if(arg0.getSource() == this.btnChangeStatus){
	
		}
		else if(arg0.getSource() == this.btnExit){
	
		}
		else if(arg0.getSource() == this.btnManageInventory){
	
		}
		else if(arg0.getSource() == this.btnManageOrder){
	
		}
		else if(arg0.getSource() == this.btnManageSales){
			
		}
		else if(arg0.getSource() == this.btnModifyOrder){
	
		}
		
	}
	
	
}
