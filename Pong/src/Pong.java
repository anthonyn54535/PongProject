import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Pong extends Frame {
	
	//variables for the ball
	int xBall = 937;
	int yBall=487;
	int widthBall=50; //we change this later
	Color ballColor = new Color(187, 189, 246);
	
	
	//variables for the left paddle
	int xPaddleLeft = 0;
	int yPaddleLeft = 150;
	int paddleWidth = 20;
	int paddleHeight = 250;
	Color paddleColor = new Color(187, 189, 246);
	
	//variables for the right paddle
		int xPaddleRight = 1900;
		int yPaddleRight = 150;
		int paddleWidthR = 20;
		int paddleHeightR = 250;
		Color paddleColorR = new Color(187,189,246);
		
	int playerScore1=0;
	int playerScore2=0;
		
	//movement variable
		int movementY = 7;
		int movementX = 6;
	
	/* paint is getting called roughly 60x per second */
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		//paintbackground
				g.setColor(new Color(37,38,39));
				g.fillRect(0, 0,2000,2000);
				
				
		//drawingTEXT on the frame
		Font f = new Font("serif", Font.PLAIN, 80);
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString(""+playerScore1, 900, 80);
		g.drawString(""+playerScore2, 974, 80);
		
		
		
		
		//paint the pong ball
		g.setColor(ballColor);
		g.fillOval(xBall, yBall, widthBall, widthBall);
		
		//code for updating the POSITION of the ball object
		xBall += movementX; //same as xBall = xBall + movementX;
		yBall += movementY; 
		
		/*
		 * if-statements (conditional statements)
		 * a.k.a blocking statements
		 * 
		 * if(condition){
		 * 	run if condition is true
		 * }
		 * 
		 * 
		 */
		//bounce on right side
		if(xBall > 1875) {
			movementX*=-1;
		}
		//bounce on bottom of screen
		if(yBall >= 975) {
			movementY = (int)(Math.random()*(15-10+1))+10;
			movementY*=-1;
		}
		//bounce on top side
		if(yBall <= 0) {
			movementY = (int)(Math.random()*(15-10+1))+10;
			
		}
		//bounce on left side
		if(xBall < 0) {
			movementX*=-1;
		}
		//reset bakk to go to the center 
		if(xBall<0) {
			playerScore2++;
			xBall=937;
			yBall=487;
			movementX = (int)(Math.random()*(15-10+1))+10;
			if(Math.random()<.50) {
				//this is goin happen 50% of the time
				movementX*=-1;
			}
				
			}
			
		if(xBall>1875) {
			playerScore1++;
			xBall=937;
			yBall=487;
			movementX = (int)(Math.random()*(15-10+1))+10;
			if(Math.random()<.50) {
				//this is goin happen 50% of the time
				movementX*=-1;
			}
				}
		
		//left paddle collion
		if(xBall>=xPaddleLeft && xBall <=xPaddleLeft + 20 && yBall>=yPaddleLeft && yBall<=yPaddleLeft+paddleHeight) {
			movementX*=-1;
		}
		//right paddle
		if(xBall+50>=xPaddleRight && xBall+50 <=xPaddleRight + 20 && yBall+25>=yPaddleRight && yBall+25<=yPaddleRight+paddleHeight) {
			movementX*=-1;
		}
		//update speed and direction to be randomized
		//random # formula
		//int randValue = (int) (Math.random()*(range+1))+min;
		// where range is max-min, and max is the largest val and min is the lowest val
			
		//paint the paddle
		g.setColor(paddleColor);
		g.fillRect(xPaddleLeft, yPaddleLeft, paddleWidth, paddleHeight);
		
		//paint the right paddle
				g.setColor(paddleColorR);
				g.fillRect(xPaddleRight, yPaddleRight, paddleWidthR, paddleHeightR);
		// end game
		if(playerScore1==5 || playerScore2==5) {
			playerScore1=0;
			playerScore2=0;
		}
		//blocks paddle from leaving screen
		if(yPaddleLeft<=0) {
			yPaddleLeft=150;
		}
		if(yPaddleLeft+250>=1000) {
			yPaddleLeft=600;
		}
		if(yPaddleRight<=0) {
			yPaddleRight=150;
		}
		if(yPaddleRight+250>=1000) {
			yPaddleRight=600;
		}
} // end of paint method
		
		
	
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode());
		
		if(arg0.getKeyCode()==83){ //'s' key
			yPaddleLeft+=15; //left-paddle y position
		}
		if(arg0.getKeyCode()==87) {
			yPaddleLeft-=15;
		}
		if(arg0.getKeyCode()==38){ 
			yPaddleRight-=15; 
		}
		if(arg0.getKeyCode()==40) {
			yPaddleRight+=15;
		}
		
	}


	public void keyReleased(KeyEvent arg0) {
		
		
	}


	public void keyTyped(KeyEvent arg0) {
		
		
	}
	public static void main(String[] arg) {
		Pong p = new Pong();
	}
	
}
