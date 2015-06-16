package P9_14;

/**
 * Created by dsvid88 on 4/22/15.
 */
public class SodaCan  implements Measurable {

    //initializing private variables
    private double r;
    private double h;

    //defining a constructor
    public SodaCan(double radius, double height) {
        r = radius;
        h = height;
    }

    //finding the surfaceArea
    public double getSurfaceArea() {
        double surfaceArea = 2 * Math.PI * r * h + 2 * Math.PI * r * r * h;
        return surfaceArea;

    }



}
