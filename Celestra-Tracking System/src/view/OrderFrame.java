package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JDesktopPane;

public class OrderFrame extends JFrame{
	private JTextField textField;
	
	private JButton btnManageOrder;
	private JButton btnManageItems;
	private JButton btnManageSales;
	private JButton btnChangePassword;
	private JButton btnChangeStatus;
	private JButton btnExit;
	
	public OrderFrame() {
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
		
		JButton button_4 = new JButton("Add New Order");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_4.setBounds(739, 40, 200, 50);
		panel_1.add(button_4);
		
		JLabel lblNewLabel = new JLabel("List of Orders");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 57, 115, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(53, 500, 557, 183);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblOrderDetails = new JLabel("Order Details");
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrderDetails.setBounds(53, 458, 115, 16);
		panel_1.add(lblOrderDetails);
		
		btnChangeStatus = new JButton("Change Status");
		btnChangeStatus.addActionListener(new doActionListener());
		btnChangeStatus.setBounds(704, 500, 200, 50);
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
				//nothing happens. stays on this frame.
			} else if(e.getSource() == btnManageItems) {
				new ItemFrame();
				dispose();
			} else if(e.getSource() == btnManageSales) {
				new SalesFrame();
				dispose();
			} else if(e.getSource() == btnChangePassword) {
				new ChangePassword();
			} else if(e.getSource() == btnChangeStatus) {
				new ChangeOrderStatus();
			} else if(e.getSource() == btnExit) {
				new Login();
				dispose();
			}
			
		}
	}

}
