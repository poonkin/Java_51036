package P8_15;

import java.lang.Math;

/**
 * Created by dsvid88 on 4/16/15.
 */

public class Cone {

    private double radius;
    private double height;
    private double area;
    private double volume;

    public Cone(double r, double h) {
        this.radius = r;
        this.height = h;
    }

    public double coneVolume() {
        this.volume = Math.PI * this.radius * this.radius * (this.height / 3);
        return this.volume;
    }

    //area of a cone surface
    public double coneSurface() {
        this.area = Math.PI * this.radius * (this.radius + Math.sqrt(this.height * this.height + this.radius * this.radius));
        return this.area;
    }
}

