package P8_14;

import java.util.Scanner;

/**
 * Created by dsvid88 on 4/16/15.
 */
public class Driver {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a radius and a height :");

        Double r = input.nextDouble();
        Double h = input.nextDouble();

        System.out.println("Enter three strings:");

        System.out.println("Volume of a sphere with radius " + r + " is " + Geometry.sphereVolume(r));

        System.out.println("Surface area of a sphere with radius " + r + " is  " + Geometry.sphereSurface(r));

        System.out.println("Volume of a cylinder with radius " + r + " and " + h + " is "
                + Geometry.cylinderVolume(r, h));

        System.out.println("Surface area of a cylinder with radius " + r + "  and " + h + " is "
                + Geometry.cylinderSurface(r, h));

        System.out.println("Volume of a cone with radius " + r + "  and  height " + h + " is "
                + Geometry.coneVolume(r, h));

        System.out.println("Surface area of a cone with radius " + r + " and height " + h + " is " +
                Geometry.coneSurface(r, h));

    }

}
