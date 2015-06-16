package P9_16;

/**
 * Created by dsvid88 on 4/23/15.
 */
public class Country implements Measurable {

    private String name;
    private int surfaceArea;

    public Country( String name, int surfaceArea) {
        this.name = name;
        this.surfaceArea = surfaceArea;
    }

    public Object getSize(){
        return (Object) surfaceArea;
    }

    public String getName(){
        return this.name;
    }




}
