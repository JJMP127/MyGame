
import java.awt.*;
import java.util.Random;

import javax.swing.JComponent;

/**
 * 
 * @author JJMP
 *
 */

	//the diplay screen 

public class DisplayScreen extends JComponent{
	
//creates the things to be used on this class from other classes	
	
	public boolean downItGoes = false;
	
	public boolean playerCrashed = false;
	
	Background background = new Background();
	
	GameOverPopUp gameOver = new GameOverPopUp();
	
	static KeyStuff keys = new KeyStuff();
	
	static Player player = new Player(100,  400);
	
	static Pipes pipes = new Pipes();

	public void paintComponent(Graphics g) {
		
		Font font = new Font("IMPACT",Font.BOLD, 40);
			
		Font font2 = new Font("IMPACT", Font.PLAIN, 20);
		
	//draws the background, the pipes and the player on the screen	
		
		background.draw(g);
		
		pipes.draw(g);
		
		player.draw(g);
		
		g.setColor(Color.BLUE);
		
		g.setFont(font);
		
	//draws the score on the top right side of the screen 	
		
		g.drawString(Integer.toString(pipes.getScore()), this.getWidth() - 50, 50);
		
		g.setFont(font2);
		
		g.setColor(Color.WHITE);
		
	//draws instructions on the bottom of the screen 	
		
		g.drawString("Music by Tobu", 10, this.getHeight() - 10);
		
		g.drawString("Enter = Up", this.getWidth() - 230, this.getHeight() - 10);
		
		g.drawString("Shift = Down", this.getWidth() - 120, this.getHeight() - 10);
		
		if(keys.isShiftPressed()) player.moveDown();
		
		if(keys.isEnterPressed()) player.moveUp();
		
	//activates little jump before the game over	
		
		if(pipes.playerCrashed(player)) {
			
			this.downItGoes = true;			
			
		}
		
	//make the little jump if player crashes	
		
		if(this.downItGoes) {
	
			player.setY(player.getY() - 30);
			
			player.setVelocityY(player.getVelocityY() + player.getGravity());
			
			player.setY(player.getY() + player.getVelocityY());			
			
		}
		
	//activates game over message	
		
		if(player.getY() + player.getSize() > this.getHeight() + 100) {
			
			this.playerCrashed = true;
			
			gameOver.draw(g);
			
		}
		
	}
	
	//a couple GETTERS
	
	public KeyStuff getKeys() {
		
		return keys;
		
	}
	
	public static Player getPlayer() {
		
		return player;
		
	}
	
	public static Pipes getPipes() {
		
		return pipes;
		
	}

}
