package P8_5;

/**
 * Created by dsvid88 on 4/15/15.
 */
public class SodaCan {

    //initializing private variables
    private double r;
    private double h;

    //defining a constructor
    public SodaCan(double radius, double height) {
        r = radius;
        h = height;
    }

    //finding the volume
    public double getVolume() {
        double volume = 2 * Math.PI * r * r * h;
        return volume;
    }

    //finding the surfaceArea
    public double getSurfaceArea() {
        double surfaceArea = 2 * Math.PI * r * h + 2 * Math.PI * r * r * h;
        return surfaceArea;

    }

}