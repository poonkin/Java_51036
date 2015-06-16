package P12_8;

import java.util.ArrayList;

/**
 * Created by dsvid88 on 5/7/15.
 */

public class VendingMachine {

    private ArrayList<Snack> snacks;
    private ArrayList<Coin> coins;

    public VendingMachine() {
        this.snacks = new ArrayList<Snack>();
        this.coins = new ArrayList<Coin>();
    }

    public void addSnacks(String aSnack, double price, int quant) {
        Snack s = new Snack(aSnack, price, quant);
        snacks.add(s);
    }

    public void addCoins(String aName, double value, int quant) {
        Coin c = new Coin(aName, value, quant);
        coins.add(c);
    }

    public void getSnackCount() {

        int i = 0;
        while (i < snacks.size()) {
            System.out.print(snacks.get(i).getDescription() + ", ");
            System.out.print(snacks.get(i).getPrice() + ", ");
            System.out.println(snacks.get(i).getQuant());
            i = i + 1;
        }
    }

    public void getCoinCount() {

        int i = 0;
        while (i < coins.size()) {
            System.out.print(coins.get(i).getName() + ", ");
            System.out.print(coins.get(i).getValue() + ", ");
            System.out.println(coins.get(i).getQuant());
            i = i + 1;
        }

    }

    public void giveChange(String snackName, double snackPrice, double valueInserted) {

        double change = valueInserted - snackPrice;

        int quarters, nickles, dimes, pennies;
        double remainder;

        if (change >= .25) {
            quarters = (int) (change / .25);
            coins.get(3).setQuant(-1 * quarters);
            remainder = change - quarters * .25;
        } else if (change >= .10) {
            dimes = (int) (change / .10);
            coins.get(2).setQuant(-1 * dimes);
            remainder = change - dimes * .10;
        } else if (change >= .05) {

            nickles = (int) (change / .05);
            coins.get(1).setQuant(-1 * nickles);
            remainder = change - nickles * .05;
            pennies = (int) remainder;

        } else {
            pennies = (int) change;
            coins.get(0).setQuant(-1 * pennies);
        }

    }

    public void buySnack(String snackName, int numQuarters, int numDimes, int numNickles, int numPennies) {

        double valueInserted = numQuarters * .25 + numDimes * .10 + numNickles * .05 + numPennies * .01;

        int i = 0;
        while (i < snacks.size()) {
            //adjusting the number of snacks in the vending machine
            if (snackName.equals(snacks.get(i).getDescription()) && valueInserted >= snacks.get(i).getPrice() && valueInserted <= 2.00) {
                System.out.println("You bought " + snacks.get(i).getDescription());
                snacks.get(i).setQuant();
                coins.get(0).setQuant(numPennies);
                coins.get(1).setQuant(numNickles);
                coins.get(2).setQuant(numDimes);
                coins.get(3).setQuant(numQuarters);

                giveChange(snacks.get(i).getDescription(), snacks.get(i).getPrice(), valueInserted);
                break;

            } else if (snackName.equals(snacks.get(i).getDescription()) && valueInserted < snacks.get(i).getPrice()) {
                System.out.println(snacks.get(i).getDescription() + " costs " + snacks.get(i).getPrice() + ", but " +
                        " you inserted only " + valueInserted + " - that's NOT enough!");
            } else if (valueInserted > 2.00) {
                System.out.println("You inserted too much money, please insert less then 2.00 dollars");
                break;
            }


            i = i + 1;

            if (i == snacks.size()) {
                System.out.println("The vending machine does not sell " + snackName + " please take back your change");
                break;
            }

        }

    }//end of buySnack method


    //restocking the vending machine
    public void reStock() {

        int i = 0;
        while (i < snacks.size()) {

            if (snacks.get(i).getQuant() < 10) {
                snacks.get(i).reStock();
            }
            i = i + 1;
        }
    }

    //resetting coins
    public void removeCoins() {

        int j = 0;
        while (j < coins.size()) {
            if (coins.get(j).getQuant() != 20) {
                coins.get(j).resetQuant();
            }
            j = j + 1;
        }
    }
}



