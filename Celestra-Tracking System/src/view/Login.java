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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.AccountController;
import model.AccountModel;

public class Login extends JFrame {
	private JPasswordField textField;
	private JButton btnCancel;
	private JButton btnSubmit;
	private AccountController accountController;
	public Login() {
		accountController = new AccountController();
		getContentPane().setLayout(null);
		
		JLabel lblAddNewItem = new JLabel("Login");
		lblAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddNewItem.setBounds(25, 54, 66, 36);
		getContentPane().add(lblAddNewItem);
		
		textField = new JPasswordField();
		textField.setBounds(189, 197, 218, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 199, 137, 16);
		getContentPane().add(lblNewLabel);
		
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
			if(e.getSource() == btnCancel) {
				//closes frame
				dispose();
			} else if(e.getSource() == btnSubmit) {
				//database checking
				String password = textField.getText();
				try {
					if(accountController.login(1, password)){
						new OrderFrame();
						dispose();
					}
						
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		}
	}
}
