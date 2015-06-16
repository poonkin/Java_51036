package P8_15;

/**
 * Created by dsvid88 on 4/16/15.
 */
public class Sphere {

    private double radius;
    private double area;
    private double volume;

    public Sphere(double r) {
        this.radius = r;
    }


    //volume of a sphere
    public double sphereVolume() {
        this.volume = (4 / 3) * Math.PI * this.radius * this.radius * this.radius;
        return this.volume;
    }

    //sphere surface area
    public double sphereSurface() {
        this.area = 4 * Math.PI * this.radius * this.radius;
        return this.area;
    }


}