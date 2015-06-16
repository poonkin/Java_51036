package P8_15;

import java.lang.Math;

/**
 * Created by dsvid88 on 4/16/15.
 */
public class Cylinder {

    private double radius;
    private double height;
    private double area;
    private double volume;

    public Cylinder(double r, double h) {
        this.radius = r;
        this.height = h;
    }

    //finding the volume of a cylinder
    public double cylinderVolume() {
        this.volume = Math.PI * this.radius * this.radius * this.height;
        return this.volume;
    }

    //cylinder surface area
    public double cylinderSurface() {
        this.area = 2 * Math.PI * this.radius * this.height + 2 * Math.PI * this.radius * this.radius;
        return this.area;
    }

}