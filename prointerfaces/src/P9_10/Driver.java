package P9_10;

/**
 * Created by dsvid88 on 4/22/15.
 */
public class Driver {

    public static void main(String[] args) {

        BetterRectangle r1 = new BetterRectangle(0, 0, 10, 5);

        System.out.println( "The width of rectangle r1 is " + r1.getWidth() + " and height is " +
                            r1.getHeight());

        System.out.println("The perimeter of r1 is " + r1.getPerimeter());

        System.out.println("The area of r1 is " + r1.getArea());

    }
}