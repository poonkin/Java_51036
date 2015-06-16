package edu.uchicago.cs.java.finalproject.game.model;

import java.awt.*;
import java.util.ArrayList;


public class Bullet extends Sprite {

	  private final double FIRE_POWER = 35.0;

	 
	
public Bullet(Falcon fal){
		
		super();
		
		
		//defined the points on a cartesean grid
		ArrayList<Point> pntCs = new ArrayList<Point>();
		
		pntCs.add(new Point(0,3)); //top point
		
		pntCs.add(new Point(1,-1));
		pntCs.add(new Point(0,-2));
		pntCs.add(new Point(-1,-1));

		assignPolarPoints(pntCs);

		//a bullet expires after 20 frames
	    setExpire( 20 );
	    setRadius(6);
	    

	    //everything is relative to the falcon ship that fired the bullet
	    //setDeltaX( fal.getDeltaX() +
	    //           Math.cos( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );
	    //setDeltaY( fal.getDeltaY() +
	    //           Math.sin( Math.toRadians( fal.getOrientation() ) ) * FIRE_POWER );

	    int[] pntPaddleX = CommandCenter.getFalcon().getXcoords();

	   // setDeltaX( ();
		setDeltaY(-10);

		setCenter(new Point((int)fal.getCenter().getX()+50, (int)fal.getCenter().getY() - 10) );

	    //set the bullet orientation to the falcon (ship) orientation
	    setOrientation(fal.getOrientation() + 270);


	}




	public void move(){

		Point pnt = getCenter();

		double dX = pnt.x + getDeltaX();
		double dY = pnt.y + getDeltaY();


		//System.out.println("The value of dY is "  + dY);
		//System.out.println("the value of pnt.y is " + pnt.y);


		//taking care of y coordinates
		if (pnt.y < 5) {
			//setCenter(new Point(pnt.x, ));
			this.expire();

		}

		else {
			//	System.out.println("Everything is working fine ");
			setCenter(new Point((int) dX, (int) dY));
		}


	}



    //override the expire method - once an object expires, then remove it from the arrayList. 
	public void expire(){
 		if (getExpire() == 0)
			CommandCenter.movFriends.remove(this);
		 else 
			setExpire(getExpire() - 1);
	}

}
