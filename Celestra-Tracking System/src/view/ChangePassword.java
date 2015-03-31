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
import javax.swing.JTextField;

public class ChangePassword extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JButton btnSubmit;
	private JButton btnCancel;
	
	public ChangePassword() {
		getContentPane().setLayout(null);
		
		JLabel lblAddNewItem = new JLabel("Change Password");
		lblAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddNewItem.setBounds(25, 53, 189, 36);
		getContentPane().add(lblAddNewItem);
		
		textField = new JTextField();
		textField.setBounds(189, 113, 218, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 172, 218, 22);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(189, 245, 218, 22);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Current Password: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 115, 137, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("New Password:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setBounds(25, 174, 103, 16);
		getContentPane().add(lblDescription);
		
		JLabel lblQuantity = new JLabel("Re-type New Password:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(12, 247, 165, 16);
		getContentPane().add(lblQuantity);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new doActionListener());
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmit.setBounds(53, 334, 149, 36);
		getContentPane().add(btnSubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new doActionListener());
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(236, 334, 149, 36);
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
				//checks if successfully altered
				dispose();
			} else if(e.getSource() == btnCancel) {
				dispose();
			} 
		}
	}
}
