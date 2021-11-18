/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectGame;
import java.util.ArrayList;
/**
 *
 * @author Narawut
 */
public class GameStateManager {
    
    private ArrayList<GameState> gameStates;
    private int currentState;
    
    public static final int MENUSTATE = 0;
    public static final int LEVELSTATE1 = 1;
    
    public GameStateManager(){
        
        gameStates = new ArrayList<GameState>();
        
        
        currentState = MENUSTATE;
        gameStates.add(new MenuState(this));
        gameStates.add(new LevelState1(this));
    }

    
    public void setState(int state){
        currentState = state;
        gameStates.get(currentState).init();
        
    }
    public void update(){
        
        gameStates.get(currentState).update();
    }
    
    public void draw(java.awt.Graphics2D g){
        gameStates.get(currentState).draw(g);
    }
    
    public void keyPressed(int k){
        gameStates.get(currentState).keyPressed(k);
    }
    public void keyReleased(int k){
        gameStates.get(currentState).keyReleased(k);
    }
}
