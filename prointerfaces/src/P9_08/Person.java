package P9_08;

/**
 * Created by dsvid88 on 4/22/15.
 */
public class Person {

    private String name;
    private int yearOfBirth;

    public Person( String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String toString() {
        return "Person name " + this.name + " was born in " + this.yearOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.yearOfBirth;
    }

}
