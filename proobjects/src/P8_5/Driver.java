package P8_5;

/**
 * Created by dsvid88 on 4/15/15.
 */
public class Driver {

    public static void main(String[] args) {

        //creating an instance of SodaCan
        SodaCan s = new SodaCan(1.2, 1.4);

        //Finding its volume nad surfaceArea
        System.out.println("The volume of the sodaCan is " + s.getVolume());
        System.out.println("The surface area of the sodaCan is " + s.getSurfaceArea());

    }

}