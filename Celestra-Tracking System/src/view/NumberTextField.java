package view;

import javax.swing.JTextField;
import javax.swing.text.Document;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NumberTextField extends JTextField {

	public NumberTextField() {
		this.addKeyListener(new TxtFieldKeyListener());
	}

	public NumberTextField(String arg0) {
		super(arg0);
		this.addKeyListener(new TxtFieldKeyListener());
	}

	public NumberTextField(int arg0) {
		super(arg0);
		this.addKeyListener(new TxtFieldKeyListener());
	}

	public NumberTextField(String arg0, int arg1) {
		super(arg0, arg1);
		this.addKeyListener(new TxtFieldKeyListener());
	}

	public NumberTextField(Document arg0, String arg1, int arg2) {
		super(arg0, arg1, arg2);
		this.addKeyListener(new TxtFieldKeyListener());
	}
	
	private class TxtFieldKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			if(!(arg0.getKeyChar() >= 48 && arg0.getKeyChar() <= 57 || arg0.getKeyChar() == '.')) {
				arg0.consume();
			}
				
		}
		
	}

}
