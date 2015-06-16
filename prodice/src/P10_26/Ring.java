package P10_26;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dsvid88 on 5/1/15.
 */
public class Ring extends JComponent{

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(10F));

        //Top Left
        g2.setColor(Color.BLUE);
        g2.drawOval(10, 10, 90, 90);

        //Top Middle
        g2.setColor(Color.BLACK);
        g2.drawOval(110, 10, 90, 90);

        //Top Right
        g2.setColor(Color.RED);
        g2.drawOval(210, 10, 90, 90);

        //Bottom Left
        g2.setColor(Color.YELLOW);
        g2.drawOval(60, 60, 90, 90);

        //Bottom Right
        g2.setColor(Color.GREEN);
        g2.drawOval(160, 60, 90, 90);

    }

}
