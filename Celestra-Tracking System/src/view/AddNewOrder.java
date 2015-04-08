package sweng;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import java.awt.Choice;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class AddNewOrder extends JFrame {
	private static final boolean TRUE = false;

	public AddNewOrder() {
		getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(291, 0, 837, 980);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(36, 897, 200, 50);
		panel_2.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(248, 897, 200, 50);
		panel_2.add(btnRemove);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(585, 897, 200, 50);
		panel_2.add(btnCancel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.setBounds(12, 57, 798, 82);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JButton button_8 = new JButton("Add");
		button_8.setBounds(637, 13, 141, 50);
		panel_3.add(button_8);
		
		JButton button_7 = new JButton("Select");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_7.setBounds(484, 13, 141, 50);
		panel_3.add(button_7);
		
		Choice choice = new Choice();
		choice.setBounds(25, 29, 428, 22);
		panel_3.add(choice);
		
		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(52, 24, 61, 20);
		panel_2.add(lblNewLabel);
		
		JLabel lblAddToOrder = new JLabel("Add to Order");
		lblAddToOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddToOrder.setBounds(52, 170, 116, 20);
		panel_2.add(lblAddToOrder);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(12, 211, 798, 673);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Alteration");
		if(rdbtnNewRadioButton.isSelected() == TRUE){
			//AlterationPanel set to TRUE
		};
		rdbtnNewRadioButton.setBounds(118, 9, 127, 25);
		panel_4.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMadetoorder = new JRadioButton("Made-to-Order");
		rdbtnMadetoorder.setBounds(319, 9, 127, 25);
		panel_4.add(rdbtnMadetoorder);
		
		JRadioButton rdbtnEmbroidery = new JRadioButton("Embroidery");
		rdbtnEmbroidery.setBounds(545, 9, 127, 25);
		panel_4.add(rdbtnEmbroidery);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 292, 980);
		getContentPane().add(panel);
		
		JButton button = new JButton("Manage Order");
		button.setBounds(28, 209, 200, 50);
		panel.add(button);
		
		JButton button_1 = new JButton("Manage Items");
		button_1.setBounds(28, 280, 200, 50);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Manage Sales");
		button_2.setBounds(28, 352, 200, 50);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Change Password");
		button_3.setBounds(28, 478, 200, 50);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Exit");
		button_4.setBounds(28, 612, 200, 50);
		panel.add(button_4);
		
		JButton button_5 = new JButton("Login");
		button_5.setBounds(28, 415, 200, 50);
		panel.add(button_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(1128, 0, 377, 872);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(188, 5, 0, 0);
		panel_1.add(list);
		
		JButton button_6 = new JButton("Checkout");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_6.setBounds(1219, 901, 200, 50);
		getContentPane().add(button_6);
	}
}
