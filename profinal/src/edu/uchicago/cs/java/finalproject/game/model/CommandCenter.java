package edu.uchicago.cs.java.finalproject.game.model;
import java.util.concurrent.CopyOnWriteArrayList;

/// / I only want one Command Center and therefore this is a perfect candidate for static
// Able to get access to methods and my movMovables ArrayList from the static context.
public class CommandCenter {

	private static int nNumFalcon;
	private static int nLevel;
	private static long lScore;


	private static Falcon falShip;
	private static Asteroid ball;
	private static ImMovable firstImmovalbe;

	private static boolean bPlaying;
	private static boolean bPaused;

	// These ArrayLists are thread-safe
//	public static CopyOnWriteArrayList<Movable> movDebris = new CopyOnWriteArrayList<Movable>();

	public static CopyOnWriteArrayList<Movable> movFriends = new CopyOnWriteArrayList<Movable>();
	public static CopyOnWriteArrayList<ImMovable> movFoes = new CopyOnWriteArrayList<ImMovable>();



//	public static CopyOnWriteArrayList<Movable> movFloaters = new CopyOnWriteArrayList<Movable>();

//	public static Movable paddle;
//	public static Movable ball;

	// Constructor made private - static Utility class only
	private CommandCenter() {}

	public static void initGame(){
		setLevel(1);
	 	setScore(0);
		setNumFalcons(3);
		spawnFalcon(true);

	}

	// The parameter is true if this is for the beginning of the game, otherwise false
	// When you spawn a new falcon, you need to decrement its number
	public static void spawnFalcon(boolean bFirst) {


		//if (getNumFalcons() != 0) {
			falShip = new Falcon();

			CommandCenter.setFalcon(falShip);
		//movFriends.add(falShip);
			//if (!bFirst)
			//	setNumFalcons(getNumFalcons() - 1);
		//}

	//	Sound.playSound("shipspawn.wav");

	}


//	public static void spawnBall(){
///		ball = new Asteroid(5);
	//}

	public static void clearAll(){
		//movDebris.clear();
		//movFriends.clear();
		movFoes.clear();
		//movFloaters.clear();
	}

	public static boolean isPlaying() {
		return bPlaying;
	}

	public static void setPlaying(boolean bPlaying) {
		CommandCenter.bPlaying = bPlaying;
	}

	public static boolean isPaused() {
		return bPaused;
	}

	public static void setPaused(boolean bPaused) {
		CommandCenter.bPaused = bPaused;
	}



	public static boolean isGameOver() {		//if the number of falcons is zero, then game over
		return getNumFalcons() == 0;
	}

	public static int getLevel() {
		return nLevel;
	}

	public  static long getScore() {
		return lScore;
	}

	public static void setScore(long lParam) {
		lScore = lParam;
	}

	public static void setLevel(int n) {
		nLevel = n;
	}


	public static int getNumFalcons() {
		return nNumFalcon;
	}

	public static void setNumFalcons(int nParam) {
		nNumFalcon = nParam;
	}


	public static Asteroid getAstroid() { return ball; }
	public static void setAstroid(Asteroid a) { ball = a; }


	public static Falcon getFalcon(){
		return falShip;
	}
	public static void setFalcon(Falcon falParam){
		falShip = falParam;
	}


	//this is the for an immable object
	public static void setImMovable (ImMovable a ) { firstImmovalbe = a; }
	public static ImMovable getImMovable() { return firstImmovalbe; }


/*	public static CopyOnWriteArrayList<Movable> getMovDebris() {
		return movDebris;
	}

*/
	public static CopyOnWriteArrayList<Movable> getMovFriends() {
		return movFriends;
	}



   public static CopyOnWriteArrayList<ImMovable> getMovFoes() {
		return movFoes;
	}
/*

	public static CopyOnWriteArrayList<Movable> getMovFloaters() {
		return movFloaters;
	}*/




}
