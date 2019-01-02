
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

public class GameMain {
	
	public static DisplayScreen display;
	
	public static MusicStuff music = new MusicStuff();
	
	static Image icon;

	public static void main(String[] args) throws InterruptedException{	
				
		try {
			icon = ImageIO.read(new File("res/BeedrilIcon.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}		
		
		JFrame mainFrame = new JFrame("Beedrill Dash");
		
		display = new DisplayScreen();
		
		mainFrame.setSize(600, 800);
		
		mainFrame.add(display);
		
		mainFrame.addKeyListener(display.getKeys());
		
		mainFrame.setVisible(true);
		
		mainFrame.setResizable(false);
		
		mainFrame.setIconImage(icon);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		music.playSong(music.getAudioFile());
		
		while(!display.playerCrashed) {
			
			mainFrame.repaint();
			
			Thread.sleep(25);
			
		}
		
	}
	
	public static DisplayScreen getDisplayScreen() {
		
		return display;
		
	}
	
	public static MusicStuff getMusic() {
		
		return music;
		
	}

}
