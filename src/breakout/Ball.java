package breakout;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Ball extends Rectangle {
	static int score = 0;
	int leftWall = 0, topWall = 0;
	int rightWall = 775;
	int bottomWall = 600;
	int dX = 3;
	int dY = 3;
	int tempDX, tempDY;
	boolean paused = false;
	
	public Ball(int x, int y, int width, int height) {
		super(350, 250, 15, 15); //already creates a ball of this size
	}
	public void update() {
		
		this.translate(dX, dY);
		
		if (GDV5.KeysPressed[KeyEvent.VK_P] == true && Breakout.gameState % 2 == 1 && Breakout.gameState != 1 && paused == false) {
			tempDX = dX;
			tempDY = dY;
			dX = 0;
			dY = 0;
			paused = true;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_R] == true && Breakout.gameState % 2 == 1 && Breakout.gameState != 1 && paused == true) {
			dX = tempDX;
			dY = tempDY;
			paused = false;
		}
		
		if(this.getX() <= leftWall) {
			dX = -dX;
			dY = dY;
		}
		if(this.getY() <= topWall) {
			dY = -dY;;
		}
		if(this.getX() >= rightWall) {
			dX = -dX;
			dY = dY;
		}
		if(this.getY() + 10 >= bottomWall) {
			setLocation(394, 400);
			dY = -3;
			Breakout.lives--;
			Breakout.p1.setLocation(300, 550);
		}
		
	}
}
