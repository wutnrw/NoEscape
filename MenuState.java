/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectGame;

import java.awt.Color;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.Font;
import java.awt.event.KeyEvent;
import static javafx.scene.text.Font.font;

/**
 *
 * @author Narawut
 */
public class MenuState extends GameState{
    
    private Background bg;
    
    private int currentChoice = 0;
    private String[] options = {
        "Start","Quit"
    };
    
    private Color titleColor;
    private Font titleFont;
    
    private Font font;
    public MenuState(GameStateManager gsm){
        this.gsm = gsm;
        
        try{
            bg = new Background("/Picture/Starpic.jpg",1);
     
            bg.setVector(-0.1,0);
            
            titleColor = new Color(128,0,0);
            titleFont = new Font("Century Gothic",Font.BOLD,40);
            
            Font font = new Font("Arial",Font.PLAIN,12);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void init(){
        
    }
    public void update(){
        bg.update();
    }
    public void draw(java.awt.Graphics2D g){
        //วาด bg
        bg.draw(g);
        
        //title
        g.setColor(GREEN);
        g.setFont(titleFont);
        g.drawString("No Escape",5,70);
          
        g.setFont(font);
        for(int i=0;i<options.length;i++){
            if(i==currentChoice){
                g.setColor(Color.YELLOW);
                
            }
            else{
                g.setColor(Color.RED);
            }
            g.drawString(options[i], 70 , 140 + i*40);
        }
                
        
    }
    
    private void select(){
        if(currentChoice == 0){
            gsm.setState(GameStateManager.LEVELSTATE1);
            //start
        }
        if(currentChoice == 1){
            System.exit(0);
            //stop
        }
    }
    public void keyPressed(int k){
        if(k==KeyEvent.VK_ENTER){
            select();
            
        }
        if(k==KeyEvent.VK_UP){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length - 1;
            }
            
        }
        if(k==KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0;
            }
            
        }
        
    }
    public void keyReleased(int k){
        
    }
}
