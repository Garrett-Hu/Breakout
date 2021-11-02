package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import utilities.GDV5;

public class Brick extends Rectangle {
	Color currentcolor = Color.blue;
	
	public Brick(int x, int y, Color c1) {
		super(x, y, 95, 30);
		currentcolor = c1;
	}
	
	public static void draw(Graphics2D pb, Brick bricks[]) {
		for(Brick b: bricks) {
			pb.setColor(b.currentcolor);
			pb.fill(b);
		}	
	}
}
