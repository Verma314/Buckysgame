
package gamer;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState {
	
	Image playNow;
	Image exit;
	
	
	String mouseLoc;
	
	int mLocX,mLocY;
	
	
	public Menu ( int state) {
        
    }
    
    public void init( GameContainer gc, StateBasedGame sbg)throws SlickException {
    	this.mouseLoc = "Not in it!";
    	this.playNow = new Image("res/playNow.png");
    	this.exit = new Image("res/exitGame.png");
    
    }
    
    public void render (GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
    	g.drawString("Welcome to IceMMO", 570, 200);
    	g.drawImage(playNow, 570, 300);
    	g.drawImage(exit, 570, 400 );
    	g.drawString("(C) Created by Verma, 2016", 1000, 700);
    	
    	
    	
    	//Debugging line:
    	g.drawString (this.mouseLoc, 50,50);
    }
    

    public void update (GameContainer gc, StateBasedGame sbg,int delta)throws SlickException {
    	mLocX = Mouse.getX();
    	mLocY = Mouse.getY();
    	this.mouseLoc = " X: "+ mLocX + " Y: "+ mLocY;
    	
    	
    	if ( ( mLocX <= 770 && mLocX >= 570) 
    		&& (mLocY <=470  && mLocY >= 440 ) )
    		if ( Mouse.isButtonDown(0))
    		sbg.enterState(1);
    		
    
        	
    	if ( ( mLocX <= 770 && mLocX >= 570) 
    	    && (mLocY <=370 && mLocY >= 340 ) )
    		if ( Mouse.isButtonDown(0))
    			exit();
     
    
    }
  
    private void exit() {
		System.exit(0);
	}

	public int getID(){
        return 0;
    }
     
}

 	