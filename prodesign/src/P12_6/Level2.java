package P12_6;

import java.util.Random;

/**
 * Created by dsvid88 on 5/7/15.
 */
public class Level2 extends Level1 {

    private int num1;
    private int num2;


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
    public void askQuestion(int num1, int num2) {
        //Prompting user for a question
        super.askQuestion(num1, num2);
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
