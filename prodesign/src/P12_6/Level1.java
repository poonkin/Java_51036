package P12_6;

import java.util.Random;
import java.util.Scanner;

public class Level1 {

    private int num1;
    private int num2;
    private int userAnswer;
    private int theAnswer;
    private boolean checker;
    private static int numCorrect;

    public int setNum1() {
        Random rn = new Random();
        this.num1 = rn.nextInt(6) + 1;
        return num1;
    }

    public int setNum2(int num1) {
        Random rn = new Random();
        this.num2 = rn.nextInt(8 - num1) + 1;
        return num2;
    }

    public void askQuestion(int number1, int number2) {
        //Prompting user for a question

        //checking to make sure the sum is less then 10
        if ((number1 + number2) == 10) {
            number2 = number2 - 1;
        }

        Scanner input1 = new Scanner(System.in);
        System.out.println("What is " + number1 + " + " + number2 + " ? ");

        this.userAnswer = input1.nextInt();
        this.theAnswer = number1 + number2;
        checkAnswer(userAnswer, theAnswer);

        if (checker == false) {
            Scanner input2 = new Scanner(System.in);
            System.out.println("What is " + number1 + " + " + number2 + " ? ");
            this.userAnswer = input2.nextInt();
            this.theAnswer = number1 + number2;
            this.checkAnswer(userAnswer, theAnswer);
        }
    }

    public boolean checkAnswer(int userAnswer, int theAnswer) {
        if (userAnswer == theAnswer) {

            //resetting num correct
            if (numCorrect == 5) {
                numCorrect = 0;
            }
            numCorrect = numCorrect + 1;
            return checker = true;

        } else {
            System.out.println(userAnswer + " is NOT correct ");
            return checker = false;
        }

    }

    public int getCorrect() {
        return numCorrect;
    }


}
