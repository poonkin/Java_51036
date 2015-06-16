package pig;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by dsvid88 on 5/1/15.
 */

public class PigFrame extends JFrame {

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 400;

    private JLabel userScore;
    private JLabel computerScore;
    private JLabel turnTotal;
    private JLabel rollTotal;

    private JButton roll_button, stop_button, clear_button;

    private int userTotal = 0;
    private int computerTotal = 0;
    private int tTotal = 0;


    public PigFrame() {

        createTextField();
        createButtons();
        createPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("PIG");
    }


    private void createTextField() {

        userScore = new JLabel("USER TOTAL: ");
        computerScore = new JLabel("COMPUTER TOTAL: ");
        rollTotal = new JLabel("Roll Score: ");
        turnTotal = new JLabel("Turn Score: ");

    }

    public void createButtons() {

        roll_button = new JButton("Roll");
        stop_button = new JButton("Stop");
        clear_button = new JButton("CLEAR");

        ActionListener roll_listener = new ClickListener();
        ActionListener stop_listener = new ClickListener();
        ActionListener clear_listner = new ClickListener();

        roll_button.addActionListener(roll_listener);
        stop_button.addActionListener(stop_listener);
        clear_button.addActionListener(clear_listner);
    }

    Dice component;


    class ClickListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getActionCommand().equals("Roll")) {

                System.out.println("You just clicked rolled");
                Random rn = new Random();
                int die = rn.nextInt(6) + 1;

                System.out.println("You rolled " + die);
                component.printRandom(die);

                if (die == 1) {

                    rollTotal.setText("Roll Score: " + 0);
                    tTotal = 0;
                    turnTotal.setText("Turn Score: " + tTotal);

                    JOptionPane.showMessageDialog(null, "USER rolled a 1, its COMPUTERs turn!");

                    int counterRoll = 0;
                    while (counterRoll < 7) {

                        die = rn.nextInt(6) + 1;
                        tTotal = tTotal + die;
                        computerTotal = computerTotal + die;
                        computerScore.setText("COMPUTER TOTAL: " + computerTotal);
                        counterRoll = counterRoll + 1;
                    }

                    JOptionPane.showMessageDialog(null, "Computer rolled a total of " + tTotal + ", its USER turn!");
                    tTotal = 0;

                    checkScores(computerTotal, userTotal );


                } else {

                    rollTotal.setText("Roll Score: " + die);
                    tTotal = tTotal + die;
                    turnTotal.setText("Turn Score: " + tTotal);
                    //component.printRandom(die);
                }


            } else if (event.getActionCommand().equals("Stop")) {

                //updating user score board
                userTotal = userTotal + tTotal;
                tTotal = 0;
                rollTotal.setText("Roll Score: " + 0);
                turnTotal.setText("Turn Score: " + tTotal);
                userScore.setText("USER TOTAL: " + userTotal);

                int counterRoll = 0;
                while (counterRoll < 7) {

                    Random rn = new Random();
                    int die = rn.nextInt(6) + 1;
                    tTotal = tTotal + die;
                    computerTotal = computerTotal + die;
                    computerScore.setText("COMPUTER TOTAL: " + computerTotal);
                    counterRoll = counterRoll + 1;

                }

                if(computerTotal >= 100) {
                    checkScores(computerTotal, userTotal);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Computer rolled a total of " + tTotal + ", its USER turn!");
                    checkScores(computerTotal, userTotal);
                    tTotal = 0;
                }

            } else if (event.getActionCommand().equals("CLEAR")) {

                userTotal = 0;
                tTotal = 0;
                computerTotal = 0;

                rollTotal.setText("Roll Score: " + 0);
                turnTotal.setText("Turn Score: " + 0);
                userScore.setText("USER TOTAL: ");
                computerScore.setText("COMPUTER TOTAL: ");
                component.printRandom(0);

                  }

            }

        public void checkScores(int computerScore, int userScore){

                if (computerScore >= 100){
                    JOptionPane.showMessageDialog(null, "Computer has over 100, it WON!");

                    userTotal = 0;
                    tTotal = 0;
                    computerTotal = 0;
                    rollTotal.setText("Roll Score: " + 0);
                    turnTotal.setText("Turn Score: " + 0);
                    component.printRandom(0);

                }
                else if (userScore >= 100){
                    JOptionPane.showMessageDialog(null, "USER has over 100, you are the WINNER!");

                    userTotal = 0;
                    tTotal = 0;
                    computerTotal = 0;
                    rollTotal.setText("Roll Score: " + 0);
                    turnTotal.setText("Turn Score: " + 0);
                    component.printRandom(0);
                }

            }

    }


    private void createPanel() {

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JPanel scorePanel = new JPanel();
        scorePanel.setPreferredSize(new Dimension(100, 50));
        scorePanel.setLayout(new GridLayout(1, 2));
        scorePanel.add(userScore);
        scorePanel.add(computerScore);

        JPanel dicePanel = new JPanel();
        dicePanel.setPreferredSize(new Dimension(100, 100));
        dicePanel.setLayout(new BorderLayout());

        component = new Dice();
        dicePanel.add(component, BorderLayout.CENTER);

        JPanel gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(100, 100));
        gamePanel.setLayout(new BorderLayout());

        JPanel buttonPanelW = new JPanel();
        buttonPanelW.setLayout(new GridLayout(2, 1));
        gamePanel.add(buttonPanelW, BorderLayout.WEST);

        buttonPanelW.add(roll_button);
        buttonPanelW.add(stop_button);

        JPanel sPanel = new JPanel();
        sPanel.setLayout(new GridLayout(2, 1));
        sPanel.add(rollTotal);
        sPanel.add(turnTotal);

        gamePanel.add(sPanel, BorderLayout.EAST);
        gamePanel.add(clear_button);

        scorePanel.setBorder(new TitledBorder(new EtchedBorder(), "Score"));
        dicePanel.setBorder(new TitledBorder(new EtchedBorder(), "Dice"));
        gamePanel.setBorder(new TitledBorder(new EtchedBorder(), "GamePlay"));

        panel.add(scorePanel, BorderLayout.NORTH);
        panel.add(dicePanel, BorderLayout.CENTER);
        panel.add(gamePanel, BorderLayout.SOUTH);

        add(panel);
    }

}


