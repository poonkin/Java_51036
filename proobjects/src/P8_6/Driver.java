package P8_6;

/**
 * Created by dsvid88 on 4/15/15.
 */
public class Driver {

    public static void main(String[] args) {

        //creating two instances of Car class
        Car prius = new Car(50);
        Car hummer = new Car(13);

        System.out.println("The fuel efficiency of a prius is " + prius.getFuelEfficiency() + " miles/gallon the fuel " +
                "efficiency of a hummer is " + hummer.getFuelEfficiency() + " miles/gallon");
        System.out.println("\n");

        //putting 10 gallons of fuel in each car
        prius.addGas(10);
        hummer.addGas(10);
        System.out.println("The amount of gas is the prius is " + prius.getGasLevel() + " gallons the amount " +
                "of gas is the hummer is " + hummer.getGasLevel() + " gallons");
        System.out.println("\n");

        //both cars are driving 30 miles
        prius.drive(30);
        hummer.drive(30);

        System.out.println("After driving for 30 miles, prius has " + prius.getGasLevel() + " gallons left and the hummer " +
                " has " + hummer.getGasLevel() + " gallons left");


    }

}