package gamer; 
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
    
	Animation man, movingUP, movingDOWN, movingLEFT, movingRIGHT;
	int[] duration = {200, 200 };
	Input input;

	boolean quit;
	Image bg;
	float manPositionX = 0;
	float manPositionY = 0;	
	float shiftX = manPositionX + 658;
	float shiftY =  manPositionY + 354;

	
    public Play ( int state) {
    	
    }
    
    public void init( GameContainer gc, StateBasedGame sbg)throws SlickException {
        bg  = new Image("res/world.png");
        Image[] walkUp = {new Image("res/isaacsBack.png"),new Image("res/isaacsBack.png")};
        Image[] walkDown = {new Image("res/isaacsFront.png"),new Image("res/isaacsFront.png")};
        Image[] walkLeft = {new Image("res/isaacsLeft.png"),new Image("res/isaacsLeft.png")};
        Image[] walkRight = {new Image("res/isaacsRight.png"),new Image("res/isaacsRight.png")};
        
        //Animations
        movingUP = new Animation(walkUp, duration, false );
        movingLEFT = new Animation(walkLeft, duration, false );
        movingRIGHT = new Animation(walkRight, duration, false);
        movingDOWN = new Animation( walkDown, duration, false);
    	man = movingDOWN;
    }
    public void render (GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
        bg.draw(manPositionX, manPositionY);
        man.draw(shiftX, shiftY);
        
        String Strx = "ManPos ("+manPositionX +", "+ manPositionY + ")\n";
        String Strx2 = "ShiftXY ("+ shiftX +", "+ shiftY + ")\n";
        g.drawString(Strx, 100, 100);
        g.drawString(Strx2, 100, 120);
        if ( quit == true) {
        	g.drawString("Resume (R)",570,200);
        	g.drawString("Main Menu (M)", 570, 240);
        	g.drawString("Quit (Q)",570, 280);
        	if ( quit == false ) {
        		g.clear(); 
        	}
        }
        
        
        
    }

    public void update (GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
    	input = gc.getInput();
    	if ( input.isKeyDown(Input.KEY_DOWN) ) {
    		man = movingDOWN;
    		//shiftY++;
    		manPositionY -=delta * .1f; 
    		if ( manPositionY < -340)
    			manPositionY +=delta * .1f;
    
    
    	}
    	
    	if ( input.isKeyDown(Input.KEY_UP) ) {
    		man = movingUP;
    		//shiftY--;
    		manPositionY +=delta * .1f;
    	
    	if ( manPositionY > 347)
    		manPositionY -=delta * .1f;
    	}
    
    
    
    	if ( input.isKeyDown(Input.KEY_LEFT) ) {
    		man = movingLEFT;
    		//shiftX--;
    		manPositionX +=delta *.1f;
    		if ( manPositionX > 654)
    			manPositionX -=delta * .1f;
    			
    	}
   
    	if ( input.isKeyDown(Input.KEY_RIGHT) ) {
    		man = movingRIGHT;
    		//shiftX++;
    		manPositionX -=delta *.1f;
    	
    		if ( manPositionX < -649)
    		manPositionX +=delta * .1f;
    
    	}
    
    	if ( input.isKeyDown(Input.KEY_ESCAPE) )
    		quit = true;
    
  
    	if ( quit == true) {
    		if( input.isKeyDown(Input.KEY_R))
    			quit = false;
    	
    		if( input.isKeyDown(Input.KEY_Q)) {
    			System.exit(0);
    		} 
    			
    		
    		if( input.isKeyDown(Input.KEY_M) ) {
    			sbg.enterState(0);
    			
    		}
    	
    	
    	}
    }
    
    public int getID(){
        return 1;
    }
     	
}

