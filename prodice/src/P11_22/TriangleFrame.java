package P11_22;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by dsvid88 on 5/1/15.
 */
public class TriangleFrame extends JFrame {

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;

    private LineComponent point;


    class MousePressListener implements MouseListener {
        public void mousePressed(MouseEvent event) {

            int x = event.getX();
            int y = event.getY();
            point.printPoint(x,y);

        }

        //Do nothing methods
        public void mouseReleased(MouseEvent event) {
        }
        public void mouseClicked(MouseEvent event) {
        }
        public void mouseEntered(MouseEvent event) {
        }
        public void mouseExited(MouseEvent event) {
        }

    }

    public TriangleFrame() {

        point = new LineComponent();
        MouseListener listener1 = new MousePressListener();
        point.addMouseListener(listener1);
        add(point);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);

    }
}