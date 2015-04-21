package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class SubmitKeyListener implements KeyListener {
	private JButton buttonToDo;
	
	public SubmitKeyListener(JButton button) {
		this.buttonToDo = button;
	}

	public void keyReleased(KeyEvent evt) {
        //do  nothing
    }

    public void keyTyped(KeyEvent evt) {
        //do nothing
    }

    public void keyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        	buttonToDo.doClick();
        }
        	
    }

}
