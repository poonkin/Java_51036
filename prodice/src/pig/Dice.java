package pig;

import javax.swing.*;
import java.awt.*;
/**
 * Created by dsvid88 on 5/1/15.
 */
public class Dice extends JComponent{

    private int random;
    public void paintComponent(Graphics g){

        g.setColor(Color.WHITE);
        g.fillRect(145, 60, 80, 80);

        if (random == 1) {
            g.setColor(Color.BLACK);
            g.fillOval(180, 95, 10, 10);
        }
        else if (random == 2) {
            g.setColor(Color.BLACK);
            g.fillOval(155, 65, 10, 10);
            g.fillOval(205, 115, 10, 10);
        }

        else if (random == 3) {
            g.setColor(Color.BLACK);
            g.fillOval(180, 95, 10, 10);
            g.fillOval(155, 65, 10, 10);
            g.fillOval(205, 115, 10, 10);

        }
        else if (random == 4) {
            g.setColor(Color.BLACK);
            g.fillOval(155, 65, 10, 10);
            g.fillOval(155, 115, 10, 10);
            g.fillOval(205, 65, 10, 10);
            g.fillOval(205, 115, 10, 10);
        }
        else if (random == 5) {
            g.setColor(Color.BLACK);
            g.fillOval(155, 65, 10, 10);
            g.fillOval(155, 115, 10, 10);
            g.fillOval(205, 65, 10, 10);
            g.fillOval(205, 115, 10, 10);
            g.fillOval(180, 95, 10, 10);
        }
        else if (random == 6) {
            g.setColor(Color.BLACK);
            g.setColor(Color.BLACK);
            g.fillOval(155, 65, 10, 10);
            g.fillOval(155, 90, 10, 10);
            g.fillOval(155, 115, 10, 10);

            g.fillOval(205, 65, 10, 10);
            g.fillOval(205, 90, 10, 10);
            g.fillOval(205, 115, 10, 10);

        }

    }

    public void printRandom(int x){
        random = x;
        repaint();
    }

}
