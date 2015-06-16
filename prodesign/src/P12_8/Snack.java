package P12_8;

/**
 * Created by dsvid88 on 5/7/15.
 */
public class Snack {

    private String description;
    private double price;
    private int quant;

    public Snack(String aDescription, double aPrice, int quantity) {
        description = aDescription;
        price = aPrice;
        this.quant = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant() {
        this.quant = this.quant - 1;
    }

    public void reStock() {
        this.quant = 10;
    }

}
