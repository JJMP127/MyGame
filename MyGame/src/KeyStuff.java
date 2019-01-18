
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author JJMP
 *
 */

	//class to manage the keys

public class KeyStuff implements KeyListener{

	private boolean spaceIsPressed = false;
	private boolean enterIsPressed = false;
	private boolean shiftIsPressed = false;

	public KeyStuff(){
		
		reset();
	
	}

	public void reset() {

		spaceIsPressed = false;
		enterIsPressed = false;
		shiftIsPressed = false;

	}


	public boolean isSpacePressed() {
		
		return spaceIsPressed;
	
	}
	
	public boolean isEnterPressed() {
		
		return enterIsPressed;
		
	}
	
	public boolean isShiftPressed() {
		
		return shiftIsPressed;
		
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
	
		case KeyEvent.VK_SPACE:
			this.spaceIsPressed = true;
			break;
			
		case KeyEvent.VK_ENTER:
			this.enterIsPressed = true;
			break;
			
		case KeyEvent.VK_SHIFT:
			this.shiftIsPressed = true;
			break;
		
		}
		
		e.consume();
		
	}

	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()){
		
		case KeyEvent.VK_SPACE:
			this.spaceIsPressed = false;
			break;
			
		case KeyEvent.VK_ENTER:
			this.enterIsPressed = false;
			break;
			
		case KeyEvent.VK_SHIFT:
			this.shiftIsPressed = false;
			break;
		
		}
		
		e.consume();
		
	}

	public void keyTyped(KeyEvent e) {

	}

	public boolean getSpace(){
		
		return spaceIsPressed;
		
	}
	
	public boolean getEnter(){
		
		return enterIsPressed;
		
	}
	
	public boolean getShift(){
		
		return shiftIsPressed;
		
	}

}
