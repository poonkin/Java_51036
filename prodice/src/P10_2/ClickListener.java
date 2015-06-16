package P10_2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Created by dsvid88 on 4/29/15.
 */
public class ClickListener implements ActionListener{

    private int counter = 0;

    public void actionPerformed(ActionEvent event)
    {
        counter = counter + 1;
        System.out.println("I was clicked " + counter + " times ");
    }

}