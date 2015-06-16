package P10_2;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by dsvid88 on 4/29/15.
 */
public class ButtonFrame extends JFrame {
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 60;

    public ButtonFrame() {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void createComponents() {
        JButton button = new JButton("Click Me!");
        JPanel panel = new JPanel();
        panel.add(button);
        add(panel);

        ActionListener listener = new ClickListener();
        button.addActionListener(listener);

    }
}





