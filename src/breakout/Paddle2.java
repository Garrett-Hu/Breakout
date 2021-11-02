package breakout;

import utilities.GDV5;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyListener;


public class Paddle2 extends Rectangle {
	int dX = 0;
	int dY = 0;
	
	public Paddle2(int x, int y, int width, int height) {
		super(300, 550, 100, 12);
	}

	public void keysPressed() {
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT] == false && GDV5.KeysPressed[KeyEvent.VK_RIGHT] == false) {
            dX = 0;
        } 
		if (GDV5.KeysPressed[KeyEvent.VK_UP] == false && GDV5.KeysPressed[KeyEvent.VK_DOWN] == false) {
            dY = 0;   
        } 
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT] == true && GDV5.KeysPressed[KeyEvent.VK_RIGHT] == true) {
            dX = 0;
        }
		if (GDV5.KeysPressed[KeyEvent.VK_UP] == true && GDV5.KeysPressed[KeyEvent.VK_DOWN] == true) {
            dY = 0;
        }
		
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT] == true) {
            if (this.getX() <= 12) {
                dX = 0;
            } else {
                dX = -5;
            }
        } else if (GDV5.KeysPressed[KeyEvent.VK_RIGHT] == true) {
            if (this.getX() + width >= 800) {
                dX = 0;
            } else {
                dX = 5;
            }
        }
		
		if (GDV5.KeysPressed[KeyEvent.VK_UP] == true) {
            if (this.getY() <= 550) {
                dY = 0;
            } else {
                dY = -5;
            }
        } else if (GDV5.KeysPressed[KeyEvent.VK_DOWN] == true) {
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