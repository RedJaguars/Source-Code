package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import view.AddOrderFrame.doActionListener;
import controller.InventoryController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyItemFrame extends JFrame{
	private JTextArea txtAreaItemName;
	private JTextArea txtAreaDescription;
	private JTextArea txtAreaQuantity;
	
	private JButton btnSubmit, btnBack;
	private JButton btnCancel;
	
	private JPanel panel_1;
	private JLabel lblHeader, lblItemName, lblQuantity, lblDescription, lblMeasurement;
	private JTextField txtItemName;
	private JTextArea tarDescription;
	private JSpinner spnQuantity;
	private JComboBox cbMeasurement;
	
	private InventoryController inventoryController;

	private SpinnerNumberModel snmQuantity;
	
	public ModifyItemFrame() {
		inventoryController = new InventoryController();
		snmQuantity = new SpinnerNumberModel(1, 1, Double.MAX_VALUE, 1 );
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#D3D27C"));
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		
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
		
		lblHeader = new JLabel("Modify Item");
		lblHeader.setBounds(40,10,250,40);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblHeader);
		
		lblItemName = new JLabel("Item Name:");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItemName.setBounds(40, 70, 103, 20);
		panel_1.add(lblItemName);
		
		txtItemName = new JTextField();
		txtItemName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtItemName.setBounds(180, 72, 230, 20);
		panel_1.add(txtItemName);
		
		lblMeasurement = new JLabel("Unit Of Measurement:");
		lblMeasurement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMeasurement.setBounds(40, 110, 150, 20);
		panel_1.add(lblMeasurement);
		
		String[] measurements = {"----------","inch", "centimeters", "meters","none"};
		cbMeasurement = new JComboBox(measurements);
		cbMeasurement.setFont(new Font("Tahoma,", Font.PLAIN, 13));
		cbMeasurement.setBackground(Color.decode("#E5EDB8"));
		cbMeasurement.setBounds(180, 112, 120, 20);
		cbMeasurement.setSelectedIndex(0);
		panel_1.add(cbMeasurement);
		
		lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescription.setBounds(40, 150, 103, 20);
		panel_1.add(lblDescription);
		
		tarDescription = new JTextArea();
		tarDescription.setFont(new Font("Tahoma", Font.PLAIN,13));
		tarDescription.setBounds(40, 180, 400, 250);
		panel_1.add(tarDescription);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new doActionListener());
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBackground(Color.decode("#A8A76D"));
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBorderPainted(false);
		btnSubmit.setBounds(40, 510, 150, 40);
		panel_1.add(btnSubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new doActionListener());
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(Color.decode("#A8A76D"));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBounds(250, 510, 150, 40);
		panel_1.add(btnCancel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		
		this.setSize(screenWidth, screenHeight - taskBarSize);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public class doActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent action) {
			if(action.getSource() == btnSubmit) {
				dispose();
			} else if(action.getSource() == btnCancel) {
				new ItemFrame();
				dispose();
			} else if(action.getSource() == btnBack) {
				dispose();
			}
			
		}
	}
}
