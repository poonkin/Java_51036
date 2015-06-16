package P8_4;

/**
 * Created by dsvid88 on 4/14/15.
 */
public class Address {

    //Declaring atributes
    private int houseNumber;
    private String street;
    private int aptNum;
    private String city;
    private String state;
    private int zipCode;


    //constructor with apt number
    public Address(int houseNumber, String street, int aptNum, String city, String state, int zipCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.aptNum = aptNum;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    //constructor withOut apt number
    public Address(int houseNumber, String street, String city, String state, int zipCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    //print method as specified
    public void print() {
        System.out.println(this.houseNumber + " " + this.street);
        System.out.println(this.city + " " + this.state + " " + this.zipCode);
    }

    //comeBefore method as specificed, im assuming if zip code is less, then it comebefore
    public boolean comesBefore(Address other) {

        if (this.zipCode < other.zipCode) {
            return true;
        } else {
            return false;
        }
    }
}
