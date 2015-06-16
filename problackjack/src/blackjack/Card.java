import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Created by dsvid88 on 5/13/15.
 */
public class Card  extends JComponent{

   private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 600;

    private JLabel userScore;
    private JLabel computerScore;
    private JLabel turnTotal;
    private JLabel cardTotalLabel;

    private JLabel imageLabel1, getImageLabel2, cardLabel1, cardLabel2, cardLabel3, cardLabel4, cardLabel5, cardLabel6, cardLabel7;


    private JButton hit_button, stay_button, clear_button, start_button;

    private int userTotal = 0;
    private int computerTotal = 0;
    private int cartTotal = 0;


    //instance members
    private String Face;
    private String Suit;


    //constructor
    public Card(String face, String suit) {
        this.Face = face;
        this.Suit = suit;
    }



    public String toString() {
        return String.valueOf(this.Face + this.Suit);
    }



    //getters and setters
    public String getFace() {
        return this.Face;
    }

    public String getSuit() {
        return this.Suit;
    }

    public void setSuit(String suit) {
        this.Suit = suit;
    }

    public void setFace(String face) {
        this.Face = face;
    }

    Card card1, card2, card3, card4, card5, card6;
    int card = 0;

    public void paintComponent(Graphics g) {


        if (card == 1) {
            try {

                File file4 = new File("imgs/" + card1.getFace().toString() + card1.getSuit().toString() + ".jpg");

                BufferedImage image4 = ImageIO.read(file4);
                cardLabel3 = new JLabel(new ImageIcon(image4));

                Image scaled4 = image4.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel3 = new JLabel(new ImageIcon(scaled4));

                g.drawImage(scaled4, 0, 0, null);


            } catch (Exception e) {

            }
        } else if (card == 2) {
            try {


                File file4 = new File("imgs/" + card1.getFace().toString() + card1.getSuit().toString() + ".jpg");
                File file5 = new File("imgs/" + card2.getFace().toString() + card2.getSuit().toString() + ".jpg");

                BufferedImage image4 = ImageIO.read(file4);
                cardLabel3 = new JLabel(new ImageIcon(image4));
                BufferedImage image5 = ImageIO.read(file5);
                cardLabel4 = new JLabel(new ImageIcon(image5));

                Image scaled4 = image4.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel3 = new JLabel(new ImageIcon(scaled4));
                Image scaled5 = image5.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel4 = new JLabel(new ImageIcon(scaled5));

                g.drawImage(scaled4, 0, 0, null);
                g.drawImage(scaled5, 90, 0, null);



            } catch (Exception e) {

            }
        } else if (card == 3) {
            try {

                File file4 = new File("imgs/" + card1.getFace().toString() + card1.getSuit().toString() + ".jpg");
                File file5 = new File("imgs/" + card2.getFace().toString() + card2.getSuit().toString() + ".jpg");
                File file6 = new File("imgs/" + card3.getFace().toString() + card3.getSuit().toString() + ".jpg");

                BufferedImage image4 = ImageIO.read(file4);
                cardLabel3 = new JLabel(new ImageIcon(image4));
                BufferedImage image5 = ImageIO.read(file5);
                cardLabel4 = new JLabel(new ImageIcon(image5));

                BufferedImage image6 = ImageIO.read(file6);
                cardLabel5 = new JLabel(new ImageIcon(image6));


                Image scaled4 = image4.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel3 = new JLabel(new ImageIcon(scaled4));
                Image scaled5 = image5.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel4 = new JLabel(new ImageIcon(scaled5));

                Image scaled6 = image6.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel5 = new JLabel(new ImageIcon(scaled6));

                g.drawImage(scaled4, 0, 0, null);
                g.drawImage(scaled5, 90, 0, null);
                g.drawImage(scaled6, 180, 0, null);



            } catch (Exception e) {

            }
        } else if (card == 4) {
            try {

                File file4 = new File("imgs/" + card1.getFace().toString() + card1.getSuit().toString() + ".jpg");
                File file5 = new File("imgs/" + card2.getFace().toString() + card2.getSuit().toString() + ".jpg");
                File file6 = new File("imgs/" + card3.getFace().toString() + card3.getSuit().toString() + ".jpg");
                File file7 = new File("imgs/" + card4.getFace().toString() + card4.getSuit().toString() + ".jpg");


                BufferedImage image4 = ImageIO.read(file4);
                cardLabel3 = new JLabel(new ImageIcon(image4));
                BufferedImage image5 = ImageIO.read(file5);
                cardLabel4 = new JLabel(new ImageIcon(image5));
                BufferedImage image6 = ImageIO.read(file6);
                cardLabel5 = new JLabel(new ImageIcon(image6));
                BufferedImage image7 = ImageIO.read(file7);
                cardLabel6 = new JLabel(new ImageIcon(image7));


                Image scaled4 = image4.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel3 = new JLabel(new ImageIcon(scaled4));
                Image scaled5 = image5.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel4 = new JLabel(new ImageIcon(scaled5));
                Image scaled6 = image6.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel5 = new JLabel(new ImageIcon(scaled6));
                Image scaled7 = image7.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel6 = new JLabel(new ImageIcon(scaled7));


                g.drawImage(scaled4, 0, 0, null);
                g.drawImage(scaled5, 90, 0, null);
                g.drawImage(scaled6, 180, 0, null);
                g.drawImage(scaled7, 270, 0, null);

            } catch (Exception e) {

            }
        } else if (card == 5) {
            try {

                File file4 = new File("imgs/" + card1.getFace().toString() + card1.getSuit().toString() + ".jpg");
                File file5 = new File("imgs/" + card2.getFace().toString() + card2.getSuit().toString() + ".jpg");
                File file6 = new File("imgs/" + card3.getFace().toString() + card3.getSuit().toString() + ".jpg");
                File file7 = new File("imgs/" + card4.getFace().toString() + card4.getSuit().toString() + ".jpg");
                File file8 = new File("imgs/" + card5.getFace().toString() + card5.getSuit().toString() + ".jpg");


                BufferedImage image4 = ImageIO.read(file4);
                cardLabel3 = new JLabel(new ImageIcon(image4));
                BufferedImage image5 = ImageIO.read(file5);
                cardLabel4 = new JLabel(new ImageIcon(image5));
                BufferedImage image6 = ImageIO.read(file6);
                cardLabel5 = new JLabel(new ImageIcon(image6));
                BufferedImage image7 = ImageIO.read(file7);
                cardLabel6 = new JLabel(new ImageIcon(image7));
                BufferedImage image8 = ImageIO.read(file8);
                cardLabel7 = new JLabel(new ImageIcon(image8));


                Image scaled4 = image4.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel3 = new JLabel(new ImageIcon(scaled4));
                Image scaled5 = image5.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel4 = new JLabel(new ImageIcon(scaled5));
                Image scaled6 = image6.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel5 = new JLabel(new ImageIcon(scaled6));
                Image scaled7 = image7.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel6 = new JLabel(new ImageIcon(scaled7));
                Image scaled8 = image8.getScaledInstance(80, 120, Image.SCALE_DEFAULT);
                cardLabel7 = new JLabel(new ImageIcon(scaled8));


                g.drawImage(scaled4, 0, 0, null);
                g.drawImage(scaled5, 90, 0, null);
                g.drawImage(scaled6, 180, 0, null);
                g.drawImage(scaled7, 270, 0, null);
                g.drawImage(scaled8, 360, 0, null);

            } catch (Exception e) {

            }
        }

    }





    public void showHand(int cardNum, String Face, String Suit){

        if ( cardNum==1) {
            this.card = 1;
            card1 = new Card(Face, Suit);


        }

        else if (cardNum == 2){
            this.card = 2;
           card2 = new Card(Face, Suit);

        }
        else if (cardNum == 3){
            card = 3;
            card3 = new Card(Face, Suit);

        }

        else if (cardNum == 4){
            card = 4;
            card4 = new Card(Face, Suit);

        }

        else if (cardNum == 5){
            card = 5;
            card5 = new Card(Face, Suit);

        }


        else if (cardNum == 6){
            card = 6;
            card6 = new Card(Face, Suit);


        }


        repaint();
    }


}
