package sweng;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class BottomPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_13;
	private JTextField textField_14;
	public BottomPanel() {
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
		
		JLabel lblWaist = new JLabel("Waist:");
		lblWaist.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWaist.setBounds(52, 86, 66, 19);
		panel.add(lblWaist);
		
		JLabel lblHips = new JLabel("Hips:");
		lblHips.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHips.setBounds(52, 115, 91, 19);
		panel.add(lblHips);
		
		JLabel lblThigh = new JLabel("Thigh:");
		lblThigh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThigh.setBounds(52, 145, 91, 19);
		panel.add(lblThigh);
		
		JLabel lblBottom = new JLabel("Bottom:");
		lblBottom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBottom.setBounds(52, 175, 66, 19);
		panel.add(lblBottom);
		
		JLabel lblCrotch = new JLabel("Crotch:");
		lblCrotch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCrotch.setBounds(52, 207, 91, 19);
		panel.add(lblCrotch);
		
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
