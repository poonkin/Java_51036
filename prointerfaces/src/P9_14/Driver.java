package P9_14;

/**
 * Created by dsvid88 on 4/22/15.
 */
public class Driver {

    public static void main(String[] args){

        Measurable [] sodaCans = new Measurable[3];
        sodaCans[0] = new SodaCan(3, 4);
        sodaCans[1] = new SodaCan(2.4, 4.60);
        sodaCans[2] = new SodaCan(.9, .7);

        System.out.println("The average surface area soda cans is " + average(sodaCans));

    }

    public static double average(Measurable[] objects)
    {
        if (objects.length == 0) {
            return 0;
        }

        double sum = 0;

        for (Measurable obj: objects)
        {
            sum = sum + obj.getSurfaceArea();
        }
        return sum/objects.length;
    }
}


