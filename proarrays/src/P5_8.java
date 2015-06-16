/**
 * Created by dsvid88 on 4/8/15.
 */

import java.util.Scanner;
import java.util.Random;

public class P5_8 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a word:");

        String word = input.next();

        String scrambledWord = scramble(word);

    }

    public static String scramble(String word){

        if (word.length() > 3) {

            //generating two uniformly distributed random numbers
            Random rn = new Random();
            int rNumber1 = rn.nextInt(word.length() - 2) + 1;
            int rNumber2 = rn.nextInt(word.length() - 2) + 1;

            //making sure that two randomly generated numbers are not equal
            while (rNumber1 == rNumber2){
                rNumber2 = rn.nextInt(word.length() - 2) + 1;
            }

            //picking two random letters
            char rnLetter1 = word.charAt(rNumber1);
            char rnLetter2 = word.charAt(rNumber2);


            for ( int i = 0; i < word.length(); i++){

                if (word.charAt(i) == rnLetter1) {
                    word = word.substring(0, i) + rnLetter2 + word.substring(i+1, word.length());
                }
                else if (word.charAt(i) == rnLetter2){
                    word = word.substring(0, i) + rnLetter1 + word.substring(i+1, word.length());
                }
            }

            return word;
        }
        else
        {
            return word;

        }
    }
}
