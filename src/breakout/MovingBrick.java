package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MovingBrick extends Rectangle{
	int dx = 6;
	int dy = 0;
	int leftWall = 0;
	int rightWall = 695;
	
	public MovingBrick(int x, int y) {
		super(x, y, 95, 30);
	}

	public static void draw(Graphics2D pb1, MovingBrick mb1) {
		pb1.setColor(Color.pink);
		pb1.fill(mb1);
	}
	
	public void update() {
		this.translate(dx, dy);
		if(this.getX() <= leftWall) {
			dx = -dx;
		}
		if(this.getX() >= rightWall) {
			dx = -dx;
		}
	}
}
