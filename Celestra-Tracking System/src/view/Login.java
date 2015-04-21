package view;

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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.AccountController;
import model.AccountModel;

public class Login extends JFrame {
	private JPasswordField textField;
	private JButton btnCancel;
	private JButton btnSubmit;
	private AccountController accountController;
	public Login() {
		accountController = new AccountController();
		getContentPane().setBackground(Color.decode("#E5EDB8"));
		getContentPane().setLayout(null);
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		
		JLabel lblAddNewItem = new JLabel("Login");
		lblAddNewItem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddNewItem.setBounds(25, 54, 66, 36);
		getContentPane().add(lblAddNewItem);
		
		textField = new JPasswordField();
		textField.setBounds(170, 130, 218, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 130, 137, 16);
		getContentPane().add(lblNewLabel);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new doActionListener());
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBackground(Color.decode("#A8A76D"));
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBorderPainted(false);
		btnSubmit.setBounds(100, 180, 130, 36);
		getContentPane().add(btnSubmit);
		textField.addKeyListener(new SubmitKeyListener(btnSubmit));

		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new doActionListener());
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(Color.decode("#A8A76D"));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBounds(255, 180, 130, 36);
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
					//while()
					int userCount = accountController.getUserCount();
					
					for(int i=userCount;i>0;i--){
						System.out.println(i);
						if(accountController.login(i, password)){
							new OrderFrame();
							dispose();
							break;
						}
						
					}
						
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		}
	}
}
