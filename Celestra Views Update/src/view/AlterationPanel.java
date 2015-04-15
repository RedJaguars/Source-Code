package view;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;

public class AlterationPanel extends JPanel{
	private JTextField textField;
	private JTextField textField_2;
	private JLabel lblSpecialInstructions;
	private JLabel lblDueDate;
	private JList list_1;
	private JList list_2;
	public AlterationPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 774, 617);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 88, 355, 366);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(407, 88, 355, 366);
		panel.add(textField_2);
		
		JLabel lblMaterials = new JLabel("Materials: ");
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaterials.setBounds(12, 50, 167, 25);
		panel.add(lblMaterials);
		
		lblSpecialInstructions = new JLabel("Special Instructions: ");
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpecialInstructions.setBounds(407, 50, 167, 25);
		panel.add(lblSpecialInstructions);
		
		lblDueDate = new JLabel("Due Date: ");
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDueDate.setBounds(12, 517, 85, 25);
		panel.add(lblDueDate);
		
		JList list = new JList();
		list.setBounds(109, 522, 244, 20);
		panel.add(list);
		
		list_1 = new JList();
		list_1.setBounds(373, 522, 62, 20);
		panel.add(list_1);
		
		list_2 = new JList();
		list_2.setBounds(454, 522, 103, 20);
		panel.add(list_2);
	}
}
