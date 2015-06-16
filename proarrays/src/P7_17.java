/**
 * Created by dsvid88 on 4/12/15.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P7_17 {

    public static void main(String[] args) throws FileNotFoundException {

        //prompting user for input file
        File inputFile = new File("P7_17.txt");
        Scanner in = new Scanner(inputFile);



        int counter = 1;
        while(in.hasNextLine())
        {
            String line = in.nextLine();

            System.out.println(line);

            counter++;
        }

        in.close(); //Closing the input file

    }
}
