package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class FullBodyPanel extends JPanel{
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
	public FullBodyPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 736, 484);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Measurements (In Inches):");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 13, 191, 16);
		panel.add(lblNewLabel);
		
		JLabel lblLength = new JLabel("Length:");
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLength.setBounds(52, 54, 66, 19);
		panel.add(lblLength);
		
		JLabel lblShoulder = new JLabel("Shoulder:");
		lblShoulder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShoulder.setBounds(52, 86, 66, 19);
		panel.add(lblShoulder);
		
		JLabel lblChestbust = new JLabel("Chest/Bust:");
		lblChestbust.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChestbust.setBounds(52, 115, 91, 19);
		panel.add(lblChestbust);
		
		JLabel lblArmLength = new JLabel("Arm Length:");
		lblArmLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblArmLength.setBounds(52, 145, 91, 19);
		panel.add(lblArmLength);
		
		JLabel lblArmhole = new JLabel("Armhole:");
		lblArmhole.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblArmhole.setBounds(52, 175, 66, 19);
		panel.add(lblArmhole);
		
		JLabel lblBackFigure = new JLabel("Back Figure:");
		lblBackFigure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBackFigure.setBounds(52, 207, 91, 19);
		panel.add(lblBackFigure);
		
		JLabel lblNeckDeep = new JLabel("Neck Deep:");
		lblNeckDeep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNeckDeep.setBounds(301, 56, 83, 19);
		panel.add(lblNeckDeep);
		
		JLabel lblWrist = new JLabel("Wrist:");
		lblWrist.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWrist.setBounds(301, 88, 66, 19);
		panel.add(lblWrist);
		
		JLabel lblWaist = new JLabel("Waist:");
		lblWaist.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWaist.setBounds(301, 117, 66, 19);
		panel.add(lblWaist);
		
		JLabel lblHips = new JLabel("Hips:");
		lblHips.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHips.setBounds(301, 147, 66, 19);
		panel.add(lblHips);
		
		JLabel lblFrontFigure = new JLabel("Front Figure:");
		lblFrontFigure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrontFigure.setBounds(301, 177, 83, 19);
		panel.add(lblFrontFigure);
		
		JLabel lblBustPoint = new JLabel("Bust Point:");
		lblBustPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBustPoint.setBounds(301, 209, 83, 19);
		panel.add(lblBustPoint);
		
		JLabel lblBustDistance = new JLabel("Bust Distance: ");
		lblBustDistance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBustDistance.setBounds(521, 54, 99, 19);
		panel.add(lblBustDistance);
		
		textField = new JTextField();
		textField.setBounds(189, 53, 66, 22);
		panel.add(textField);
		textField.setColumns(10);
		
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
		
		JLabel lblMaterials = new JLabel("Materials:");
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaterials.setBounds(12, 267, 191, 16);
		panel.add(lblMaterials);
		
		JLabel lblSpecialInstructions = new JLabel("Special Instructions:");
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecialInstructions.setBounds(429, 277, 191, 16);
		panel.add(lblSpecialInstructions);
		
		textField_13 = new JTextField();
		textField_13.setBounds(12, 306, 329, 165);
		panel.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(397, 306, 329, 165);
		panel.add(textField_14);
	}
	
}
