package P9_23;

/**
 * Created by dsvid88 on 4/23/15.
 */
public class Appointment {

    private String description;
    private int year;
    private int month;
    private int day;
    private boolean occurs;

    public Appointment(int year, int month, int day, String description){
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description; 
    }

    public String getDescription(){
        return this.description;
    }

    public void addNew( String description, int year, int month, int day ){
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean occursOn( int year, int month, int day) {
        if (this.year == year && this.month == month && this.day == day){
            this.occurs = true;
        }
        else{
            this.occurs = false;
        }
        return this.occurs;
    }


}