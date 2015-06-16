package P8_8;

/**
 * Created by dsvid88 on 4/16/15.
 */

public class Grade {

    private String grade;

    public Grade(double averageScore) {

        if (averageScore >= 94 && averageScore <= 100) {
            this.grade = "A";
        } else if (averageScore >= 90 && averageScore <= 93) {
            this.grade = "A-";
        } else if (averageScore >= 87 && averageScore <= 89) {
            this.grade = "B+";
        } else if (averageScore > 83 && averageScore <= 86) {
            this.grade = "B";
        } else if (averageScore >= 80 && averageScore <= 83) {
            this.grade = "B-";
        } else if (averageScore >= 77 && averageScore <= 79) {
            this.grade = "C+";
        } else if (averageScore >= 73 && averageScore <= 76) {
            this.grade = "C";
        } else if (averageScore >= 70 && averageScore <= 72) {
            this.grade = "C-";
        } else if (averageScore >= 67 && averageScore <= 69) {
            this.grade = "D+";
        } else if (averageScore >= 60 && averageScore <= 66) {
            this.grade = "D";
        } else
            this.grade = "F";
    }

    public String getGrade() {
        return this.grade;
    }

    public double toNumeric(String grade) {

        if (grade.equals("A")) {
            return 4.0;
        } else if (grade.equals("A-")) {
            return 3.7;
        } else if (grade.equals("B+")) {
            return 3.3;
        } else if (grade.equals("B")) {
            return 3.0;
        } else if (grade.equals("B-")) {
            return 2.7;
        } else if (grade.equals("C+")) {
            return 2.3;
        } else if (grade.equals("C")) {
            return 2.0;
        } else if (grade.equals("C-")) {
            return 1.7;
        } else if (grade.equals("D+")) {
            return 1.3;
        } else if (grade.equals("D")) {
            return 1.0;
        } else
            return 0.0;
    }

}