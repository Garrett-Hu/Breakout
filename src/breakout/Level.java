package breakout;

import java.awt.Color;

public class Level {
	static int z = 0;
	static Color colors[] = {Color.blue, Color.cyan, Color.red, Color.magenta, Color.orange, Color.green, Color.pink};
	
	
	public static void Level1(){
		Breakout.bricks = new Brick[24];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 8; j++) {
				Breakout.bricks[z] = new Brick((j * 95) + (5 * (j + 1)), (i * 30) + (5 * (i + 1)), colors[i]);
				z++;
			}
		}
		Breakout.gameState = 3;
		z = 0;
	}

	public static void Level2(){
		Breakout.bricks = new Brick[40];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 8; j++) {
				Breakout.bricks[z] = new Brick((j * 95) + (5 * (j + 1)), (i * 30) + (5 * (i + 1)), colors[i]);
				z++;
			}
		}
		Breakout.gameState = 5;
		z = 0;
	}
	
	public static void Level3(){
		Breakout.bricks = new Brick[48];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 8; j++) {
				Breakout.bricks[z] = new Brick((j * 95) + (5 * (j + 1)), (i * 30) + (5 * (i + 1)), colors[i]);
				z++;
			}
		}
		Breakout.gameState = 7;
		z = 0;
	}
	
	public static void Level4(){
		Breakout.bricks = new Brick[48];
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 8; j++) {
				Breakout.bricks[z] = new Brick((j * 95) + (5 * (j + 1)), (i * 30) + (5 * (i + 1)), colors[i]);
				z++;
			}
		}
		MovingBrick mb = new MovingBrick(5, 215);
		
		Breakout.gameState = 9;
		z = 0;
	}
}
