
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * @author JJMP
 *
 */

	//game over class

public class GameOverPopUp {
	
	//creates the font that will be used for the game over message
	
	Font font = new Font("IMPACT",Font.BOLD, 40);
	
	Font font2 = new Font("IMPACT", Font.PLAIN, 20);
	
	Font font3 = new Font("IMPACT", Font.PLAIN, 30);
	
	Font font4 = new Font("Impact", Font.PLAIN, 20);
	
	//draws the game over box and message
	
	public void draw(Graphics g) {
		
		g.setColor(Color.WHITE);
		
		g.fillRect(200, 300, 200, 300);
		
		g.setColor(Color.BLACK);
		
		g.drawRect(200, 300, 200, 300);			
		
		g.setFont(font);
		
		g.setColor(Color.RED);
		
		g.drawString("GAME", 250, 370);
		
		g.drawString("OVER", 253, 410);
		
		g.setFont(font2);
		
		g.setColor(Color.BLUE);
		
		g.drawString("OOPS!", 274, 450);
		
		g.setColor(Color.ORANGE);
		
		g.drawString("You have crashed!", 225, 480);
		
		g.setFont(font);
		
		g.setColor(Color.BLUE);
		
		g.drawString("Score: " + Integer.toString(DisplayScreen.getPipes().getScore()), 228, 540);
		
		g.setColor(Color.MAGENTA);
		
		g.setFont(font4);
		
		g.drawString("Enjoy the music!", 235, 575);
		
	}
	
}
