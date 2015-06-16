
package edu.uchicago.cs.java.finalproject.game.model;


import edu.uchicago.cs.java.finalproject.controller.Game;

import java.awt.*;
import java.util.Arrays;

public class Asteroid extends Sprite {




	private int nSpin;

	//radius of a large asteroid
	private final int RAD = 100;

	//nSize determines if the Asteroid is Large (0), Medium (1), or Small (2)
	//when you explode a Large asteroid, you should spawn 2 or 3 medium asteroids
	//same for medium asteroid, you should spawn small asteroids
	//small asteroids get blasted into debris
	public Asteroid(int nSize){

		//call Sprite constructor
		super();


		//Figure out where to spawn the Asteroid!!!!
		setCenter(new Point(300, 500));

		//JOptionPane.showMessageDialog(null, "Get READY");
				//pin will be either plus or minus 0-9
		//int nSpin = Game.R.nextInt(10);
		///if(nSpin %2 ==0)
			//nSpin = -nSpin;
		//setSpin(nSpin);

		//random delta-x
		int nDX = 15;
		setDeltaX(nDX);

		//random delta-y
		int nDY = 15;
		//if(nDY %2 ==0)
		//	nDY = -nDY;
		setDeltaY(nDY);

	//	assignRandomShape();

		//System.out.println("The radious of the asteroid is " +RAD/(nSize * 2));

		setRadius(RAD/(nSize * 2));


	}




/*	public Asteroid(Asteroid astExploded){


		//call Sprite constructor
		super();

		int  nSizeNew =	astExploded.getSize() + 1;


		//the spin will be either plus or minus 0-9
		int nSpin = Game.R.nextInt(10);
		if(nSpin %2 ==0)
			nSpin = -nSpin;
		//setSpin(nSpin);

		//random delta-x
		int nDX = Game.R.nextInt(10 + nSizeNew*2);
		if(nDX %2 ==0)
			nDX = -nDX;
		setDeltaX(nDX);

		//random delta-y
		int nDY = Game.R.nextInt(10+ nSizeNew*2);
		if(nDY %2 ==0)
			nDY = -nDY;
		setDeltaY(nDY);

		assignRandomShape();

		//an nSize of zero is a big asteroid
		//a nSize of 1 or 2 is med or small asteroid respectively

		setRadius(RAD/(nSizeNew * 2));
		setCenter(astExploded.getCenter());




	}*/

	public int getSize(){

		int nReturn = 0;

		switch (getRadius()) {
			case 100:
				nReturn= 0;
				break;
			case 50:
				nReturn= 1;
				break;
			case 25:
				nReturn= 2;
				break;
		}
		return nReturn;

	}

	//overridden
	public void move(){
		Point pnt = getCenter();

			double dX = pnt.x + getDeltaX();
			double dY = pnt.y + getDeltaY();


		//System.out.println("The value of dY is "  + dY);
		//System.out.println("the value of pnt.y is " + pnt.y);




		if (pnt.x > 1095) {
			setCenter(new Point(1094, pnt.y));
			this.setDeltaX(-15.0);

		} else if (pnt.x < 5) {
			setCenter(new Point(6, pnt.y));
			this.setDeltaX(15);

		}

		//taking care of y coordinates
		if (pnt.y < 5) {
			setCenter(new Point(pnt.x, 6));
			this.setDeltaY(15.0);
		}
		else if (pnt.y >= 675) {
				//if the ball is going down, this fixes it
	//		System.out.println("We need to go up now!!");

			setCenter(new Point(pnt.x, 674));
			this.setDeltaY(-15.0);

		}

		else {
		//	System.out.println("Everything is working fine ");
			setCenter(new Point((int) dX, (int) dY));
		}


	}




	public void draw(Graphics g) {
		Point pnt = getCenter();
		/*nXCoords = new int[dDegrees.length];
		nYCoords = new int[dDegrees.length];
		//need this as well
		pntCoords = new Point[dDegrees.length];


		for (int nC = 0; nC < dDegrees.length; nC++) {
			nXCoords[nC] =    (int) (getCenter().x + getRadius()
					* dLengths[nC]
					* Math.sin(Math.toRadians(getOrientation()) + dDegrees[nC]));
			nYCoords[nC] =    (int) (getCenter().y - getRadius()
					* dLengths[nC]
					* Math.cos(Math.toRadians(getOrientation()) + dDegrees[nC]));


			//need this line of code to create the points which we will need for debris
			//    pntCoords[nC] = new Point(nXCoords[nC], nYCoords[nC]);
		}*/

		g.setColor(getColor());
		g.drawOval((int)pnt.getX(),(int) pnt.getY(), 10, 10);
	}


		//this is for an asteroid only
	public void assignRandomShape ()
	{
		int nSide = 1000;
		int nSidesTemp = nSide;

		int[] nSides = new int[nSide];
		for ( int nC = 0; nC < nSides.length; nC++ )
		{
			int n = nC * 48 / nSides.length - 4 + Game.R.nextInt( 8 );
			if ( n >= 48 || n < 0 )
			{
				n = 0;
				nSidesTemp--;
			}
			nSides[nC] = n;
		}

		Arrays.sort( nSides );

		double[]  dDegrees = new double[nSidesTemp];
		for ( int nC = 0; nC <dDegrees.length; nC++ )
		{
			dDegrees[nC] = nSides[nC] * Math.PI / 24 + Math.PI / 2;
		}
		setDegrees( dDegrees);

		double[] dLengths = new double[dDegrees.length];
		for (int nC = 0; nC < dDegrees.length; nC++) {
			if(nC %3 == 0)
				dLengths[nC] = 1 - Game.R.nextInt(40)/100.0;
			else
				dLengths[nC] = 1;
		}
		setLengths(dLengths);

	}

}