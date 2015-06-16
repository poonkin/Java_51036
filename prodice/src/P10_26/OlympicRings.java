package P10_26;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.*;

/**
 * Created by dsvid88 on 4/29/15.
 */
public class OlympicRings {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        frame.setSize(400, 200);
        frame.setTitle("Olympic Rings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE );

        JComponent r1 = new Ring();
        frame.add(r1);

        frame.setVisible(true);

    }
}
