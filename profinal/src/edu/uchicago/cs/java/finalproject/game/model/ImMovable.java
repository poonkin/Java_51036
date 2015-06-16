package edu.uchicago.cs.java.finalproject.game.model;
import java.util.ArrayList;
import java.awt.*;

/**
 * Created by dsvid88 on 5/24/15.
 */
public class ImMovable extends Sprite{

    public ImMovable(int x, int y) {
        super();

		Dimension DIM = new Dimension(100, 20);
		//double[] dLengths = { 50, 10};



        ArrayList<Point> pntCs = new ArrayList<Point>();

        //right points
        pntCs.add(new Point(1, 5));
        pntCs.add(new Point(0, 5));
        pntCs.add(new Point(0, 0));
        pntCs.add(new Point(1, 0));









       assignPolarPoints(pntCs);



	//	setObjectPoints(pntCs);

        //assignPolarPoints(g.fillRect(0, 10, 200, 10));


		setColor(Color.white);

        //put falcon in the middle.
        setCenter(new Point(x, y));

        //with random orientation
        //setOrientation(Game.R.nextInt(360));

        //this is the size of a brick
        setRadius(100);

		//setDim(DIM);
		//setLengths(dLengths);

		//setXcoord(100, 1);
		//setXcoord(150, 2);
		//setYcoord(50, 1);
		//setYcoord(0, 2);
        //these are falcon specific
        //setProtected(true);
        //	setFadeValue(0);
    }

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

	public void drawShipWithColor(Graphics g, Color col) {
		super.draw(g);
		g.setColor(col);

		//System.out.println("The x coordinates are " + getXcoords());

		g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);

	}


}
