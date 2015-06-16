package P11_22;
import javax.swing.*;
import java.awt.*;

/**
 * Created by dsvid88 on 5/1/15.
 */
public class LineComponent extends JComponent{

    int[] triangleArray = new int[6];
    private int point_x;
    private int point_y;
    private int counter;

    public LineComponent(){
        point_x = 0;
        point_y = 0;
        counter = 0;
    }

    public void paintComponent(Graphics g)
    {

        if (counter == 1) {
            g.drawLine(triangleArray[0], triangleArray[1], triangleArray[0], triangleArray[1]);
        }
        else if (counter == 2) {
            g.drawLine(triangleArray[0], triangleArray[1], triangleArray[2], triangleArray[3]);
        }
        else if (counter == 3 ) {
            g.drawLine(triangleArray[0], triangleArray[1], triangleArray[2], triangleArray[3]);
            g.drawLine(triangleArray[0], triangleArray[1], triangleArray[4], triangleArray[5]);
            g.drawLine(triangleArray[2], triangleArray[3], triangleArray[4], triangleArray[5]);
        }

    }

    public void printPoint(int x, int y)
    {
        counter = counter + 1;

        if (counter == 1) {
            triangleArray[0] = x;
            triangleArray[1] = y;
        }
        else if (counter == 2) {
            triangleArray[2] = x;
            triangleArray[3] = y;
        }
        else if (counter == 3) {
            triangleArray[4] = x;
            triangleArray[5] = y;
        }
        else {
            counter = 0;
        }

        repaint();

    }


}
