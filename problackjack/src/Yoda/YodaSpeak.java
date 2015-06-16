package Yoda;

/**
 * Created by dsvid88 on 5/16/15.
 */
public class YodaSpeak {

    public static void main(String[] args) {

        System.out.println("Enter something:");
        String input = System.console().readLine();

        System.out.println("You entered : " + input);


        String delims = "[ ]+";
        String[] tokens = input.split(delims);

        int i = tokens.length - 1;
        while (i >= 0) {
            System.out.print(tokens[i] + " ");
            i--;
        }

        System.out.println();

    }
}