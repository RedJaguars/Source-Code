package sweng;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TopPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	public TopPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 736, 484);
		add(panel);
		
		JLabel label = new JLabel("Measurements (In Inches):");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(12, 13, 191, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Length:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(52, 54, 66, 19);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Shoulder:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(52, 86, 66, 19);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Chest/Bust:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(52, 115, 91, 19);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Arm Length:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(52, 145, 91, 19);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Armhole:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(52, 175, 66, 19);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Back Figure:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(52, 207, 91, 19);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Neck Deep:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(301, 56, 83, 19);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Wrist:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(301, 88, 66, 19);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Waist:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(301, 117, 66, 19);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Hips:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(301, 147, 66, 19);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Front Figure:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_11.setBounds(301, 177, 83, 19);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Bust Point:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_12.setBounds(301, 209, 83, 19);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("Bust Distance: ");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_13.setBounds(521, 54, 99, 19);
		panel.add(label_13);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(189, 53, 66, 22);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 85, 66, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(189, 114, 66, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(189, 144, 66, 22);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(189, 174, 66, 22);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(189, 206, 66, 22);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(432, 53, 66, 22);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(432, 85, 66, 22);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(432, 114, 66, 22);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(432, 144, 66, 22);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(432, 174, 66, 22);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(432, 206, 66, 22);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(644, 53, 66, 22);
		panel.add(textField_12);
		
		JLabel label_14 = new JLabel("Materials:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_14.setBounds(12, 267, 191, 16);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("Special Instructions:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_15.setBounds(429, 277, 191, 16);
		panel.add(label_15);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(12, 306, 329, 165);
		panel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(432, 306, 294, 165);
		panel.add(textField_14);
	}

}
