package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.OrderFrame.doActionListener;

public class ItemFrame extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	
	private JButton btnManageOrder;
	private JButton btnManageItems;
	private JButton btnManageSales;
	private JButton btnChangePassword;
	private JButton btnAddNewItem;
	private JButton btnExit;
	
	public ItemFrame() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 292, 721);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnManageOrder = new JButton("Manage Order");
		btnManageOrder.setBounds(28, 209, 200, 50);
		btnManageOrder.addActionListener(new doActionListener());
		panel.add(btnManageOrder);
		
		btnManageItems = new JButton("Manage Items");
		btnManageItems.setBounds(28, 280, 200, 50);
		btnManageItems.addActionListener(new doActionListener());
		panel.add(btnManageItems);
		
		btnManageSales = new JButton("Manage Sales");
		btnManageSales.setBounds(28, 352, 200, 50);
		btnManageSales.addActionListener(new doActionListener());
		panel.add(btnManageSales);
		
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
		
		btnAddNewItem = new JButton("Add New Item");
		btnAddNewItem.addActionListener(new doActionListener());
		btnAddNewItem.setBounds(739, 40, 200, 50);
		panel_1.add(btnAddNewItem);
		
		JLabel lblNewLabel = new JLabel("List of Items");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 57, 115, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(53, 500, 460, 183);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblOrderDetails = new JLabel("Item Details");
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrderDetails.setBounds(53, 458, 115, 16);
		panel_1.add(lblOrderDetails);
		
		JButton btnReduceQuantity = new JButton("Submit");
		btnReduceQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReduceQuantity.setBounds(851, 546, 88, 34);
		panel_1.add(btnReduceQuantity);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(57, 126, 847, 302);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton button_4 = new JButton("Submit");
		button_4.setBounds(851, 619, 88, 34);
		panel_1.add(button_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(721, 552, 106, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(721, 625, 106, 22);
		panel_1.add(textField_3);
		
		JLabel lblAddQuantity = new JLabel("Add Quantity");
		lblAddQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddQuantity.setBounds(566, 555, 115, 16);
		panel_1.add(lblAddQuantity);
		
		JLabel lblReduceQuantity = new JLabel("Reduce Quantity");
		lblReduceQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReduceQuantity.setBounds(566, 628, 115, 16);
		panel_1.add(lblReduceQuantity);
		
		JButton btnModifyItem = new JButton("Modify Item");
		btnModifyItem.setBounds(284, 457, 200, 34);
		panel_1.add(btnModifyItem);
		
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
			if(e.getSource() == btnManageOrder) {
				new OrderFrame();
				dispose();
			} else if(e.getSource() == btnManageItems) {
				//nothing happens. stays on this frame.
			} else if(e.getSource() == btnManageSales) {
				new SalesFrame();
				dispose();
			} else if(e.getSource() == btnChangePassword) {
				new ChangePassword();
			} else if(e.getSource() == btnAddNewItem) {
				new AddItemFrame();
			} else if(e.getSource() == btnExit) {
				new Login();
				dispose();
			}
			
		}
	}
}
