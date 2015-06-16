package edu.uchicago.cs.java.finalproject.controller;

import edu.uchicago.cs.java.finalproject.game.model.*;
import edu.uchicago.cs.java.finalproject.game.view.GamePanel;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
// ===============================================
// == This Game class is the CONTROLLER
// ===============================================

public class Game implements Runnable, KeyListener {

	// ===============================================
	// FIELDS
	// ===============================================

	public static final Dimension DIM = new Dimension(1100, 700); //the dimension of the game.
	private GamePanel gmpPanel;
	public static Random R = new Random();
	public final static int ANI_DELAY = 45; // milliseconds between screen
	// updates (animation)
	private Thread thrAnim;
	private int nLevel = 1;
	private int nTick = 0;
	private ArrayList<ImMovable> brickRemovals;
	private ArrayList<ImMovable> brickArray;
	private boolean bMuted = true;
	//private ArrayList<Tuple> tupMarkForRemovals;
	private static long theScore = 0;


	private final int PAUSE = 80, // p key
			QUIT = 81, // q key
			LEFT = 37, // rotate left; left arrow
			RIGHT = 39, // rotate right; right arrow
			UP = 38, // thrust; up arrow
			START = 83, // s key
			FIRE = 32, // space key
			MUTE = 77, // m-key mute

	// for possible future use
	// HYPER = 68, 					// d key
	// SHIELD = 65, 				// a key arrow
	// NUM_ENTER = 10, 				// hyp
	SPECIAL = 70; 					// fire special weapon;  F key

	private Clip clpThrust;
	private Clip clpMusicBackground;

	private static final int SPAWN_NEW_SHIP_FLOATER = 1200;



	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================

	public Game() {

		gmpPanel = new GamePanel(DIM);
		gmpPanel.addKeyListener(this);

		//clpThrust = Sound.clipForLoopFactory("whitenoise.wav");
		//clpMusicBackground = Sound.clipForLoopFactory("music-background.wav");

	}

	// ===============================================
	// ==METHODS
	// ===============================================

	public static void main(String args[]) {

		//Game game = new Game(); // construct itself
		//game.fireUpAnimThread();
		EventQueue.invokeLater(new Runnable() { // uses the Event dispatch thread from Java 5 (refactored)
			public void run() {
				try {
					Game game = new Game(); // construct itself
					game.fireUpAnimThread();


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void fireUpAnimThread() { // called initially
		if (thrAnim == null) {
			thrAnim = new Thread(this); // pass the thread a runnable object (this)
			thrAnim.start();
		}
	}

	// implements runnable - must have run method
	public void run() {

		// lower this thread's priority; let the "main" aka 'Event Dispatch'
		// thread do what it needs to do first
		thrAnim.setPriority(Thread.MAX_PRIORITY);

		// and get the current time
		long lStartTime = System.currentTimeMillis();

		// this thread animates the scene
		//checkNewLevel();
		//checkNewLevel();

		//making a ball
		//checkCollisions();

		while (Thread.currentThread() == thrAnim) {
			tick();
			//spawnNewShipFloater();
			gmpPanel.update(gmpPanel.getGraphics()); // update takes the graphics context we must


//			checkGameOver();
		//	checkNewLevel();

			// surround the sleep() in a try/catch block
			// this simply controls delay time between
			// the frames of the animation

			//this might be a good place to check for collisions
			checkCollisions();
			checkGameOver();
			//this might be a god places to check if the level is clear (no more foes)
			//if the level is clear then spawn some big asteroids -- the number of asteroids
			//should increase with the level./
			checkNewLevel();

		//	checkGameOver();
			try {
				// The total amount of time is guaranteed to be at least ANI_DELAY long.  If processing (update)
				// between frames takes longer than ANI_DELAY, then the difference between lStartTime -
				// System.currentTimeMillis() will be negative, then zero will be the sleep time
				lStartTime += ANI_DELAY;
				Thread.sleep(Math.max(0,
						lStartTime - System.currentTimeMillis()));
			} catch (InterruptedException e) {
				// just skip this frame -- no big deal
				continue;
			}
		} // end while
	} // end run

	private void checkCollisions() {


		//@formatter:off
		//for each friend in movFriends
		//for each foe in movFoes
		//if the distance between the two centers is less than the sum of their radii
		//mark it for removal

		//for each mark-for-removal
		//remove it
		//for each mark-for-add
		//add it
		//@formatter:on

		//we use this ArrayList to keep pairs of movMovables/movTarget for either
		//removal or insertion into our arrayLists later on
		//	tupMarkForRemovals = new ArrayList<Tuple>();
		//	tupMarkForAdds = new ArrayList<Tuple>();

		Point pntFriendCenter, pntFoeCenter;
		int nFriendRadiux, nFoeRadiux;


		/*	for (ImMovable movFoe : CommandCenter.movFoes) {

				Point pntBrick = movFoe.getCenter();
				//	System.out.println("The paddles x coordinates are " + pntPaddle.x);

				Point pntBall = CommandCenter.getAstroid().getCenter();


				//This is perfect for the top
					if ((pntBrick.getX() - 50) < pntBall.x && (pntBrick.getX() + 50) > pntBall.x &&
							((pntBrick.getY()+5) > pntBall.y) && (pntBrick.getY()-5) < pntBall.y) {

						System.out.println("We HAVE A Collision");


					/*MAKE SURE THE BALL BOUNCES OFF THE BRICKS IT BREAKS!!!!!!
						theScore = theScore + 10;
						CommandCenter.setScore(theScore);
						CommandCenter.movFoes.remove(movFoe);

						Random rand = new Random();
						int pickedNumber = rand.nextInt(4) + 1;


						if (pickedNumber == 1) {
							//always to the left
							if (CommandCenter.getAstroid().getDeltaX() > 0) {
								CommandCenter.getAstroid().setDeltaX(-10);
							} else {
								CommandCenter.getAstroid().setDeltaX(10);
							}

							if (CommandCenter.getAstroid().getDeltaY() > 0) {
								CommandCenter.getAstroid().setDeltaY(-10);
							} else {
								CommandCenter.getAstroid().setDeltaY(10);
							}
						}
						else if (pickedNumber == 2) {

							//switching from left to right
							if (CommandCenter.getAstroid().getDeltaX() > 0) {
								CommandCenter.getAstroid().setDeltaX(-5);
							} else {
								CommandCenter.getAstroid().setDeltaX(5);
							}

							if (CommandCenter.getAstroid().getDeltaY() > 0) {
								CommandCenter.getAstroid().setDeltaY(-5);
							} else {
								CommandCenter.getAstroid().setDeltaY(5);
							}
						}

						else if (pickedNumber == 3) {

							//always to the right
							if (CommandCenter.getAstroid().getDeltaX() > 0) {
								CommandCenter.getAstroid().setDeltaX(10);
							} else {
								CommandCenter.getAstroid().setDeltaX(10);
							}

							if (CommandCenter.getAstroid().getDeltaY() > 0) {
								CommandCenter.getAstroid().setDeltaY(-10);
							} else {
								CommandCenter.getAstroid().setDeltaY(10);
							}
						}

						else if (pickedNumber == 4) {

							//always to the right
							if (CommandCenter.getAstroid().getDeltaX() > 0) {
								CommandCenter.getAstroid().setDeltaX(5);
							} else {
								CommandCenter.getAstroid().setDeltaX(5);
							}

							if (CommandCenter.getAstroid().getDeltaY() > 0) {
								CommandCenter.getAstroid().setDeltaY(-10);
							} else {
								CommandCenter.getAstroid().setDeltaY(10);
							}
						}



				}*/






		//CommandCenter.movFriends.add(new Bullet(fal));

		for( Movable movFriend: CommandCenter.movFriends){

			for (ImMovable movFoe : CommandCenter.movFoes) {

				int[] pntBrickX = movFoe.getXcoords();
				int[] pntBrickY = movFoe.getYcoords();

				Point laser = movFriend.getCenter();

				if ( pntBrickX[3]-5 <  laser.x &&  laser.x < pntBrickX[0]+5 &&
						pntBrickY[0]-5 < laser.y && laser.y<pntBrickY[1]+5) {


					System.out.println("We have a collision");

					theScore = theScore + 10;
					CommandCenter.setScore(theScore);
					CommandCenter.movFoes.remove(movFoe);
					movFriend.expire();
					CommandCenter.movFriends.remove(movFriend);


				}
			}

		}









		for (ImMovable movFoe : CommandCenter.movFoes) {

			int[] pntBrickX = movFoe.getXcoords();
			int[] pntBrickY = movFoe.getYcoords();
			//	System.out.println("The paddles x coordinates are " + pntPaddle.x);

			//System.out.println("The x coordiantes of a brick are " + pntBrickX[0] + ", " + pntBrickX[1]);

		/*	System.out.println("The brick has the following coordinates: ");
			System.out.println("( " + pntBrickX[0] + ", " + pntBrickY[0] + " )");
			System.out.println("( " + pntBrickX[1] + ", " + pntBrickY[1] + " )");
			System.out.println("( " + pntBrickX[2] + ", " + pntBrickY[2] + " )");
			System.out.println("( " + pntBrickX[3] + ", " + pntBrickY[3] + " )");
			System.out.println();*/

			//System.out.println("The y coordiantes of a brick are " + pntBrickY[0] + ", " + pntBrickY[1]);


			Point pntBall = CommandCenter.getAstroid().getCenter();

			//System.out.println("The coordinates of a ball are ( " + pntBall.x+ ", " + pntBall.y + ")");


			//This is perfect for the top
			if ( pntBrickX[3]-5 < pntBall.x &&  pntBall.x < pntBrickX[0]+5 &&
					pntBrickY[0]-5 <pntBall.y && pntBall.y<pntBrickY[1]+5) {

				//System.out.println("We HAVE A Collision");


				//	MAKE SURE THE BALL BOUNCES OFF THE BRICKS IT BREAKS!!!!!!
				theScore = theScore + 10;
				CommandCenter.setScore(theScore);
				CommandCenter.movFoes.remove(movFoe);

				Random rand = new Random();
				int pickedNumber = rand.nextInt(4) + 1;


				if (pickedNumber == 1) {
					//always to the left
					if (CommandCenter.getAstroid().getDeltaX() > 0) {
						CommandCenter.getAstroid().setDeltaX(-10);
					} else {
						CommandCenter.getAstroid().setDeltaX(10);
					}

					if (CommandCenter.getAstroid().getDeltaY() > 0) {
						CommandCenter.getAstroid().setDeltaY(-10);
					} else {
						CommandCenter.getAstroid().setDeltaY(10);
					}
				}
				else if (pickedNumber == 2) {

					//switching from left to right
					if (CommandCenter.getAstroid().getDeltaX() > 0) {
						CommandCenter.getAstroid().setDeltaX(-5);
					} else {
						CommandCenter.getAstroid().setDeltaX(5);
					}

					if (CommandCenter.getAstroid().getDeltaY() > 0) {
						CommandCenter.getAstroid().setDeltaY(-5);
					} else {
						CommandCenter.getAstroid().setDeltaY(5);
					}
				}

				else if (pickedNumber == 3) {

					//always to the right
					if (CommandCenter.getAstroid().getDeltaX() > 0) {
						CommandCenter.getAstroid().setDeltaX(10);
					} else {
						CommandCenter.getAstroid().setDeltaX(10);
					}

					if (CommandCenter.getAstroid().getDeltaY() > 0) {
						CommandCenter.getAstroid().setDeltaY(-10);
					} else {
						CommandCenter.getAstroid().setDeltaY(10);
					}
				}

				else if (pickedNumber == 4) {

					//always to the right
					if (CommandCenter.getAstroid().getDeltaX() > 0) {
						CommandCenter.getAstroid().setDeltaX(5);
					} else {
						CommandCenter.getAstroid().setDeltaX(5);
					}

					if (CommandCenter.getAstroid().getDeltaY() > 0) {
						CommandCenter.getAstroid().setDeltaY(-10);
					} else {
						CommandCenter.getAstroid().setDeltaY(10);
					}
				}

			}

		}

		//check for collisions between falcon and floaters
		if (CommandCenter.getFalcon() != null) {

			//getting the center of the falcon
			//Point pntPaddleCenter = CommandCenter.getFalcon().getCenter();
			//getting the falcons radious
			//int nPaddleRadiux = CommandCenter.getFalcon
			//
			// ().getRadius();

			int[] pntPaddleX = CommandCenter.getFalcon().getXcoords();
			int[] pntPaddleY = CommandCenter.getFalcon().getYcoords();
			//Point pntPaddle = CommandCenter.getFalcon().getCenter();
		//	System.out.println("The paddles x coordinates are " + pntPaddle.x);

			Point pntBall = CommandCenter.getAstroid().getCenter();
		//	System.out.println("The balls' x coordinates are " + pntBall.x);
//			System.out.println("The balls' y coordinates are " + pntBall.y);

//			System.out.println("The radius of paddle is " + nPaddleRadiux);
		//	System.out.println("The center of paddle is " + pntPaddleCenter);

			///////////////////////////////////////////////////////////
			//Point pntBallCenter;
			//int nBallRadiux;

			//pntBallCenter = CommandCenter.getAstroid().getCenter();
			//	nFriendRadiux = CommandCenter.getFalcon().getRadius();
			//nBallRadiux = CommandCenter.getAstroid().getRadius();


			//detect collision
			//if (pntPaddleCenter.distance(pntBallCenter) < (nPaddleRadiux + nBallRadiux-30)) {


		//	( pntBrickX[3]-5 < pntBall.x &&  pntBall.x < pntBrickX[0]+5 &&
		//			pntBrickY[0]-5 <pntBall.y && pntBall.y<pntBrickY[1]+5)


			if (  pntPaddleX[3]-5 < pntBall.x &&  pntBall.x < pntPaddleX[0]+5 &&
			     pntPaddleY[3] < pntBall.y+10) {
				//This needs refinenement....

				//System.out.println("We have a collision");
				//System.out.println();
				Random rand = new Random();

				//int pickedNumber;
				int pickedNumber = rand.nextInt(4) + 1;


			 if (pickedNumber == 1) {
						//always to the left
						if (CommandCenter.getAstroid().getDeltaX() > 0) {
							CommandCenter.getAstroid().setDeltaX(-10);
						} else {
							CommandCenter.getAstroid().setDeltaX(10);
						}

						if (CommandCenter.getAstroid().getDeltaY() > 0) {
							CommandCenter.getAstroid().setDeltaY(-10);
						} else {
							CommandCenter.getAstroid().setDeltaY(10);
						}
					}
					else if (pickedNumber == 2) {

						//switching from left to right
						if (CommandCenter.getAstroid().getDeltaX() > 0) {
							CommandCenter.getAstroid().setDeltaX(-5);
						} else {
							CommandCenter.getAstroid().setDeltaX(5);
						}

						if (CommandCenter.getAstroid().getDeltaY() > 0) {
							CommandCenter.getAstroid().setDeltaY(-5);
						} else {
							CommandCenter.getAstroid().setDeltaY(5);
						}
					}

					else if (pickedNumber == 3) {

							//always to the right
							if (CommandCenter.getAstroid().getDeltaX() > 0) {
								CommandCenter.getAstroid().setDeltaX(10);
							} else {
								CommandCenter.getAstroid().setDeltaX(10);
							}

							if (CommandCenter.getAstroid().getDeltaY() > 0) {
								CommandCenter.getAstroid().setDeltaY(-10);
							} else {
								CommandCenter.getAstroid().setDeltaY(10);
							}
						}

				else if (pickedNumber == 4) {

					//always to the right
					if (CommandCenter.getAstroid().getDeltaX() > 0) {
						CommandCenter.getAstroid().setDeltaX(5);
					} else {
						CommandCenter.getAstroid().setDeltaX(5);
					}

					if (CommandCenter.getAstroid().getDeltaY() > 0) {
						CommandCenter.getAstroid().setDeltaY(-10);
					} else {
						CommandCenter.getAstroid().setDeltaY(10);
					}
			 }




					}

				}//end if



		}//end inner for
		//}//end if not null

		//remove these objects from their appropriate ArrayLists
		//this happens after the above iterations are done
		/*for (Tuple tup : tupMarkForRemovals)
			tup.removeMovable();

		//add these objects to their appropriate ArrayLists
		//this happens after the above iterations are done
		for (Tuple tup : tupMarkForAdds)
			tup.addMovable();

		//call garbage collection
		System.gc();
			*/
	//}//end meth*/







	//some methods for timing events in the game,
	//such as the appearance of UFOs, floaters (power-ups), etc.
	public void tick() {
		if (nTick == Integer.MAX_VALUE)
			nTick = 0;
		else
			nTick++;
	}

	public int getTick() {
		return nTick;
	}

	/*private void spawnNewShipFloater() {
		//make the appearance of power-up dependent upon ticks and levels
		//the higher the level the more frequent the appearance
		if (nTick % (SPAWN_NEW_SHIP_FLOATER - nLevel * 7) == 0) {
			//CommandCenter.movFloaters.add(new NewShipFloater());
		}
	}*/

	// Called when user presses 's'
	private void startGame() {
		CommandCenter.clearAll();
		CommandCenter.initGame();
		CommandCenter.setLevel(1);
		CommandCenter.setPlaying(true);
	//	CommandCenter.setPaused(false);
		//if (!bMuted)
		// clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
	}

	//this method spawns new asteroids
	private void spawnAsteroids(int nNum) {

		Asteroid ball = new Asteroid(5);
	//	CommandCenter.movFoes.add(ball);
		CommandCenter.setAstroid(ball);
		/*for (int nC = 0; nC < nNum; nC++) {
			//Asteroids with size of zero are big
			CommandCenter.movFoes.add(new Asteroid(0));
		}*/
	}


	private void spawnImMovables(int nLevel){
		//this needs to be put into an array of immovables

		if(nLevel == 1) {

		//	brickArray.add(new ImMovable(200, 200));
		//	CommandCenter.movFoes.add(new ImMovable(400, 40));

			int x = 0;
			for (int i = 0; i < 2; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(400 + x, 40));
				x = x + 100;
			}

			x = 0;
			for (int i = 0; i < 3; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(350 + x, 60));
				x = x + 100;
			}

			x = 0;
			for (int i = 0; i < 4; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(300+x, 80));
				x = x + 100;
			}

			x = 0;
			for (int i = 0; i < 5; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(250+x, 100));
				x = x + 100;
			}

			  x = 0;
			for (int i = 0; i < 6; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(200+x, 120));
				x = x + 100;
			}

			x = 0;
			for (int i = 0; i < 6; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(200+x, 140));
				x = x + 100;
			}

			x = 0;
			for (int i = 0; i < 5; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(250+x, 160));
				x = x + 100;
			}

			x = 0;
			for (int i = 0; i < 4; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(300+x, 180));
				x = x + 100;
			}


			x = 0;
			for (int i = 0; i < 3; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(350 + x, 200));
				x = x + 100;
			}


			 x = 0;
			for (int i = 0; i < 2; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(400 + x, 220));
				x = x + 100;
			}


		}



		if(nLevel == 2) {
			int x = 0;
			for (int i = 0; i < 2; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(0 + x, 0));
				x = x + 100;
			}


		}


		if(nLevel == 3){
			int x = 0;
			for (int i = 0; i < 10; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(0 + x, 200));
				x = x + 100;
			}
		}


		if(nLevel == 4){
			int x = 0;
			for (int i = 0; i < 10; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(0 + x, 200));
				x = x + 100;
			}
		}

		if(nLevel == 5){
			int x = 0;
			for (int i = 0; i < 10; i++) {
				//brickArray.add(new ImMovable(200, 200+x));
				CommandCenter.movFoes.add(new ImMovable(0 + x, 200));
				x = x + 100;
			}
		}

       // CommandCente
	}


	private boolean isLevelClear(){
		//if there are no more Asteroids on the screen

		boolean bAsteroidFree = true;
		for (ImMovable movFoe : CommandCenter.movFoes) {
			if (movFoe instanceof ImMovable){
				bAsteroidFree = false;
				break;
			}
		}

		return bAsteroidFree;
	}



	private void checkGameOver(){


		if (CommandCenter.getFalcon() != null) {
			Point pntPaddleCenter = CommandCenter.getFalcon().getCenter();
			//getting the falcons radious
			int nPaddleRadiux = CommandCenter.getFalcon().getRadius();

//			System.out.println("The radius of paddle is " + nPaddleRadiux);
			//	System.out.println("The center of paddle is " + pntPaddleCenter);

			///////////////////////////////////////////////////////////
			Point pntBallCenter;
			int nBallRadiux;

			pntBallCenter = CommandCenter.getAstroid().getCenter();
			nBallRadiux = CommandCenter.getAstroid().getRadius();


//			System.out.println("The ball's y coordinates are " + CommandCenter.getAstroid().getCenter().getY());

			//detect collision
			/*if (pntPaddleCenter.distance(pntBallCenter) > (nPaddleRadiux + nBallRadiux - 30) &&
					CommandCenter.getAstroid().getCenter().getY() > 645) {

				 int numLives = CommandCenter.getNumFalcons();
				 numLives = numLives-1;
				 CommandCenter.setNumFalcons(numLives);
				 if (numLives > 0){
					 JOptionPane.showMessageDialog(null, "The number of lives left is " +
							 CommandCenter.getNumFalcons());
					 Asteroid ball = new Asteroid(5);
					 //CommandCenter.movFoes.add(ball);
					 CommandCenter.setAstroid(ball);
				 }*/
				  //JOptionPane.showMessageDialog(null, "The number of lives left is " + CommandCenter.getNumFalcons());
				//This needs refinenement....

				//if (numLives == 0) {
					//JOptionPane.showMessageDialog(null, "GAME OVER");

					//}


		}

	}


	private void checkNewLevel(){

		if (isLevelClear() ){
			if (CommandCenter.getFalcon() !=null)
//				CommandCenter.getFalcon().setProtected(true);
//
			//spawnImMovables();
			spawnImMovables(1);
			spawnAsteroids(1);
//			CommandCenter.setLevel(CommandCenter.getLevel() + 1);

		}
	}




	// Varargs for stopping looping-music-clips
	/*private static void stopLoopingSounds(Clip... clpClips) {
		for (Clip clp : clpClips) {
			clp.stop();
		}
	}*/

	// ===============================================
	// KEYLISTENER METHODS
	// ===============================================

	@Override
	public void keyPressed(KeyEvent e) {
		Falcon fal = CommandCenter.getFalcon();
		int nKey = e.getKeyCode();
		// System.out.println(nKey);


  	//	Point pntFriendCenter = fal.getCenter();
	//	System.out.println("The center of falcon is  " + fal.getCenter());


		if (nKey == START && !CommandCenter.isPlaying())
			startGame();

	//	Point pntFriendCenter = fal.getCenter();
	//		System.out.println("The center of falcon is  " + fal.getCenter());



		if (fal != null) {

			switch (nKey) {
		/*		case PAUSE:
					CommandCenter.setPaused(!CommandCenter.isPaused());
					if (CommandCenter.isPaused())
						stopLoopingSounds(clpMusicBackground, clpThrust);
					else
						clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
					break;*/
				case QUIT:
					System.exit(0);
					break;
			//	case UP:
				//	fal.thrustOn();   // <---- this is what makes the falcon fly
					//if (!CommandCenter.isPaused())
						//clpThrust.loop(Clip.LOOP_CONTINUOUSLY);
				//	break;
				case LEFT:
				//	fal.thrustOn();
					//fal.rotateLeft();
					fal.moveLeft();

					break;
				case RIGHT:
				//	fal.thrustOn();
					fal.moveRight();

					//	fal.rotateRight();
					break;

				// possible future use
				// case KILL:
				// case SHIELD:
				// case NUM_ENTER:

				default:
					break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	   Falcon fal = CommandCenter.getFalcon();
		int nKey = e.getKeyCode();
		System.out.println(nKey);

		if (fal != null) {
			switch (nKey) {
				case FIRE:
					CommandCenter.movFriends.add(new Bullet(fal));
					//Sound.playSound("laser.wav");
					break;

				//special is a special weapon, current it just fires the cruise missile.
				/*case SPECIAL:
					CommandCenter.movFriends.add(new Cruise(fal));
					//Sound.playSound("laser.wav");
					break;*/

				case LEFT:
					//fal.thrustOn();
					fal.stopLeft();
					//fal.stopRotating();
					break;
				case RIGHT:
					//fal.thrustOn();
					fal.stopRight();
//					fal.thrustOff();

				//	fal.stopRotating();
					break;
			//	case UP:

				//	fal.thrustOff();
			//		clpThrust.stop();
			//		break;

				case MUTE:
					if (!bMuted){
					//	stopLoopingSounds(clpMusicBackground);
						bMuted = !bMuted;
					}
					else {
						clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
						bMuted = !bMuted;
					}
					break;


				default:
					break;
			}
		}
	}

	@Override
	// Just need it b/c of KeyListener implementation
	public void keyTyped(KeyEvent e) {

		}
	}





// ===============================================
// ==A tuple takes a reference to an ArrayList and a reference to a Movable
//This class is used in the collision detection method, to avoid mutating the array list while we are iterating
// it has two public methods that either remove or add the movable from the appropriate ArrayList
// ===============================================

/*class Tuple{
	//this can be any one of several CopyOnWriteArrayList<Movable>
	private CopyOnWriteArrayList<ImMovable> movMovs;
	//this is the target movable object to remove
	private ImMovable movTarget;

	/*public Tuple(CopyOnWriteArrayList<ImMovable> movMovs, ImMovable movTarget) {
		this.movMovs = movMovs;
		this.movTarget = movTarget;
	}*/

	//public void removeImMovable(){
	//	movMovs.remove(movTarget);
	//}

	//public void addImMovable(){ movMovs.add(movTarget);	}

//}
