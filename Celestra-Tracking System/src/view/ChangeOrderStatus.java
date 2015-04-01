package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.OrderController;

public class ChangeOrderStatus extends JFrame{
	private JTextField textField_2;
	private JTextArea txtAreaOrderStatus;
	private JTextField textField;
	
	private JButton btnSubmit;
	private JButton btnCancel;
	
	private int selectedRow;
	
	private OrderController orderController;
	
	public ChangeOrderStatus(int row) {
		selectedRow = row;
		
		orderController = new OrderController();
		
		getContentPane().setLayout(null);
		
		JLabel lblAddNewItem = new JLabel("Change Order Status");
		lblAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddNewItem.setBounds(25, 53, 209, 30);
		getContentPane().add(lblAddNewItem);
		
		txtAreaOrderStatus = new JTextArea();
		txtAreaOrderStatus.setColumns(10);
		txtAreaOrderStatus.setBounds(29, 165, 367, 212);
		getContentPane().add(txtAreaOrderStatus);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 417, 241, 22);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Order Details:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 115, 103, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Current balance:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(25, 420, 118, 16);
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
		
		textField = new JTextField();
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
				//orderController.modifyOrder(orderController.getSelectedOrderList(selectedRow), modified);
				dispose();
			} else if(e.getSource() == btnCancel) {
				dispose();
			} 
			
		}
	}
}
