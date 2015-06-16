package P8_15;

/**
 * Created by dsvid88 on 4/16/15.
 */
public class Driver {

    public static void main(String[] args) {

        Sphere newSphere = new Sphere(2.5);
        Cylinder newCylinder = new Cylinder(1.0, 3.0);
        Cone newCone = new Cone(1.5, 3.5);

        System.out.println("The volume of newSphere is " + newSphere.sphereVolume());
        System.out.println("The surface area of newSphere is " + newSphere.sphereSurface());
        System.out.println("\n");

        System.out.println("The volume of newCylinder is " + newCylinder.cylinderVolume());
        System.out.println("The surface area of newCylinder is " + newCylinder.cylinderSurface());
        System.out.println("\n");

        System.out.println("The volume of newCone is " + newCone.coneVolume());
        System.out.println("The surface area of newCone is " + newCone.coneSurface());

    }
}

/* I think the approach taken in this exercise is more object oriented because in this
exercise we are creating three distinct classes of objects and implementing methods specific to these
object in their classes. In exercise 8.14 we lump everything together.

 */