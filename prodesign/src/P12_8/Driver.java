package P12_8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dsvid88 on 5/7/15.
 */
public class Driver {

    public static void main(String[] args) {

        //Setting up the vending machine
        VendingMachine V1 = new VendingMachine();

        V1.addSnacks("Skittles", 1.00, 10);
        V1.addSnacks("M&M", 1.00, 10);
        V1.addSnacks("Twizzlers", 1.25, 10);
        V1.addSnacks("Lays", 1.25, 10);
        V1.addSnacks("Cheetos", 1.25, 10);
        V1.addSnacks("Doritos", 1.25, 10);
        V1.addSnacks("Oreos", .75, 10);

        V1.addCoins("Pennies", .01, 20);
        V1.addCoins("Nickles", .05, 20);
        V1.addCoins("Dimes", .10, 20);
        V1.addCoins("Quarters", .25, 20);

        System.out.println("The vending machine has the following snacks: ");
        V1.getSnackCount();

        System.out.println();
        System.out.println("And the following coins: ");
        V1.getCoinCount();

        //Prompting user to buy a snack
        System.out.println();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Which snack would you like to buy ?");
        String s = input1.next();

        ArrayList<Integer> coinInsert = new ArrayList<>();

        coinInsert = buySnack();

        V1.buySnack(s, coinInsert.get(0), coinInsert.get(1), coinInsert.get(2), coinInsert.get(3));

        //Showing the changes in coins and snacks after the snack was bought
        System.out.println();
        System.out.println("The vending machine has the following snacks: ");
        V1.getSnackCount();

        System.out.println();
        System.out.println("And the following coins: ");
        V1.getCoinCount();

        //restocking the vending machine
        System.out.println();
        System.out.println("Restocking the vending machine and removing extra coins ");
        V1.reStock();
        V1.removeCoins();

        System.out.println();
        System.out.println("The vending machine has the following snacks: ");
        V1.getSnackCount();

        System.out.println();
        System.out.println("And the following coins: ");
        V1.getCoinCount();

    }


    public static ArrayList<Integer> buySnack() {

        ArrayList<Integer> inputArray = new ArrayList<>();

        Scanner inputQ = new Scanner(System.in);
        System.out.println("Please insert the number of quarters: ");
        int q = inputQ.nextInt();
        inputArray.add(q);

        Scanner inputD = new Scanner(System.in);
        System.out.println("Please insert the number of dimes: ");
        int d = inputD.nextInt();
        inputArray.add(d);

        Scanner inputN = new Scanner(System.in);
        System.out.println("Please insert the number of nickles: ");
        int n = inputN.nextInt();
        inputArray.add(n);

        Scanner inputP = new Scanner(System.in);
        System.out.println("Please insert the number of pennies: ");
        int p = inputP.nextInt();
        inputArray.add(p);

        return inputArray;

    }

}
