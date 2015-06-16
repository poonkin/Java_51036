/**
 * Created by dsvid88 on 4/8/15.
 */
import java.util.Scanner;

public class P5_20 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a year: ");

        int year = input.nextInt();

        System.out.println("Is " + year + " a leap year? " + isLeapYear(year));

    }

    public static boolean isLeapYear(int year) {

        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;

    }
}