package P8_4;

/**
 * -I will create two addresses using each constructor, I will print each address, and then apply compareTo method
 */

public class Driver {

    public static void main(String[] args) {


        //creating object
        Address nyAddress = new Address(110, "Shore Blvd, ", 1, "Brooklyn", "NY", 11235);
        Address chicagoAddress = new Address(6112, "S Kimbark Ave", "Chicago", "IL", 60637);

        //printing the addresses

        System.out.println("Printing the NY Address :");
        nyAddress.print();
        System.out.println("\n");
        System.out.println("Printing the Chicago Address :");
        chicagoAddress.print();

        //comparing the addressesc
        System.out.println("\n");
        System.out.print("Does NY zip code come before Chicago Zip Code? \n");
        System.out.println(nyAddress.comesBefore(chicagoAddress));

    }
}

