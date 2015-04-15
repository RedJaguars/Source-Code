package view;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EmbroideryPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public EmbroideryPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 774, 617);
		add(panel);
		
		JLabel label = new JLabel("Due Date: ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(12, 563, 85, 25);
		panel.add(label);
		
		JList list = new JList();
		list.setBounds(101, 568, 244, 20);
		panel.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(360, 568, 62, 20);
		panel.add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(439, 568, 103, 20);
		panel.add(list_2);
		
		JLabel lblDesign = new JLabel("Design: ");
		lblDesign.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDesign.setBounds(12, 69, 65, 25);
		panel.add(lblDesign);
		
		textField = new JTextField();
		textField.setBounds(96, 72, 446, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Select");
		button.setBounds(584, 67, 141, 33);
		panel.add(button);
		
		JLabel lblMaterials = new JLabel("Materials:");
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaterials.setBounds(12, 128, 103, 25);
		panel.add(lblMaterials);
		
		JLabel lblSpecialInstructions = new JLabel("Special Instructions:");
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpecialInstructions.setBounds(429, 134, 168, 25);
		panel.add(lblSpecialInstructions);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 176, 333, 374);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(429, 172, 333, 374);
		panel.add(textField_2);
	}
	
}
