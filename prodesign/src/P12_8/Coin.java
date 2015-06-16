package P12_8;

/**
 * Created by dsvid88 on 5/7/15.
 */
public class Coin {

    private String name;
    private double value;
    private int quant;

    public Coin(String aName, double aValue, int aQuant) {
        this.name = aName;
        this.value = aValue;
        this.quant = aQuant;
    }

    public double getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public int getQuant() {
        return this.quant;
    }

    public void setQuant(int j) {
        this.quant = this.quant + j;
    }

    public void resetQuant() {
        this.quant = 10;
    }

}
