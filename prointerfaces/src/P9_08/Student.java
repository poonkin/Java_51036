package P9_08;

/**
 * Created by dsvid88 on 4/22/15.
 */
public class Student extends Person{

    private String major;

    public Student(String name, int yearOfBirth, String major){
        super(name, yearOfBirth);
        this.major = major;
    }

    public String getName() {
        return super.getName();
    }

    public int getYear(){
        return super.getYear();
    }

    public String toString(){
        return "Student " + this.getName() + " was born in " + this. getYear() +
                " and is majoring in " + this.major;
    }

}