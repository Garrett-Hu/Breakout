package breakout;

import utilities.GDV5;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyListener;


public class Paddle extends Rectangle {
	int dX = 0;
	int dY = 0;
	
	public Paddle(int x, int y, int width, int height) {
		super(300, 550, 100, 12);
	}

	public void keysPressed() {
		if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] == true) {
			Breakout.gameState = 0;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_V] == true && Breakout.gameState == 3) {
			Breakout.gameState++;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_B] == true && Breakout.gameState == 5) {
			Breakout.gameState++;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_N] == true && Breakout.gameState == 7) {
			Breakout.gameState++;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_J] == true && Breakout.gameState == 9) {
			Breakout.gameState++;
		}
		
		if (GDV5.KeysPressed[KeyEvent.VK_A] == false && GDV5.KeysPressed[KeyEvent.VK_D] == false) {
            dX = 0;
        } 
		if (GDV5.KeysPressed[KeyEvent.VK_W] == false && GDV5.KeysPressed[KeyEvent.VK_S] == false) {
            dY = 0;   
        } 
		if (GDV5.KeysPressed[KeyEvent.VK_A] == true && GDV5.KeysPressed[KeyEvent.VK_D] == true) {
            dX = 0;
        }
		if (GDV5.KeysPressed[KeyEvent.VK_W] == true && GDV5.KeysPressed[KeyEvent.VK_S] == true) {
            dY = 0;
        }
		
		if (GDV5.KeysPressed[KeyEvent.VK_A] == true) {
            if (this.getX() <= 12) {
                dX = 0;
            } else {
                dX = -5;
            }
        } else if (GDV5.KeysPressed[KeyEvent.VK_D] == true) {
            if (this.getX() + width >= 800) {
                dX = 0;
            } else {
                dX = 5;
            }
        }
		
		if (GDV5.KeysPressed[KeyEvent.VK_W] == true) {
            if (this.getY() <= 550) {
                dY = 0;
            } else {
                dY = -5;
            }
        } else if (GDV5.KeysPressed[KeyEvent.VK_S] == true) {
            if (this.getY() >= 590) {
                dY = 0;
            } else {
                dY = 5;
            }
        }
        
    }

	public void update() {
		keysPressed();
		this.translate(dX, dY);
		
	}
}	