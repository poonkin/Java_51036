package P9_13;
import java.awt.Point;
/**
 * Created by dsvid88 on 4/22/15.
 */
public class LabeledPoint extends Point {

    private String label;

    public LabeledPoint(int x, int y, String label) {
        super(x, y);
        this.label = label;
    }

    public String toString() {
        return super.toString() + this.label;
    }

}