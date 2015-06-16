package P9_23;
import java.util.Scanner;


/**
 * Created by dsvid88 on 4/23/15.
 */
public class Driver {

    public static void main(String[] args) {

        Scanner input1 = new Scanner(System.in);
        System.out.println("Please enter a date - (mm/dd/yyyy) - (eg. 12/01/2015): ");

        String date = input1.next();

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));

        Appointment[] appBook = new Appointment[20];

        appBook[0] = new Appointment(2015, 5, 2, "dentist");
        appBook[1] = new Daily(2015, 12, 1, "haircut");
        appBook[2] = new Monthly(2015, 8, 4, "doctor");
        appBook[3] = new Onetime(2015, 9, 2, "mechanic");


        int counter = 0;
        for (int i = 0; i < appBook.length; i++) {
            if (appBook[i].occursOn(year, month, day) == true) {
                System.out.println("There is a " + appBook[i].getDescription() + " appointment on that date");
           }
           counter = counter+1;
        }

        Scanner input2 = new Scanner(System.in);
        System.out.println("Would you like to make an appointment? (y/n)?");

        String answer = input2.next();

       if (answer.equals("y")){
            Scanner input3 = new Scanner(System.in);
            System.out.println("Please enter type, description, date :");

            String type = input3.next();
            String description = input3.next();
            String date2 = input3.next();
            int m = Integer.parseInt(date2.substring(0, 2));
            int d = Integer.parseInt(date2.substring(3, 5));
            int y = Integer.parseInt(date2.substring(6, 10));

            System.out.println("You entered " + type + description + date2);

            if(type.equals("Daily")){
                appBook[counter] = new Daily(y, m, d, description);
                counter++;
            }
            else if (type.equals("Monthly")){
                appBook[counter] = new Monthly(y, m, d, description);
                counter++;
            }
            else if (type.equals("Onetime")){
                appBook[counter] = new Onetime(y, m, d, description);
                counter++;
            }

        }
        else {
            System.out.println("Have a good day!!!");
        }

    }
}
