package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewClient extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public AddNewClient() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New Client:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 31, 151, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 101, 51, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGender.setBounds(30, 134, 62, 22);
		getContentPane().add(lblGender);
		
		JLabel lblContact = new JLabel("Contact #:");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContact.setBounds(30, 165, 79, 22);
		getContentPane().add(lblContact);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(30, 200, 62, 22);
		getContentPane().add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(139, 102, 296, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 135, 296, 22);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 166, 296, 22);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(139, 201, 296, 67);
		getContentPane().add(textField_3);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(12, 315, 200, 50);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(247, 315, 200, 50);
		getContentPane().add(button_1);
	}

}
