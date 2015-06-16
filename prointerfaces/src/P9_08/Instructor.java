package P9_08;

/**
 * Created by dsvid88 on 4/22/15.
 */
public class Instructor extends Person{

    private int salary;

    public Instructor( String name, int yearofBirth, int s){
        super(name, yearofBirth);
        this.salary = s;
    }

    public String getName() {
        return super.getName();
    }

    public int getYear() {
        return super.getYear();
    }

    public String toString(){
        return "Instructor " + this.getName() + " was born in " + this.getYear() +
                " and has a salary of " + this.salary;
    }

}
