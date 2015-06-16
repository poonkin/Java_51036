/**
 * Created by dsvid88 on 4/10/15.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P7_2 {

    public static void main(String[] args) throws FileNotFoundException {

        //prompting user for input file
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a file name: (P7_2.txt) "); //Enter P7_2.txt
        String fileIn = input.next();

        File inputFile = new File(fileIn);
        Scanner in = new Scanner(inputFile);

        //prompting user for output file
        Scanner output = new Scanner(System.in);
        System.out.println("Please enter output file name: "); // You can call this anything you like
        String fileOut = input.next();

        PrintWriter out = new PrintWriter(fileOut);

        //reading the file and writing to a new file
        int counter = 1;
        while(in.hasNextLine())
        {
            String line = in.nextLine();
            out.printf("/* " + counter + " */ " + line + "\n");
            counter++;
        }

        in.close(); //Closing the input file
        out.close(); //Closing the output file




    }

}