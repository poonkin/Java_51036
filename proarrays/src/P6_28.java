/**
 * Created by dsvid88 on 4/9/15.
 */
//NOTE: This should run in O(n)

import java.util.ArrayList;

public class P6_28 {

    public static void main(String[] args) {

        ArrayList<Integer> Array1 = new ArrayList<Integer>();
        ArrayList<Integer> Array2 = new ArrayList<Integer>();

        //adding elements to the first arrayList;
        int[] a1 = {1, 4, 9, 16};
        int[] a2 = {4, 7, 9, 9, 11};

        for (int i = 0; i < a1.length; i++) {
            Array1.add(a1[i]);
        }

        //adding elements to the second array
        for (int j = 0; j < a2.length; j++) {
            Array2.add(a2[j]);
        }


        ArrayList<Integer> Array3 = new ArrayList<Integer>();
        Array3 = mergeSorted(Array1, Array2);

        System.out.println("Before we merge :");
        System.out.println(Array1);
        System.out.println(Array2);

        System.out.println("\n");
        System.out.println("After the merge :");
        System.out.println(Array3);

    }

    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> leftArray, ArrayList<Integer> rightArray) {

        ArrayList<Integer> finalArray = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i) < rightArray.get(j)) {
                finalArray.add(k, leftArray.get(i));
                i = i + 1;
            } else {
                finalArray.add(k, rightArray.get(j));
                j = j + 1;
            }
            k = k + 1;
        }

        while (i < leftArray.size()) {
            finalArray.add(k, leftArray.get(i));
            i = i + 1;
            k = k + 1;
        }

        while (j < rightArray.size()) {
            finalArray.add(k, rightArray.get(j));
            j = j + 1;
            k = k + 1;
        }

        return finalArray;
    }
}

