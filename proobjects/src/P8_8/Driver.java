package P8_8;

/**
 * Created by dsvid88 on 4/15/15.
 * The instructions for this problem are not very clear, I tried my best to implement it
 */
public class Driver {

    public static void main(String[] args) {

        Student student = new Student("Mike");

        System.out.println("The name of the student is " + student.getName());

        student.addQuiz(90);
        student.addQuiz(85);
        student.addQuiz((100));

        System.out.println("The total on 3 quizes is " + student.getTotalScore() + " the average score is " +
                +student.getAverage());
        System.out.println("\n");

        Grade mikesGrade = new Grade(student.getAverage());
        String letterGrade = mikesGrade.getGrade();
        Double numberGrade = mikesGrade.toNumeric(letterGrade);

        System.out.println("The students letter grade is " + letterGrade + " which " +
                " is a GPA of " + numberGrade);

    }

}