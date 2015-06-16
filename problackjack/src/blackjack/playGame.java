

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Created by dsvid88 on 5/13/15.
 */
public class playGame {

    public static void main(String[] args) throws IOException {

        blackJackUI newGame = new blackJackUI();
        newGame.setDeck(newGame.shuffleDeck());

        JOptionPane.showMessageDialog(null, "Place your bets, then hit DEAL");
    }


    //methods that keeps track of scores
    public static int score (ArrayList<Card> hand) {

        int total_points = 0;


        System.out.println("The hand is : ");
        System.out.println();

        int i = 0;
        while ( i < hand.size()){
            System.out.println(hand.get(i).toString().charAt(0));
            i++;
        }


            int h = 0;
            while (h < hand.size()) {

                if (hand.get(h).toString().charAt(0) == '1' || hand.get(h).toString().charAt(0) == 'J' ||
                        hand.get(h).toString().charAt(0) == 'Q'  || hand.get(h).toString().charAt(0) == 'K') {
                    total_points = total_points + 10;
                }
                else if (hand.get(h).toString().charAt(0) == 'A') {
                    total_points = total_points + 11;
                }
                else{

                    total_points = total_points + Integer.parseInt(hand.get(h).toString().substring(0, 1));
                }

                h++;
            }

        return total_points;
    }



    //method that deals cards
    public static Card dealCards(ArrayList<Card> deck){

        Card topCard = deck.remove(0);
        return topCard;
    }

    //method that keep track of scores
    public static ArrayList<Card> makeDeck() {

        ArrayList<Card> newDeck = new ArrayList<>();
        String[] suit_array = { "H", "D", "S", "C"};
        String[] face_array = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (int f = 0; f < 13; f++) {
            for (int s = 0; s < 4; s++) {
                newDeck.add(new Card(face_array[f], suit_array[s]));
            }
        }
        return newDeck;
    }


}
