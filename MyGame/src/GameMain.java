
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 
 * @author JJMP
 *
 */

	//the class that runs the game 

public class GameMain {
	
	//creates the things that will be used from other classes on this class
	
	public static DisplayScreen display;
	
	public static MusicStuff music = new MusicStuff();
	
	static Image icon;

	public static void main(String[] args) throws InterruptedException{	
				
	//uses image from the 'images' package
		
		try {
			icon = ImageIO.read(new File("res/images/BeedrilIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}		
		
	//creates a new frame for the game with the title
		
		JFrame mainFrame = new JFrame("Beedrill Dash");
		
		display = new DisplayScreen();
		
	//sets the size of the game frame
		
		mainFrame.setSize(600, 800);
		
	//adds the display screen 	
		
		mainFrame.add(display);
		
		mainFrame.addKeyListener(display.getKeys());
		
		mainFrame.setVisible(true);
		
		mainFrame.setResizable(false);
		
		mainFrame.setIconImage(icon);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		music.playSong(music.getAudioFile());
		
	//update mechanism
		
		while(!display.playerCrashed) {
			
			mainFrame.repaint();
			
			Thread.sleep(25);
			
		}
		
	}
	
	//a couple GETTERS
	
	public static DisplayScreen getDisplayScreen() {
		
		return display;
		
	}
	
	public static MusicStuff getMusic() {
		
		return music;
		
	}

}
