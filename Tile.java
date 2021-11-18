/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectGame;

import java.awt.image.BufferedImage;

/**
 *
 * @author Narawut
 */

public class Tile {
	
	private BufferedImage image;
	private int type;
	
	
	public static final int NORMAL = 0;
	public static final int BLOCKED = 1;
	
	public Tile(BufferedImage image, int type) {
		this.image = image;
		this.type = type;
	}
	
	public BufferedImage getImage() 
        { 
            return image;
        }
	public int getType() 
        { 
            return type; 
        }
	
}
