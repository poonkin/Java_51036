package P9_08;

/**
 * Created by dsvid88 on 4/22/15.
 */
public class Driver {

    public static void main(String[] args) {

        Person person1 = new Person( "Donny", 1988);

        String p1 = person1.toString();
        System.out.println(p1);

        Student student1 = new Student( "Mike", 1991, "Computer Science");
        String s1 = student1.toString();
        System.out.println(s1);

        Instructor instructor1 = new Instructor("John", 1978, 100000);
        String i1 = instructor1.toString();
        System.out.println(i1);

    }

}