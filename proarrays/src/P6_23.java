/**
 * Created by dsvid88 on 4/9/15.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class P6_23 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList <Integer> data = new ArrayList<>();
        ArrayList <String> caption = new ArrayList<>();

        System.out.println("Please enter a caption: ");
        String cap = input.next();
        caption.add(cap);

        System.out.println("Please enter a non-negative data, enter (0 to exit):");
        int num = input.nextInt();
        data.add(num);

        while (num != 0 && cap != null) {


            System.out.println("Please enter a caption: ");
            cap = input.next();

            System.out.println("Please enter a non-negative data, enter (0 to exit):");
            num = input.nextInt();
            if(num > 0 && cap != null){
                caption.add(cap);
                data.add(num);
                }
        }

        printBar(data, caption);

    }

    public static void printBar(ArrayList<Integer> alist, ArrayList<String> caption){

        //list containing the numbers of bars to be printed per caption
        ArrayList <Integer> numBars = new ArrayList<>();

        int max = 0;
        for( int i = 0; i < alist.size(); i++){
            if (alist.get(i) > max) {
                max = alist.get(i);
            }
           }

        for(int j = 0; j < alist.size(); j++){
            numBars.add(40 * alist.get(j) / max);
        }


        for(int k = 0; k < alist.size(); k++){
            System.out.print(caption.get(k) + ": ");
            for( int c = 0; c <= numBars.get(k); c++){
                System.out.print("*");
            }
            System.out.println();

        }

    }

}