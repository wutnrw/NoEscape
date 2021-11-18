/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectGame;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

/**
 *
 * @author Narawut
 */
public class Background {
    private BufferedImage image;
    
    private double x;
    private double y;
    private double dy;
    private double dx;
    
    private double moveScale;
    
    public Background(String s,double ms){
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream(s));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setPosition(double x,double y){
        this.x = (x*moveScale)%GamePanel.WIDTH;
        this.y = (y*moveScale)%GamePanel.HEIGHT;
    }
    public void setVector(double dx,double dy){
        this.dx = dx;
        this.dy = dy;
    }
    public void update(){
        x += dx;
        y += dy;
    }
    public void draw(Graphics2D g){
        
        g.drawImage(image,(int)x,(int)y,null);
        if(x<0){
            g.drawImage(image,(int)x+GamePanel.WIDTH, (int)y,null);
        }
        if(x>0){
            g.drawImage(image,(int)x-GamePanel.WIDTH, (int)y, null);
        }
    }
}
