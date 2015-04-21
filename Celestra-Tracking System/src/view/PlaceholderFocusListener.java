package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class PlaceholderFocusListener implements FocusListener {
	private JTextField txtField;
	private String placeholder;
	
	public PlaceholderFocusListener(JTextField field, String placeholder) {
		txtField = field;
		this.placeholder = placeholder;
		txtField.setText(placeholder);
		txtField.setForeground(new Color(153, 153, 153));
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		 txtField.setText("");
		 txtField.setForeground(Color.black);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		txtField.setText(placeholder);
		txtField.setForeground(new Color(153, 153, 153));
	}

}
