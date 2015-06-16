/**
 * Created by dsvid88 on 4/10/15.
 */
public class P0_0 {
    public static void main(String[] args) {

        int[] a1 = new int[5];

        fillWithRandomNumbers(a1);

        for (int i = 0; i < a1.length; i ++)
        {
            System.out.println(a1[i]);
        }
    }


    public static void fillWithRandomNumbers(int[] values)
    {

        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i ++)
        {
            numbers[i] = i;
            System.out.println(numbers[i]);
        }

        values = numbers;
    }


}