package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class ModifyEmbroideryOrder extends JPanel {
	public ModifyEmbroideryOrder() {
		setLayout(null);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(20, 0, 80, 20);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblType);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setBounds(20, 35, 80, 20);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblSize);
		
		JTextField txtFieldSize = new JTextField();
		txtFieldSize.setBounds(60, 35, 200, 25);
		add(txtFieldSize);
		
		setSize(1300, 400);
		setVisible(true);
	}
}
