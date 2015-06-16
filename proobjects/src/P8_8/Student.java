package P8_8;

/**
 * Created by dsvid88 on 4/15/15.
 */
public class Student {

    //declaring attributes
    private String name;
    private double totalQuizScore;
    private int numQuizes;

    //implementing a constructor
    public Student(String name) {
        this.name = name;
        this.numQuizes = 0;
        this.totalQuizScore = 0;
    }

    //addQuiz method
    public void addQuiz(int score) {
        this.totalQuizScore = this.totalQuizScore + score;
        this.numQuizes = this.numQuizes + 1;
    }

    //getName
    public String getName() {
        return this.name;
    }

    //returning a totalScore
    public double getTotalScore() {
        return this.totalQuizScore;
    }

    //getting average score
    public double getAverage() {
        return (double) (this.totalQuizScore / this.numQuizes);
    }

}