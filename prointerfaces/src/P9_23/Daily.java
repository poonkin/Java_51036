package P9_23;

/**
 * Created by dsvid88 on 4/23/15.
 */
public class Daily extends Appointment{

    private String type;

    public Daily(int year, int month, int day, String description){
        super(year, month,  day, description );
        this.type = "Daily";
    }

   public void addNew( String description, int year, int month, int day ){
        super.addNew(description, year, month, day);

    }

}
