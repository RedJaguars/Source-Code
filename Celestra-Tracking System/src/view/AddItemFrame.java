package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddItemFrame extends JFrame{
	private JTextField textField;
	private JTextArea txtAreaDescription;
	private JTextField textField_2;
	
	private JButton btnSubmit;
	private JButton btnCancel;
	
	public AddItemFrame() {
		getContentPane().setLayout(null);
		
		JLabel lblAddNewItem = new JLabel("Add New Item");
		lblAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddNewItem.setBounds(25, 53, 142, 16);
		getContentPane().add(lblAddNewItem);
		
		textField = new JTextField();
		textField.setBounds(155, 112, 241, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		txtAreaDescription = new JTextArea();
		txtAreaDescription.setColumns(10);
		txtAreaDescription.setBounds(155, 174, 241, 203);
		getContentPane().add(txtAreaDescription);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 417, 241, 22);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Item Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 115, 103, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setBounds(25, 174, 103, 16);
		getContentPane().add(lblDescription);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(25, 420, 103, 16);
		getContentPane().add(lblQuantity);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new doActionListener());
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(51, 535, 149, 36);
		btnSubmit.addActionListener(new doActionListener());
		getContentPane().add(btnSubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new doActionListener());
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(231, 535, 149, 36);
		getContentPane().add(btnCancel);
		
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
				//also checks if inventory was successfully added into the database
				dispose();
			} else if(e.getSource() == btnCancel) {
				dispose();
			} 
			
		}
	}
}
