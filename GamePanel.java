/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectGame;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.net.URL;



/**
 *
 * @author Narawut
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	// dimensions
	public static final int WIDTH = 220;
	public static final int HEIGHT = 220;
	public static final int SCALE = 4;
	
	// game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	// image
	private BufferedImage image;
	private Graphics2D g;
	
	// game state manager
	private GameStateManager gsm;
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	
	private void init() {
		
		image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		running = true;
		
		gsm = new GameStateManager();
		
	}
	
	public void run() {
		
		init();
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			
			start = System.nanoTime();
			update();
			draw();
			drawToScreen();
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			if(wait < 0) wait = 5;
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void update() 
        {
		gsm.update();
	}
        
	private void draw() 
        {
		gsm.draw(g);
	}
	private void drawToScreen()
        {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0,WIDTH * SCALE, HEIGHT * SCALE,null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) 
        {
            
        }
	public void keyPressed(KeyEvent key)
        {
		gsm.keyPressed(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key) 
        {
		gsm.keyReleased(key.getKeyCode());
	}

}