package gamer;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	public static final String gamename = "Game of Death";
    public static final int menu = 0;
    public static final int play = 1;
    
    
    public Game ( String gamename) {
        super(gamename);
        this.addState( new Menu(menu));
        this.addState( new Play(play));
       
    }
    
    
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(menu).init(gc, this);
        this.getState(play).init(gc, this);
        //initialize the two states, menu and play
        this.enterState(menu);
        
    }
    

    public static void main(String arg[]) {
        AppGameContainer appgc; //A game container that will display the 
                                //game as a stand-alone container
        try { 
            //create the window 
            appgc = new AppGameContainer( new Game(gamename));
            appgc.setDisplayMode(1366, 768, true);
            appgc.start();
            
    }catch (SlickException e) {
        e.printStackTrace();
    }}
}
