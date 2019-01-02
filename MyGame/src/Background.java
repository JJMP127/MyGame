
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 
 * @author JJMP
 *
 */

public class Background {
	
	public int sunSize = 150;
	public int sunX =  400;
	public int sunY = 200;
	
	public int backgroundX1 = 0;
	public int backgroundX2 = 600;
	public int backgroundY = 0;
	public int BACKGROUND_SPEED = 3;
	public int width = 600;
	public int height = 800;
	
	public int SUN_SPEED = 1; 
	
	Random random = new Random();
	
	public int authorNameX = 600;
	
	public int authorNameY = random.nextInt(600) + 100;
	
	Color[] colors = {Color.BLUE, Color.GRAY, Color.GREEN, Color.YELLOW, Color.WHITE, Color.RED, Color.PINK,Color.MAGENTA, Color.ORANGE};	
	
	Ellipse2D.Double sun;
	
	Image background;
	
	Image background2;
	
	Image ground;
	
	public void draw(Graphics g) {
		
		try {
			background = ImageIO.read(new File("res/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}	
		
		try {
			background2 = ImageIO.read(new File("res/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}	
		
		try {
			ground = ImageIO.read(new File("res/ground2.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}	
		
		Graphics2D g2 = (Graphics2D) g;
		
		sun = new Ellipse2D.Double(this.sunX, this.sunY, this.sunSize, this.sunSize);
		
		g2.setColor(Color.YELLOW);
		
		g2.fill(sun);
		
		g2.drawImage(background, this.getBackgroundX1(), this.getBackgroundY(), this.width, this.height, null);
		
		g2.drawImage(background2, this.getBackgroundX2(), this.getBackgroundY(), this.width, this.height, null);	
		
		g2.drawImage(ground, this.getBackgroundX1(), 700, this.width, 75, null);
		
		g2.drawImage(ground, this.getBackgroundX2(), 700, this.width, 75, null);
		
		this.setBackgroundX1(this.getBackgroundX1() - this.getBACKGROUND_SPEED());
		
		this.setBackgroundX2(this.getBackgroundX2() - this.getBACKGROUND_SPEED());

		this.setSunX(this.getSunX() - this.getSUN_SPEED());
		
		if(this.getSunX() + this.getSunSize() <= 0) this.setSunX(600);
		
		if(this.getBackgroundX1() + this.width <= 0) this.setBackgroundX1(600);
		
		if(this.getBackgroundX2() + this.width <= 0) this.setBackgroundX2(600);
		
		g2.setFont(new Font("IMPACT", Font.BOLD, 40));
		
		this.authorNameX -= 10;
		
		g2.setColor(colors[random.nextInt(colors.length - 1)]);
		
		g2.drawString("Made by: JJMP", this.authorNameX, this.authorNameY);
		
		if(this.authorNameX + 230 < 0) {
				
			this.authorNameX = 600;
		
			this.authorNameY = this.random.nextInt(600) + 100;
			
		}
		
	}

	public int getSunSize() {
		return sunSize;
	}

	public int getBackgroundX1() {
		return backgroundX1;
	}
	
	public int getBackgroundX2() {
		return this.backgroundX2;
	}

	public int getBackgroundY() {
		return backgroundY;
	}

	public int getSUN_SPEED() {
		return SUN_SPEED;
	}

	public void setBackgroundX1(int backgroundX) {
		this.backgroundX1 = backgroundX;
	}
	
	public void setBackgroundX2(int backgroundX2) {
		
		this.backgroundX2 = backgroundX2;
		
	}

	public void setBackgroundY(int backgroundY) {
		this.backgroundY = backgroundY;
	}

	public void setSUN_SPEED(int sUN_SPEED) {
		SUN_SPEED = sUN_SPEED;
	}

	public int getSunX() {
		return sunX;
	}

	public int getSunY() {
		return sunY;
	}

	public int getBACKGROUND_SPEED() {
		return BACKGROUND_SPEED;
	}

	public Ellipse2D.Double getSun() {
		return sun;
	}

	public void setSunSize(int sunSize) {
		this.sunSize = sunSize;
	}

	public void setSunX(int sunX) {
		this.sunX = sunX;
	}

	public void setSunY(int sunY) {
		this.sunY = sunY;
	}

	public void setBACKGROUND_SPEED(int bACKGROUND_SPEED) {
		BACKGROUND_SPEED = bACKGROUND_SPEED;
	}

	public void setSun(Ellipse2D.Double sun) {
		this.sun = sun;
	}
	
	

}
