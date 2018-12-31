
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author JJMP
 *
 */

public class Player{
	
	Image playerImage;

	private int x;
	private int y;
	private int velocityX = 5;
	private int velocityY = 0;
	private int size = 50;
	public static int gravity = 3;

	public Player(int x, int y) {

		this.x = x;
		this.y = y;
		
		try {
			playerImage = ImageIO.read(new File("res/Beedrill.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}		

	}	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public int getSize() {
		return size;
	}

	public int getGravity() {
		return gravity;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static void setGravity(int gravity) {
		Player.gravity = gravity;
	}
	
//	public static void fly() {
//		
//		y -= 70;
//		
//	}
	
	public void moveUp() {
		
		this.setY(this.getY() - 15);	
		
		if(this.getY() < 0) this.setY(5);	
		
		
		
	}
	
	public void moveDown() {
		
		this.setY(this.getY() + 15);
		
		if(this.getY() + this.getSize() >= GameMain.getDisplayScreen().getHeight() - 75) this.setY(GameMain.getDisplayScreen().getHeight() - 60 - this.getSize());	
		
	}	
	
	public void draw(Graphics g) {		

//		Graphics2D graphics = (Graphics2D) g;
//		
//		Ellipse2D.Double bird = new Ellipse2D.Double(this.x, this.y, this.size, this.size);
//		
//		graphics.setColor(Color.RED);
//		
//		graphics.fill(bird);		
//		
//		graphics.setColor(Color.BLACK);
//		
//		graphics.draw(bird);
		
		g.drawImage(playerImage, this.x, this.y, this.getSize(), this.getSize(), null);
	        

	}
	
}	


