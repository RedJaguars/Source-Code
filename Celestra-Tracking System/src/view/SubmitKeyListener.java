package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SubmitKeyListener implements KeyListener {

	public SubmitKeyListener() {
		// TODO Auto-generated constructor stub
	}

	public void keyReleased(KeyEvent evt) {
        //do  nothing
    }

    public void keyTyped(KeyEvent evt) {
        //do nothing
    }

    public void keyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        	
        }
        	
    }

}
