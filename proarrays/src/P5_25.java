/**
 * Created by dsvid88 on 4/9/15.
 */

import java.util.Scanner;

public class P5_25 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a zipcode: ");

        int zip = input.nextInt();

        printBarCode(zip);
    }

    public static void printBarCode(int zipcode) {

        System.out.print("|");
        int firstDigit = zipcode/10000;
        printDigit(firstDigit);

        int secondDigit = (zipcode - firstDigit*10000)/1000;
        printDigit(secondDigit);

        int thirdDigit = (zipcode - firstDigit*10000 - secondDigit*1000)/100;
        printDigit(thirdDigit);

        int fourthDigit = (zipcode - firstDigit*10000 - secondDigit*1000 - thirdDigit*100)/10;
        printDigit(fourthDigit);

        int fifthDigit = (zipcode - firstDigit*10000 - secondDigit*1000 - thirdDigit*100 - fourthDigit*10);
        printDigit(fifthDigit);

        int sum = (firstDigit + secondDigit + thirdDigit + fourthDigit + fifthDigit);
        int rem = sum % 10;
        int checkDigit = 10 - rem;
        printDigit(checkDigit);
        System.out.print("|");


        System.out.print("\n");
        System.out.println("Our zip code is: " + firstDigit + " " + secondDigit + " " + thirdDigit +
                " " + fourthDigit + " " + fifthDigit + "; the sum is " + sum + " our check is " +
                checkDigit);

    }

    public static void printDigit(int d){

        String barCode = "";

        switch(d) {

            case 0: barCode = "||:::";
                    break;
            case 1: barCode = ":::||";
                    break;
            case 2: barCode = "::|:|";
                    break;
            case 3: barCode = "::||:";
                    break;
            case 4: barCode = ":|::|";
                    break;
            case 5: barCode = ":|:|:";
                    break;
            case 6: barCode = ":||::";
                    break;
            case 7: barCode = "|:::|";
                    break;
            case 8: barCode = "|::|:";
                    break;
            case 9: barCode = "|:|::";
                    break;
        }

        System.out.print(barCode);

    }
}

