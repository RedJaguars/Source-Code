package spsweng;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.TextArea;

public class InventoryView extends JFrame{
	private JTable table;
	public InventoryView() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 189, 553);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		Button button = new Button("Manage Inventory");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(25, 165, 126, 24);
		panel.add(button);
		
		Button button_1 = new Button("Manage Sales");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(25, 207, 126, 24);
		panel.add(button_1);
		
		Button button_2 = new Button("Change Password");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setBounds(25, 250, 126, 24);
		panel.add(button_2);
		
		Button button_3 = new Button("Manage Orders");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setBounds(25, 124, 126, 24);
		panel.add(button_3);
		
		Button button_4 = new Button("Exit");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_4.setBounds(46, 425, 79, 24);
		panel.add(button_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(188, 0, 594, 553);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Label label = new Label("List of Items");
		label.setBounds(37, 27, 85, 24);
		panel_1.add(label);
		
		Button button_5 = new Button("Add Item");
		button_5.setBounds(427, 27, 79, 24);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(button_5);
		
		JLabel lblItemDetails = new JLabel("Item Details");
		lblItemDetails.setBounds(37, 370, 85, 16);
		panel_1.add(lblItemDetails);
		
		Button button_6 = new Button("Modify");
		button_6.setBounds(150, 370, 79, 24);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(button_6);
		
		TextField textField = new TextField();
		textField.setBounds(408, 370, 79, 24);
		panel_1.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(408, 400, 79, 24);
		panel_1.add(textField_1);
		
		Button button_7 = new Button("Submit");
		button_7.setBounds(505, 370, 79, 24);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(button_7);
		
		Button button_8 = new Button("Submit");
		button_8.setBounds(505, 400, 79, 24);
		panel_1.add(button_8);
		
		JLabel lblNewLabel = new JLabel("Reduce Qty");
		lblNewLabel.setBounds(305, 370, 70, 16);
		panel_1.add(lblNewLabel);
		
		Label label_1 = new Label("Add Qty");
		label_1.setBounds(305, 400, 70, 24);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 64, 556, 281);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 556, 281);
		panel_2.add(table);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(12, 400, 273, 131);
		panel_1.add(textArea);
	
	}
}
