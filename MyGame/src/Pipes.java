
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 
 * @author JJMP
 *
 */

public class Pipes {

	Random random = new Random();

	public int score = 0; 

	private int width;
	private int height1;
	private int xPos;
	private int topOfPipe;

	private int height2;
	private int bottomOfPipe;

	private int RECT_SPEED = 7;
	
	private int GROUND_SPEED = 4;

	private int groundX = 0;
	private int groundX2 = 600;
	
	private int bGroundX = 0;
	private int bGroundX2 = 600;

	Image ground;

	Image ground2;	
	
	Color[] colors = {Color.WHITE, Color.PINK, Color.RED, Color.GREEN};

	public Pipes() {

		this.width = 100;
		this.height1 = random.nextInt(700 - 100) + 100;
		this.xPos = 600;
		this.groundX = 0;
		this.groundX2 = 600;
		this.topOfPipe = 800 - this.height1;


		this.height2 = this.topOfPipe - 150; 
		this.bottomOfPipe = this.topOfPipe - 150;
		
	}

	public boolean playerCrashed(Player player) {

		if (player.getX() + player.getSize() > this.xPos && player.getX() - player.getSize() < this.xPos + this.width) {

			if(player.getY() + player.getSize() > this.getTopOfPipe()) {

				return true;

			}

			else if(player.getY() < this.getBottomOfPipe()) {

				return true;

			}

		}

		return false;

	}

	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		try {
			ground = ImageIO.read(new File("res/ground2.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}		
		
		if(this.getScore() < 10) g2.setColor(Color.GREEN);
		
		else if(this.getScore() < 20) g2.setColor(Color.ORANGE);
		
		else if(this.getScore() < 30) g2.setColor(Color.RED);
		
		else g2.setColor(colors[random.nextInt(colors.length - 1)]);

		g2.fillRect(this.xPos, 800 - this.height1, this.width, this.getHeight1());
			
		if(this.getScore() < 10) g2.setColor(Color.GREEN);
		
		else if(this.getScore() < 20) g2.setColor(Color.ORANGE);
		
		else if(this.getScore() < 30) g2.setColor(Color.RED);
		
		else g2.setColor(colors[random.nextInt(colors.length - 1)]);
		
		g2.fillRect(this.xPos, 0, this.width, this.getHeight2());

		g2.setColor(Color.BLACK);

		g2.drawRect(this.xPos, 800 - this.height1, this.width, this.getHeight1());

		g2.setColor(Color.BLACK);

		g2.drawRect(this.xPos, -1, this.width, this.getHeight2());
		
		g2.drawImage(ground, this.bGroundX, 700, 630, 75, null);
		
		g2.drawImage(ground, this.bGroundX2, 700, 630, 75, null);
		
		g2.drawImage(ground, this.groundX, 700, 600, 75, null);

		g2.drawImage(ground, this.groundX2, 700, 600, 75, null);		

		this.xPos -= this.RECT_SPEED;

		this.groundX -= this.RECT_SPEED;

		this.groundX2 -= this.RECT_SPEED;
		
		this.bGroundX -= this.GROUND_SPEED;
		
		this.bGroundX2 -= this.GROUND_SPEED;

		if(this.getxPos() + this.width <= 0) {

			if(this.getScore() % 5 == 0) {

				this.setPipeSpeed(this.getpipeSpeed() + 1);

			}
			
//			if(this.getScore() > 9) DisplayScreen.getPlayer().setY(random.nextInt(600) + 200);

			this.setScore(this.getScore() + 1);

			this.setxPos1(600);			
			this.setHeight1(random.nextInt(700 - 100) + 100);

			this.setTopOfPipe(800 - this.getHeight1());


			this.setHeight2(this.getTopOfPipe() - 150);
			this.setBottomOfPipe(this.getHeight2());

		} 
		
		if(this.getGroundX() + 600 <= 0) this.setGroundX(600);
		
		if(this.getGroundX2() + 600 <= 0) this.setGroundX2(600);
		
		if(this.bGroundX + 600 <= 0) this.bGroundX = 600;
		
		if(this.bGroundX2 + 600 <= 0) this.bGroundX2 = 600;

		if(this.RECT_SPEED >= 14) {

			this.RECT_SPEED = 14;

		}

	}

	public int getGroundX() {
		return groundX;
	}

	public int getGroundX2() {
		return groundX2;
	}

	public void setGroundX(int groundX) {
		this.groundX = groundX;
	}

	public void setGroundX2(int groundX2) {
		this.groundX2 = groundX2;
	}

	public int getwidth() {
		return this.width;
	}

	public int getHeight1() {
		return this.height1;
	}

	public int getxPos() {
		return this.xPos;
	}

	public int getTopOfPipe() {
		return this.topOfPipe;
	}

	public void setwidth(int width) {
		this.width = width;
	}

	public void setHeight1(int height1) {
		this.height1 = height1;
	}

	public void setxPos1(int xPos) {
		this.xPos = xPos;
	}

	public void setTopOfPipe(int topOfPipe) {
		this.topOfPipe = topOfPipe;
	}

	public int getHeight2() {
		return this.height2;
	}

	public int getBottomOfPipe() {
		return this.bottomOfPipe;
	}

	public void setHeight2(int height2) {
		this.height2 = height2;
	}

	public void setBottomOfPipe(int bottomOfPipe) {
		this.bottomOfPipe = bottomOfPipe;
	}

	public int getpipeSpeed() {

		return this.RECT_SPEED;

	}

	public void setPipeSpeed(int speed) {

		this.RECT_SPEED = speed;

	}

	public int getScore() {

		return this.score;

	}

	public void setScore(int score) {

		this.score = score;

	}

}
