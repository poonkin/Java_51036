package P8_6;

/**
 * Created by dsvid88 on 4/15/15.
 */

public class Car {

    //declaring attributes
    private double fuelEfficiency;
    private double gasLevel;

    //constructor
    public Car(double fuelEffinciency) {
        this.fuelEfficiency = fuelEffinciency;
        this.gasLevel = 0;
    }

    //adding a getter to make life easier
    public double getFuelEfficiency() {
        return this.fuelEfficiency;
    }

    //adding gas to the car
    public void addGas(double gallons) {
        this.gasLevel = this.gasLevel + gallons;
    }

    //getting the amount of gas in the car
    public double getGasLevel() {
        return this.gasLevel;
    }

    //drive method
    public void drive(double distance) {
        this.gasLevel = this.gasLevel - (distance / this.fuelEfficiency);
    }


}




