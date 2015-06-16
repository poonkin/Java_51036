

/**
 * Created by dsvid88 on 4/9/15.
 */

import java.util.Random;

public class P6_12 {
    public static void main(String[] args) {

        //declaring an array of size 20
        int[] input = new int[20];

        //generating an array of 20 random die tosses
        Random rn = new Random();
        int toss = 0;

        for (int i = 0; i < input.length; i++) {
            toss = rn.nextInt(6) + 1;
            input[i] = toss;
        }

        System.out.println("\n");

        //implementing the text book's algorithm

        boolean inRun = false;

        for (int counter = 0; counter < (input.length); counter++) {

            if (inRun == true) {
                if (input[counter] != input[counter - 1]) {
                    System.out.print(")");
                    inRun = false;
                }
            }
            else {
                if (input[counter] == input[counter+1] && counter < 19) {
                    System.out.print("(");
                    inRun = true;
                }
            }
            System.out.print(input[counter]);
        }


        if (inRun == true) {
            System.out.print(")");
        }

        System.out.println("\n");
    }

}