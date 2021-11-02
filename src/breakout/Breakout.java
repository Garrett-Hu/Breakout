package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import utilities.GDV5;

public class Breakout extends GDV5 {
	static Brick bricks[];
	static Ball b1 = new Ball(350, 250, 15, 15);
	static Paddle p1 = new Paddle(300, 550, 100, 12);
	static Paddle2 p2;
	static MovingBrick mb1 =  new MovingBrick(5, 215);
	static int gameState = 0;
	static int score = 0;
	static int lives = 3;
	static int counter = 0;
	int x = 0;
	File Hit = new File("Blop-Mark_DiAngelo-79054334");
	
	public static void main(String[] args) {
		Breakout br1 = new Breakout();
		br1.start();
	}

	@Override
	public void update() {
		if(gameState > 2 && gameState % 2 == 1) {
			checkCollision();
			collisionBrick();
			lifeCheck();
			b1.update();
			p1.update();
			if(gameState == 9) {
				if(x == 0 && GDV5.KeysPressed[KeyEvent.VK_M] == true) { 
					p2 = new Paddle2(300, 550, 100, 12);
					x++;
				}
				if(x == 1) {
					p2.update();
					checkCollision2();
				}
				
				collisionMovingBrick();
				mb1.update();
			}	
		}
	}

	public static void makeBricks() {
		//level 1
		if(gameState == 2) {
			Level.Level1();
		}//level 2
		if(gameState == 4) {
			Level.Level2();
		}//level 3
		if(gameState == 6) {
			Level.Level3();
		}//level 4
		if(gameState == 8) {
			Level.Level4();
		}
	}
	
	
	@Override
	public void draw(Graphics2D win) {
		win.setColor(Color.white);
		//menu
		if(gameState == 0) {
			win.setFont(new Font("Arial", Font.BOLD, 100));
			win.drawString("Breakout", 170, 100);
			win.setFont(new Font("Arial", Font.BOLD, 50));
			win.drawString("Made by Garrett Hu", 165, 175);
			win.drawString("Press Enter to play", 165, 375);
			win.drawString("Press Z for Instructions", 120, 475);
			if (GDV5.KeysPressed[KeyEvent.VK_Z] == true) {
				gameState = 1;
			}
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER] == true) {
				gameState = 2;
				lives = 3;
				score = 0;
			}	
		}
		//instructions
		if(gameState == 1) {
			win.setFont(new Font("Arial", Font.BOLD, 17));
			win.drawString("1. A ball will be sent flying, and your goal is to prevent it from falling to the bottom of the screen.", 10, 30);
			win.drawString("2. To do so, move the Paddle with the WASD keys within a small region.", 10, 90);
			win.drawString("3. After hitting the ball with your Paddle, the ball will be thrown upwards towards a set of bricks.", 10, 150);
			win.drawString("4. When the ball collides with a brick, that brick will be destroyed.", 10, 210);
			win.drawString("5. After all of the bricks are destroyed, the game will proceed to another level. There are 4 levels.", 10, 280);
			win.drawString("6. If the ball happens to fall beyond the bottom, you will lose a life.", 10, 340);
			win.drawString("7. You start with 3 lives, and once you hit 0 lives, the game will end", 10, 400);
			win.drawString("8. Keep track of your lives and the score at the bottom-left of the screen", 10, 460);
			win.drawString("9. Try to get the highest score! Good luck and have fun! If you wish to end the game, press 'esc' at any time", 10, 520);
			win.drawString("10. Press Enter to start", 10, 580);
			if (GDV5.KeysPressed[KeyEvent.VK_ENTER] == true) {
				gameState = 2;
				lives = 3;
				score = 0;
			}
		}
		//score & life count
		if(gameState != 0 && gameState != 1 && gameState != 10 && gameState != 12 ) {
			win.setFont(new Font("Arial", Font.BOLD, 20 ));
			win.drawString("Level: " + gameState / 2, 20, 460);
			win.drawString("Score: " + score, 20, 500);
			win.drawString("Lives: " + lives, 20, 540);	
		}
		
		if(gameState == 2) { 
			makeBricks(); //populates array
			Brick.draw(win, bricks); //to the Brick class, draws the bricks
			
			win.setColor(Color.white);
			win.fill(b1);
			win.fill(p1);
		}
		if(gameState == 3) {
			Brick.draw(win, bricks); 
			win.setColor(Color.white);
			win.fill(b1);
			win.fill(p1);
			if(score == 24000) {
				setLocation(394, 400);
				gameState = 4;
			}
		}
		//level 2
		if(gameState == 4) { 
			makeBricks();
			Brick.draw(win, bricks);
			
			win.setColor(Color.white);
			win.fill(b1);
			win.fill(p1);
		}
		if(gameState == 5) {
			Brick.draw(win, bricks); 
			win.setColor(Color.white);
			win.fill(b1);
			win.fill(p1);
			if(score == 40000) {
				gameState = 6;
			}
		}
		//level 3
		if(gameState == 6) { 
			makeBricks();
			Brick.draw(win, bricks);
			
			win.setColor(Color.white);
			win.fill(b1);
			win.fill(p1);
		}
		if(gameState == 7) {
			Brick.draw(win, bricks); 
			win.setColor(Color.white);
			win.fill(b1);
			win.fill(p1);
			if(score == 48000) {
				gameState = 8;
			}
		}//level 4
		if(gameState == 8) { 
			makeBricks();
			Brick.draw(win, bricks);
			
			win.setColor(Color.white);
			win.fill(b1);
			win.fill(p1);
		}
		if(gameState == 9) {
			Brick.draw(win, bricks); 
			MovingBrick.draw(win, mb1);
			win.setColor(Color.white);
			win.fill(b1);
			win.fill(p1);
			win.setColor(Color.red);
			if(x == 1) {
				win.fill(p2);
			}
			if(score == 50000) {
				gameState = 10;
			}
		}
		if(gameState == 10) {
			win.setColor(Color.green);
			win.setFont(new Font("Arial", Font.BOLD, 100));
			win.drawString("You won!!!", 170, 100);
			win.setFont(new Font("Arial", Font.BOLD, 50));
			win.setColor(Color.white);
			win.drawString("Final Score:" + score, 235, 175);
			win.drawString("Lives Remaining: " + lives, 165, 375);
			win.drawString("Press Escape to play again!", 95, 475);
			if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] == true) {
				Breakout.gameState = 0;
			}
		}
		if(gameState == 12) {
			win.setColor(Color.red);
			win.setFont(new Font("Arial", Font.BOLD, 100));
			win.drawString("You lost!!!", 170, 100);
			win.setFont(new Font("Arial", Font.BOLD, 50));
			win.setColor(Color.white);
			win.drawString("Final Score:" + score, 235, 175);
			win.drawString("Lives Remaining: " + lives, 165, 375);
			win.drawString("Press Escape to play again!", 95, 475);
			if (GDV5.KeysPressed[KeyEvent.VK_ESCAPE] == true) {
				Breakout.gameState = 0;
			}
		}
		
	}
	//ball * paddle collision
	public void checkCollision() {
		
		if((b1.intersects(p1) == true)) {
			b1.dY = b1.dY * (-1);
			PlaySound(Hit);
		}
	}
	//ball * paddle2 collision
	public void checkCollision2() {
		
		if((b1.intersects(p2) == true)) {
			b1.dY = b1.dY * (-1);
			PlaySound(Hit);
		}
	}
	//ball * brick collision
	public void collisionBrick() {
		for(int i = 0; i < bricks.length; i++) {
			if(b1.intersects(bricks[i])) {
				bricks[i].setLocation(1000, 1000);
				b1.dY = b1.dY * (-1);
				score += 1000;
				PlaySound(Hit);
			}
		}
	}
	public void collisionMovingBrick() {
		for(int i = 0; i < 1; i++) {
			if(b1.intersects(mb1)) {
				mb1.setLocation(1000, 1000);
				b1.dY = b1.dY * (-1);
				score += 1000;
				PlaySound(Hit);
			}
		}
	}
	public void lifeCheck() {
		if(lives <= 0) {
			gameState = 12;
		}	
	}
	public static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e) {
			
		}
	}
}

//bricks[z] = new Brick((j * 100) + (5 * (j + 1)), (i * 25) + (5 * (i + 1)), colors[i]);
//bricks[z] = new Brick(j * 105, i * 35, colors[i]);

/*		//level 2
if(gameState == 4) {
	for(int i = 0; i < 8; i++) {
		for(int j = 0; j < 4; j++) {
			bricks[z] = new Brick(i * 100, j * 25, colors[j]);
			z++;
		}
	}
gameState = 5;
z = 0;
}
*/		
//continuosuly called, so it keeps drawing the bricks even after being destroyed...need to change something...but if i change gamestate it makes bricks invisible
//static MovingBrick brick[] = new MovingBrick[1];


/* String hitSound = "C:\\Users\\garretth2402\\Downloads\\Blop-Mark_DiAngelo-79054334.wav";

File audioFile = new File(hitSound);
 
AudioInputStream audioStream = getAudioInputStream(audioFile);

private AudioInputStream getAudioInputStream(File audioFile2) {
	// TODO Auto-generated method stub
	return null;
}
*/