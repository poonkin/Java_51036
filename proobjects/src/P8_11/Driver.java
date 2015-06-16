package P8_11;

/**
 * Created by dsvid88 on 4/16/15.
 */
public class Driver {

    public static void main(String[] args) {

        Letter myLetter = new Letter("Mary", "John");

        myLetter.addLine("Im sorry we must part.");
        myLetter.addLine("I wish you all the best.");

        System.out.print(myLetter.getText());
    }

}
