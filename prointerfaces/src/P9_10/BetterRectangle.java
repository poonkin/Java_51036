package P9_10;

import java.awt.*;

/**
 * Created by dsvid88 on 4/22/15.
 */
public class BetterRectangle extends Rectangle{

    public BetterRectangle(int x, int y, int width, int height){
        super.setSize(width, height);
        super.setLocation(x, y);
    }

    public double getHeight(){
        return super.getHeight();
    }

    public double getWidth(){
        return super.getWidth();
    }

    public double getPerimeter(){
        double perimeter = 2*this.getHeight() + 2* this.getWidth();
        return perimeter;
    }

    public double getArea(){
        double area = this.getHeight()*this.getWidth();
        return area;
    }

}
