package P12_6;

/**
 * Created by dsvid88 on 5/7/15.
 */

public class Driver {

    public static void main(String[] args) {

        int n1;
        int n2;

        Level1 l1 = new Level1();
        while (l1.getCorrect() < 5) {

            n1 = l1.setNum1();
            n2 = l1.setNum2(n1);
            l1.askQuestion(n1, n2);

            System.out.println("The number of correct answers is " + l1.getCorrect());
        }

        System.out.println();
        System.out.println("CONGRATULATIONS, WELCOME TO LEVEL 2");
        System.out.println();

        Level2 l2 = new Level2();

        do {

            n1 = l2.setNum1();
            n2 = l2.setNum2(n1);
            l2.askQuestion(n1, n2);

            System.out.println("The number of correct answers is " + l2.getCorrect());

        } while (l2.getCorrect() < 5);


        System.out.println();
        System.out.println("CONGRATULATIONS, WELCOME TO LEVEL 3");
        System.out.println();

        Level3 l3 = new Level3();

        do {
            n1 = l3.setNum1();
            n2 = l3.setNum2(n1);
            l3.askQuestion(n1, n2);

            System.out.println("The number of correct answers is " + l3.getCorrect());
        } while (l3.getCorrect() < 5);


        System.out.println();
        System.out.println("CONGRATULATIONS, YOU BEAT THE GAME!!!");


    }

}
