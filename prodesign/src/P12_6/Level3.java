package P12_6;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by dsvid88 on 5/7/15.
 */
public class Level3 extends Level2 {

    private int num1;
    private int num2;
    private int userAnswer;
    private int theAnswer;
    private boolean checker;

    //overriding Level1 method
    public int setNum1() {
        Random rn = new Random();
        this.num1 = rn.nextInt(8) + 1;

        return this.num1;
    }

    //overriding Level1 method
    public int setNum2(int num1) {
        Random rn = new Random();
        this.num2 = rn.nextInt(8) + 1;
        return this.num2;
    }

    //inheriting Level1 method
    public void askQuestion(int number1, int number2) {
        //Prompting user for a question

        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        if (number1 == number2) {
            number1 = number1 + 1;
        }

        Scanner input1 = new Scanner(System.in);
        System.out.println("What is " + number1 + " - " + number2 + " ? ");

        this.userAnswer = input1.nextInt();
        this.theAnswer = number1 - number2;

        this.checker = checkAnswer(userAnswer, theAnswer);

        if (this.checker == false) {
            Scanner input2 = new Scanner(System.in);
            System.out.println("What is " + number1 + " - " + number2 + " ? ");
            this.userAnswer = input2.nextInt();
            this.theAnswer = number1 - number2;
            this.checkAnswer(userAnswer, theAnswer);
        }
    }

    //inheriting Level1 method
    public boolean checkAnswer(int userAnswer, int theAnswer) {
        int a = userAnswer;
        int b = theAnswer;
        return super.checkAnswer(a, b);
    }

    //inheriting Level1 method
    public int getCorrect() {
        return super.getCorrect();
    }


}
