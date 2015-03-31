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

import view.ItemFrame.doActionListener;

public class SalesFrame extends JFrame{
	private JTextField textField;
	
	private JButton btnManageOrder;
	private JButton btnManageItems;
	private JButton btnManageSales;
	private JButton btnChangePassword;
	private JButton btnExit;
	
	public SalesFrame() {
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
		
		JButton btnViewDailyReport = new JButton("View Daily Report");
		btnViewDailyReport.setBounds(297, 42, 200, 50);
		btnViewDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		lblOrderDetails.setBounds(53, 458, 165, 16);
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblOrderDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(53, 114, 886, 314);
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnViewMonthlyReport = new JButton("View Monthly Report");
		btnViewMonthlyReport.setBounds(733, 42, 200, 50);
		panel_1.add(btnViewMonthlyReport);
		
		JButton btnViewWeeklyReport = new JButton("View Weekly Report");
		btnViewWeeklyReport.setBounds(521, 42, 200, 50);
		panel_1.add(btnViewWeeklyReport);
		
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
				new ItemFrame();
				dispose();
			} else if(e.getSource() == btnManageSales) {
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
