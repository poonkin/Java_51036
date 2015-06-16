import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dsvid88 on 5/13/15.
 */
public class blackJackUI extends JFrame {

    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 600;

    // private JLabel userScore;
    private JLabel computerScore;
    private JLabel turnTotal;
    private JLabel cardTotalLabel;

    private JLabel imageLabel1, getImageLabel2, cardLabel1, cardLabel2, cardLabel3, cardLabel4;


    private JButton hit_button, stay_button, clear_button, start_button, dollarChip, fiveDollarChip, tenDollarChip, twentyFiveDollarChip,
            fiftyDollarChip;

    static int money = 1000;
    static int betAmount = 0;
    static int userScore = 0;
    static int dScore = 0;

    JLabel betLabel = new JLabel();
    JLabel scoreLabel = new JLabel();
    JPanel cardPanel = new JPanel();
    JLayeredPane lpane = new JLayeredPane();
    JPanel cardPanelDealer = new JPanel();


    Card component, componentDealer;

    public blackJackUI() throws IOException {


        //createTextField();
        createButtons();
        createPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BLACK JACK");
    }


    //creating Buttons
    public void createButtons() {

        hit_button = new JButton("Hit Me");
        stay_button = new JButton("Stay");
        clear_button = new JButton("CLEAR");
        start_button = new JButton("DEAL");

        dollarChip = new JButton("$1");
        fiveDollarChip = new JButton("$5");
        tenDollarChip = new JButton("$10");
        twentyFiveDollarChip = new JButton("$25");
        fiftyDollarChip = new JButton("$50");

        ActionListener hit_listener = new ClickListener();
        ActionListener stay_listener = new ClickListener();
        ActionListener clear_listner = new ClickListener();
        ActionListener start_listner = new ClickListener();

        ActionListener one_listener = new ClickListener();
        ActionListener five_listener = new ClickListener();
        ActionListener ten_listener = new ClickListener();
        ActionListener twentyfive_listener = new ClickListener();
        ActionListener fifty_listener = new ClickListener();

        hit_button.addActionListener(hit_listener);
        stay_button.addActionListener(stay_listener);
        clear_button.addActionListener(clear_listner);
        start_button.addActionListener(start_listner);

        dollarChip.addActionListener(one_listener);
        fiveDollarChip.addActionListener(five_listener);
        tenDollarChip.addActionListener(ten_listener);
        twentyFiveDollarChip.addActionListener(twentyfive_listener);
        fiftyDollarChip.addActionListener(fifty_listener);

    }


    //helper variables and method for inner class ClickListner
    private static int cardNum = 0;
    private static int dealerCardNum = 0;

    public void setCardNum() {
        this.cardNum++;
    }

    public void resetCardNum() {
        this.cardNum = 0;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setDealerCardNum() {
        this.dealerCardNum++;
    }

    public int getDealerCardNum() {
        return dealerCardNum;
    }

    private static ArrayList<Card> deck = new ArrayList<>();
    private static ArrayList<Card> userHand = new ArrayList<>();
    private static ArrayList<Card> dealerHand = new ArrayList<>();


    //////deck methods///////////////
    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public void setDeck(ArrayList<Card> a) {
        this.deck = a;
    }

    public ArrayList<Card> shuffleDeck() {

        this.deck = playGame.makeDeck();
        Collections.shuffle(this.deck);
        return this.deck;

    }

    /////////userHand Methods //////////////
    public ArrayList<Card> getUserHand() {
        return this.userHand;
    }

    public void setUserHand(ArrayList<Card> d) {
        this.userHand.add(playGame.dealCards(d));
    }

    ////////////dealerHand Methods//////////////

    public ArrayList<Card> getDealerHand() {
        return this.dealerHand;
    }

    public void setDealerHand(ArrayList<Card> d) {
        this.dealerHand.add(playGame.dealCards(d));
    }


    class ClickListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {

            ///////////////**** BETTING EVENT *********//////////////////////


            if (event.getActionCommand().equals("$1")) {

                if (betAmount < money) {
                    betAmount = betAmount + 1;
                    betLabel.setText("Bet Amount: $" + betAmount);
                    System.out.println("The total bet amount is " + betAmount);
                } else {
                    JOptionPane.showMessageDialog(null, "You only have $" + money + " !!!!");
                }

            }

            //betting $5
            if (event.getActionCommand().equals("$5")) {

                if (betAmount < money) {
                    betAmount = betAmount + 5;
                    System.out.println("The total bet amount is " + betAmount);
                    betLabel.setText("Bet Amount: $" + betAmount);
                } else {
                    JOptionPane.showMessageDialog(null, "You only have $" + money + " !!!!");
                }
            }

            //betting $10
            if (event.getActionCommand().equals("$10")) {

                if (betAmount < money) {
                    betAmount = betAmount + 10;
                    System.out.println("The total bet amount is " + betAmount);
                    betLabel.setText("Bet Amount: $" + betAmount);
                } else {
                    JOptionPane.showMessageDialog(null, "You only have $" + money + " !!!!");
                }
            }

            //betting $25
            if (event.getActionCommand().equals("$25")) {

                if (betAmount < money) {
                    betAmount = betAmount + 25;
                    System.out.println("The total bet amount is " + betAmount);
                    betLabel.setText("Bet Amount: $" + betAmount);
                } else {
                    JOptionPane.showMessageDialog(null, "You only have $" + money + " !!!!");
                }

            }

            //betting $50
            if (event.getActionCommand().equals("$50")) {

                if (betAmount < money) {
                    betAmount = betAmount + 50;
                    System.out.println("The total bet amount is " + betAmount);
                    betLabel.setText("Bet Amount: $" + betAmount);
                } else {
                    JOptionPane.showMessageDialog(null, "You only have $" + money + " !!!!");
                }
            }


            //////****** GAME PLAY ****/////////////////

            if (event.getActionCommand().equals("DEAL")) {


                setUserHand(getDeck());
                setUserHand(getDeck());

                System.out.println("The user had is " + getUserHand().get(0).toString() + ", " + getUserHand().get(1).toString());
                System.out.println();


                userScore = playGame.score(getUserHand());

                System.out.println("User Score is " + userScore);
                setCardNum();


                System.out.println("The card Number is  " + getCardNum());


                if (getUserHand().get(0).toString().substring(0, 1).equals("1")) {
                    component.showHand(getCardNum(), getUserHand().get(0).toString().substring(0, 2), getUserHand().get(0).toString().substring(2, 3));
                } else {
                    component.showHand(getCardNum(), getUserHand().get(0).toString().substring(0, 1), getUserHand().get(0).toString().substring(1, 2));
                }


                setCardNum();


                if (getUserHand().get(1).toString().substring(0, 1).equals("1")) {
                    component.showHand(getCardNum(), getUserHand().get(1).toString().substring(0, 2), getUserHand().get(1).toString().substring(2, 3));
                } else {
                    component.showHand(getCardNum(), getUserHand().get(1).toString().substring(0, 1), getUserHand().get(1).toString().substring(1, 2));
                }


                try {
                    checkScore(userScore);
                } catch (Exception e) {

                }

            }


            if (event.getActionCommand().equals("Hit Me")) {

                setCardNum();

                System.out.println("The value of cardNum is " + getCardNum());

                //dealing a another card
                setUserHand(getDeck());


                userScore = playGame.score(getUserHand());


                System.out.println("The user had is " + getUserHand().get(0).toString() + ", " + getUserHand().get(1).toString() + ", " +
                        getUserHand().get(2).toString());

                System.out.println("User score is NOW " + userScore);
                System.out.println();

                if (getCardNum() == 3) {
                    if (getUserHand().get(2).toString().substring(0, 1).equals("1")) {
                        component.showHand(getCardNum(), getUserHand().get(2).toString().substring(0, 2), getUserHand().get(2).toString().substring(2, 3));
                    } else {
                        component.showHand(getCardNum(), getUserHand().get(2).toString().substring(0, 1), getUserHand().get(2).toString().substring(1, 2));
                    }


                    System.out.println("The user had is " + getUserHand().get(0) + ", " + getUserHand().get(1) + ", " + getUserHand().get(2));
                    System.out.println();
                }


                if (getCardNum() == 4) {

                    if (getUserHand().get(3).toString().substring(0, 1).equals("1")) {
                        component.showHand(getCardNum(), getUserHand().get(3).toString().substring(0, 2), getUserHand().get(3).toString().substring(2, 3));
                    } else {
                        component.showHand(getCardNum(), getUserHand().get(3).toString().substring(0, 1), getUserHand().get(3).toString().substring(1, 2));
                    }

                    System.out.println("The user had is " + getUserHand().get(0) + ", " + getUserHand().get(1) + ", " + getUserHand().get(2) + ", " + getUserHand().get(3));
                    System.out.println();

                }


                if (getCardNum() == 5) {

                    if (getUserHand().get(4).toString().substring(0, 1).equals("1")) {
                        component.showHand(getCardNum(), getUserHand().get(4).toString().substring(0, 2), getUserHand().get(4).toString().substring(2, 3));
                    } else {
                        component.showHand(getCardNum(), getUserHand().get(4).toString().substring(0, 1), getUserHand().get(4).toString().substring(1, 2));
                    }


                    System.out.println("The user had is " + getUserHand().get(0) + ", " + getUserHand().get(1) + ", " + getUserHand().get(2) + ", " + getUserHand().get(3) +
                            ", " + getUserHand().get(4));
                    System.out.println();


                }

                if (getCardNum() == 6) {

                    if (getUserHand().get(5).toString().substring(0, 1).equals("1")) {
                        component.showHand(getCardNum(), getUserHand().get(5).toString().substring(0, 2), getUserHand().get(5).toString().substring(2, 3));
                    } else {
                        component.showHand(getCardNum(), getUserHand().get(5).toString().substring(0, 1), getUserHand().get(5).toString().substring(1, 2));
                    }

                    System.out.println("The user had is " + getUserHand().get(0) + ", " + getUserHand().get(1) + ", " + getUserHand().get(2) + ", " + getUserHand().get(3) +
                            ", " + getUserHand().get(4) + ", " + getUserHand().get(5));


                }


            }


            if (event.getActionCommand().equals("Stay")) {
                //Deal gets

                //System.out.println("WE ARE IN HERE");

                setDealerHand(getDeck());
                setDealerHand(getDeck());

                System.out.println("The DEALER hand is " + getDealerHand().get(0).toString() + ", " + getDealerHand().get(1).toString());
                System.out.println();


                setDealerCardNum();
                System.out.println("The value of cardNum is " + dealerCardNum);


                if (getDealerHand().get(0).toString().substring(0, 1).equals("1")) {
                    componentDealer.showHand(getDealerCardNum(), getDealerHand().get(0).toString().substring(0, 2), getDealerHand().get(0).toString().substring(2, 3));
                } else {
                    componentDealer.showHand(getDealerCardNum(), getDealerHand().get(0).toString().substring(0, 1), getDealerHand().get(0).toString().substring(1, 2));
                }


                setDealerCardNum();
                System.out.println("The value of cardNum is " + dealerCardNum);

                if (getDealerHand().get(1).toString().substring(0, 1).equals("1")) {
                    componentDealer.showHand(getDealerCardNum(), getDealerHand().get(1).toString().substring(0, 2), getDealerHand().get(1).toString().substring(2, 3));
                } else {
                    componentDealer.showHand(getDealerCardNum(), getDealerHand().get(1).toString().substring(0, 1), getDealerHand().get(1).toString().substring(1, 2));
                }


                dScore = playGame.score(getDealerHand());
                System.out.println("The dealer score is " + dScore);


                //dealer is playing until get gets at least 17
                while (dScore < 17) {

                    setDealerHand(getDeck());
                    setDealerCardNum();
                    System.out.println("The value of cardNum is " + dealerCardNum);

                    if (getDealerCardNum() == 3) {

                        if (getDealerHand().get(2).toString().substring(0, 1).equals("1")) {
                            componentDealer.showHand(getDealerCardNum(), getDealerHand().get(2).toString().substring(0, 2), getDealerHand().get(2).toString().substring(2, 3));
                        } else {
                            componentDealer.showHand(getDealerCardNum(), getDealerHand().get(2).toString().substring(0, 1), getDealerHand().get(2).toString().substring(1, 2));
                        }

                    }

                    if (getDealerCardNum() == 4) {

                        if (getDealerHand().get(3).toString().substring(0, 1).equals("1")) {
                            componentDealer.showHand(getDealerCardNum(), getDealerHand().get(3).toString().substring(0, 2), getDealerHand().get(3).toString().substring(2, 3));
                        } else {
                            componentDealer.showHand(getDealerCardNum(), getDealerHand().get(3).toString().substring(0, 1), getDealerHand().get(3).toString().substring(1, 2));
                        }

                    }


                    if (getDealerCardNum() == 5) {

                        if (getDealerHand().get(4).toString().substring(0, 1).equals("1")) {
                            componentDealer.showHand(getDealerCardNum(), getDealerHand().get(4).toString().substring(0, 2), getDealerHand().get(4).toString().substring(2, 3));
                        } else {
                            componentDealer.showHand(getDealerCardNum(), getDealerHand().get(4).toString().substring(0, 1), getDealerHand().get(4).toString().substring(1, 2));
                        }

                    }

                    if (getDealerCardNum() == 6) {

                        if (getDealerHand().get(5).toString().substring(0, 1).equals("1")) {
                            componentDealer.showHand(getDealerCardNum(), getDealerHand().get(5).toString().substring(0, 2), getDealerHand().get(3).toString().substring(2, 3));
                        } else {
                            componentDealer.showHand(getDealerCardNum(), getDealerHand().get(5).toString().substring(0, 1), getDealerHand().get(3).toString().substring(1, 2));
                        }

                    }


                    dScore = playGame.score(getDealerHand());

                }


                if (dScore >= 17 && dScore < 21) {
                    JOptionPane.showMessageDialog(null, "The dealer stays !!!!");


                    if (dScore > userScore) {
                        dScore = 21;
                    } else {
                        dScore = 22;
                    }


                }

                if (dScore == 21) {

                    JOptionPane.showMessageDialog(null, "The dealer won !!!!");

                    //resetting dealer info
                    dScore = 0;
                    resetCardNum();
                    dealerCardNum = 0;
                    dealerHand.clear();

                    //resetting user info
                    userScore = 22;
                    try {
                        checkScore(userScore);
                    } catch (Exception e) {

                    }

                }

                if (dScore > 21) {

                    JOptionPane.showMessageDialog(null, "The dealer Lost !!!!");

                    //reseting dealer info
                    dealerCardNum = 0;
                    dScore = 0;
                    resetCardNum();
                    dealerHand.clear();


                    //resetting user info
                    userScore = 21;
                    try {
                        checkScore(userScore);
                    } catch (Exception e) {

                    }

                }

            }


        }

    }


    private void checkScore(int score) throws IOException {

        if (score == 21) {
            JOptionPane.showMessageDialog(null, "Congratulations you WON!!!!");

            money = money + betAmount;
            scoreLabel.setText("User Score: $" + (money));
            betAmount = 0;
            userHand.clear();

            this.repaint();


            betLabel.setText("Bet Amount: $" + betAmount);
            JOptionPane.showMessageDialog(null, "You have $" + money);
            JOptionPane.showMessageDialog(null, "Place your bets, then hit DEAL");


        } else if (score > 21) {

            JOptionPane.showMessageDialog(null, "Your lost!");

            money = money - betAmount;
            scoreLabel.setText("User Score: $" + (money));
            betAmount = 0;

            resetCardNum();
            cardNum = 0;

            userHand.clear();
            this.repaint();


            betLabel.setText("Bet Amount: $" + betAmount);
            JOptionPane.showMessageDialog(null, "You still have $" + money + " left...");
            JOptionPane.showMessageDialog(null, "Place your bets, then hit DEAL");


        }
    }


    private void createPanel() throws IOException {

        //top panel set up
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        lpane.setBounds(0, 0, 700, 600);


        //blackJack background
        File file = new File("imgs/background.jpg");
        BufferedImage image = ImageIO.read(file);

        imageLabel1 = new JLabel(new ImageIcon(image));

        Image scaled = image.getScaledInstance(700, 600, Image.SCALE_DEFAULT);
        imageLabel1 = new JLabel(new ImageIcon(scaled));

        JPanel scorePanel = new JPanel();

        scorePanel.add(imageLabel1);
        scorePanel.setBounds(0, 0, 700, 600);
        scorePanel.setOpaque(true);


        //User HAND PANEL
        cardPanel.setLayout(new GridLayout(1, 2));
        // cardPanel.add(cardLabel1);
        // cardPanel.add(cardLabel2);
        cardPanel.setBounds(150, 344, 600, 200);
        cardPanel.setOpaque(false);
        component = new Card("F", "S");
        cardPanel.add(component);

        /////////////////////////

        //DEALER HAND PANEL
        cardPanelDealer.setLayout(new GridLayout(1, 2));

        cardPanelDealer.setBounds(170, 100, 600, 200);
        cardPanelDealer.setOpaque(false);
        componentDealer = new Card("F", "S");
        cardPanelDealer.add(componentDealer);


        //SCORE panel

        JPanel sPanel = new JPanel();
        sPanel.setLayout(new BorderLayout());
        sPanel.setBounds(0, 0, 250, 60);
        sPanel.setOpaque(true);


        scoreLabel.setText("User Score: $" + money);
        betLabel.setText("Bet Amount: $" + 0);


        JPanel chipPanel = new JPanel();
        chipPanel.setLayout(new GridLayout(1, 5));
        chipPanel.add(dollarChip);
        chipPanel.add(fiveDollarChip);
        chipPanel.add(tenDollarChip);
        chipPanel.add(twentyFiveDollarChip);
        chipPanel.add(fiftyDollarChip);

        sPanel.add(scoreLabel, BorderLayout.NORTH);
        sPanel.add(betLabel, BorderLayout.CENTER);
        sPanel.add(chipPanel, BorderLayout.SOUTH);


        //button set up

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        JPanel buttonPanelW = new JPanel();
        buttonPanelW.setLayout(new GridLayout(2, 1));
        gamePanel.add(buttonPanelW, BorderLayout.WEST);

        buttonPanelW.add(hit_button);
        buttonPanelW.add(stay_button);
        gamePanel.setBounds(100, 500, 85, 80);

        /////////////////////////
        //start button set up
        JPanel startPanel = new JPanel();
        startPanel.add(start_button);
        startPanel.setBounds(280, 550, 70, 30);
        //////////////////////////////


        lpane.add(scorePanel, new Integer(0), 0);
        lpane.add(cardPanel, new Integer(1), 0);
        lpane.add(gamePanel, new Integer(2), 0);
        lpane.add(startPanel, new Integer(3), 0);
        lpane.add(cardPanelDealer, new Integer(4), 0);
        lpane.add(sPanel, new Integer(5), 0);


        add(lpane, BorderLayout.CENTER);
    }
}






