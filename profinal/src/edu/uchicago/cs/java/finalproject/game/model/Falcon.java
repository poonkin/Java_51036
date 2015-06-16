package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;


public class Falcon extends Sprite {

	// ==============================================================
	// FIELDS 
	// ==============================================================
	
	//private final double THRUST = .1;
/*
	final int DEGREE_STEP = 7;
	
	private boolean bShield = false;
	private boolean bFlame = false;
	private boolean bProtected; //for fade in and out
	
	private boolean bThrusting = false;
	private boolean bTurningRight = false;
	private boolean bTurningLeft = false;



	private boolean paddleMoveLeft = false;
	private boolean paddleMoveRight = false;

	private int nShield;
			
	private final double[] FLAME = { 23 * Math.PI / 24 + Math.PI / 2,
			Math.PI + Math.PI / 2, 25 * Math.PI / 24 + Math.PI / 2 };

	private int[] nXFlames = new int[FLAME.length];
	private int[] nYFlames = new int[FLAME.length];

	private Point[] pntFlames = new Point[FLAME.length];*/


	private boolean paddleMoveLeft = false;
	private boolean paddleMoveRight = false;
	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public Falcon() {
		super();
		//Graphics g = g.fillRect(0, 10, 200, 10);

		//g.fillRect(0, 10, 200, 10);
		//g.fillRect(0, 10, 200, 10);
		//g.fillRect(0, 10, 200, 10);

		ArrayList<Point> pntCs = new ArrayList<Point>();
		
		// top of ship
		//pntCs.add(new Point(0, 18));
		
		//right points
		pntCs.add(new Point(1, 5));
		pntCs.add(new Point(0, 5));
		pntCs.add(new Point(0, 0));
		pntCs.add(new Point(1, 0));


	/*	pntCs.add(new Point(0, 0));
		pntCs.add(new Point(0, 10));
		pntCs.add(new Point(10, 200));
		pntCs.add(new Point(200, 0));*/

		//pntCs.add(new Point(0, 0));
		//pntCs.add(new Point(20, 0));

		/*pntCs.add(new Point(-100, 100));
		pntCs.add(new Point(0, 3));
		pntCs.add(new Point(0, 0));
		pntCs.add(new Point(-3, 0));*.


	//	ArrayList<Rectangle> pntCs = new ArrayList<Rectangle>();
		//Rectangle p = new Rectangle(0, 10, 200, 10);

  		//pntcs.add(new  Rectangle(0, 10, 200, 10);

		//pntCs.add(new Point(13, -2));
		//pntCs.add(new Point(13, -4));
		//pntCs.add(new Point(11, -2));
		//pntCs.add(new Point(4, -3));
		//pntCs.add(new Point(2, -10));
		//pntCs.add(new Point(4, -12));
		//pntCs.add(new Point(2, -13));

		//left points
	    /*pntCs.add(new Point(-2, -13));
		pntCs.add(new Point(-4, -12));
		pntCs.add(new Point(-2, -10)); 
		pntCs.add(new Point(-4, -3)); 
		pntCs.add(new Point(-11, -2));
		pntCs.add(new Point(-13, -4));
		pntCs.add(new Point(-13, -2)); 
		pntCs.add(new Point(-12, 0)); 
		pntCs.add(new Point(-3, 3)); */
		


		assignPolarPoints(pntCs);


		//assignPolarPoints(g.fillRect(0, 10, 200, 10));


		setColor(Color.white);
		
		//put falcon in the middle.
		setCenter(new Point(500, 675));
		
		//with random orientation
		//setOrientation(Game.R.nextInt(360));
		
		//this is the size of the paddle
		setRadius(100);

		//these are falcon specific
		//setProtected(true);
	//	setFadeValue(0);
		}
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================

	public void move() {
//		super.move();
		Point pnt = getCenter();
		//double dX = pnt.x + getDeltaX();
		//double dY = pnt.y + getDeltaY();
		double dX = pnt.x + getDeltaX();

		//this just keeps the sprite inside the bounds of the frame
		if (pnt.x > getDim().width) {
			setCenter(new Point(1000, pnt.y));

		} else if (pnt.x < 0) {

			setCenter(new Point(0, pnt.y));

		}


		else {

			setCenter(new Point((int) dX, pnt.y));
		}




		if (paddleMoveLeft) {
			//bFlame = true;
		//	double  dAdjustX = Math.cos(Math.toRadians(getOrientation()));
			setDeltaX(getDeltaX() - 10);

			//System.out.println("We are moving left " + dAdjustX);

		}

		if (paddleMoveRight) {
		//	bFlame = true;
		//	double  dAdjustX = Math.cos(Math.toRadians(getOrientation()));
			setDeltaX(getDeltaX() + 10);
		 //System.out.println("We are moving right " + dAdjustX);

		}

		if(!paddleMoveLeft && !paddleMoveRight){
			setDeltaX(0);
		}





		/*if (bTurningLeft) {

			if (getOrientation() <= 0 && bTurningLeft) {
				setOrientation(360);
			}
			setOrientation(getOrientation() - DEGREE_STEP);
		} 
		if (bTurningRight) {
			if (getOrientation() >= 360 && bTurningRight) {
				setOrientation(0);
			}
			setOrientation(getOrientation() + DEGREE_STEP);
		}*/
	} //end move

/*	public void rotateLeft() {
		bTurningLeft = true;
	}

	public void rotateRight() {
		bTurningRight = true;
	}

	public void stopRotating() {
		bTurningRight = false;
		bTurningLeft = false;
	}*/

/*	public void thrustOn() {
		bThrusting = true;
	}*/


	public void moveLeft(){
		paddleMoveLeft = true;
	}


	public void moveRight(){
		paddleMoveRight = true;
	}


	public void stopLeft(){
		paddleMoveLeft = false;
	}

	public void stopRight(){
		paddleMoveRight = false;
	}


	/*public void thrustOff() {
		bThrusting = false;
		bFlame = false;
	}*/

	/*private int adjustColor(int nCol, int nAdj) {
		if (nCol - nAdj <= 0) {
			return 0;
		} else {
			return nCol - nAdj;
		}
	}*/

	public void draw(Graphics g) {

		//does the fading at the beginning or after hyperspace
		Color colShip;



		if (getFadeValue() == 255) {
			colShip = Color.white;
		} else {
			/*colShip = new Color(adjustColor(getFadeValue(), 200), adjustColor(
					getFadeValue(), 175), getFadeValue());*/
			colShip = new Color(255, 255, 255);
		}

//		//shield on
//		if (bShield && nShield > 0) {
//
//			setShield(getShield() - 1);
//
//			g.setColor(Color.cyan);
//			g.drawOval(getCenter().x - getRadius(),
//					getCenter().y - getRadius(), getRadius() * 2,
//					getRadius() * 2);
//
//		} //end if shield



		//thrusting
		/*if (bFlame) {
			g.setColor(colShip);
			//the flame
			/*for (int nC = 0; nC < FLAME.length; nC++) {
				if (nC % 2 != 0) //odd
				{
					pntFlames[nC] = new Point((int) (getCenter().x + 2
							* getRadius()
							* Math.sin(Math.toRadians(getOrientation())
									+ FLAME[nC])), (int) (getCenter().y - 2
							* getRadius()
							* Math.cos(Math.toRadians(getOrientation())
									+ FLAME[nC])));

				}
				/*else //even
				{
					pntFlames[nC] = new Point((int) (getCenter().x + getRadius()
							* 1.1
							* Math.sin(Math.toRadians(getOrientation())
									+ FLAME[nC])),
							(int) (getCenter().y - getRadius()
									* 1.1
									* Math.cos(Math.toRadians(getOrientation())
											+ FLAME[nC])));

				} //end even/odd else*/


		drawShipWithColor(g, colShip);
			} //end for loop*/

	/*	for (int nC = 0; nC < FLAME.length; nC++) {
				nXFlames[nC] = pntFlames[nC].x;
				nYFlames[nC] = pntFlames[nC].y;

			} //end assign flame points

		//	g.setColor( Color.white );
//			g.fillPolygon(nXFlames, nYFlames, FLAME.length);
*/
		//drawShipWithColor(g, colShip);
		//}

		 //end if flame*/

//		drawShipWithColor(g, colShip);

//	} //end draw()

	public void drawShipWithColor(Graphics g, Color col) {
		super.draw(g);
		g.setColor(col);
		g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
	}

/*	public void fadeInOut() {
		if (getProtected()) {
			setFadeValue(getFadeValue() + 3);
		}
		if (getFadeValue() == 255) {
			setProtected(false);
		}
	}*/
	
	/*public void setProtected(boolean bParam) {
		if (bParam) {
			setFadeValue(0);
		}
		//bProtected = bParam;
	}*/

/*	public void setProtected(boolean bParam, int n) {
		if (bParam && n % 3 == 0) {
			setFadeValue(n);
		} else if (bParam) {
			setFadeValue(0);
		}
		bProtected = bParam;
	}*/

//	public boolean getProtected() {return bProtected;}
//	public void setShield(int n) {nShield = n;}
//	public int getShield() {return nShield;}
	
} //end class
