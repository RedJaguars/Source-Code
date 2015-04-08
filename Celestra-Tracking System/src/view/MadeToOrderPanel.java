package sweng;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JRadioButton;

public class MadeToOrderPanel extends JPanel{
	private JPanel panel_1;
	private JLabel label;
	private JList list;
	private JList list_1;
	private JList list_2;
	private JRadioButton rdbtnFullBody;
	private JRadioButton rdbtnTop;
	private JRadioButton rdbtnBottom;
	public MadeToOrderPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 774, 617);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(12, 54, 736, 484);
		panel.add(panel_1);
		
		label = new JLabel("Due Date: ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(12, 563, 85, 25);
		panel.add(label);
		
		list = new JList();
		list.setBounds(101, 568, 244, 20);
		panel.add(list);
		
		list_1 = new JList();
		list_1.setBounds(360, 568, 62, 20);
		panel.add(list_1);
		
		list_2 = new JList();
		list_2.setBounds(439, 568, 103, 20);
		panel.add(list_2);
		
		rdbtnFullBody = new JRadioButton("Full Body");
		rdbtnFullBody.setBounds(101, 20, 127, 25);
		panel.add(rdbtnFullBody);
		
		rdbtnTop = new JRadioButton("Top");
		rdbtnTop.setBounds(337, 20, 127, 25);
		panel.add(rdbtnTop);
		
		rdbtnBottom = new JRadioButton("Bottom");
		rdbtnBottom.setBounds(574, 20, 127, 25);
		panel.add(rdbtnBottom);
	}
}

