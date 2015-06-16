package P10_35;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dsvid88 on 4/30/15.
 */
public class QuickBillFrame extends JFrame {

    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 300;

    private JLabel orderLabel;
    private JTextField orderField;
    private JLabel quantityLabel;
    private JTextField quantityField;
    private JLabel totalLabel;
    private JLabel taxLabel;
    private JLabel grandTotal;
    private JLabel tip;
    private JLabel priceLabel;
    private JTextField priceField;

    private JButton food_button1, food_button2, food_button3, food_button4, food_button5;
    private JButton drink_button1, drink_button2, drink_button3, drink_button4, drink_button5;
    private JButton addItem, clear;

    private double total = 0;
    private double tax = 0;
    private double gTotal = 0;
    private double gratutity = 0;

    public QuickBillFrame() {

        createTextField();
        createButtons();
        createPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("QuickBill");

    }

    private void createTextField() {

        orderLabel = new JLabel("Order: ");
        priceLabel = new JLabel("Price: ");
        quantityLabel = new JLabel("Quantity: ");
        totalLabel = new JLabel("Total:");
        taxLabel = new JLabel("Tax: ");
        grandTotal = new JLabel("GrandTotal: ");
        tip = new JLabel("Gratuity: ");

        final int FIELD_WIDTH = 10;

        orderField = new JTextField(FIELD_WIDTH);
        quantityField = new JTextField(FIELD_WIDTH);
        priceField = new JTextField(FIELD_WIDTH);

    }

    public void createButtons() {

        food_button1 = new JButton("Burger ($4.50)");
        food_button2 = new JButton("French Fries ($3.50)");
        food_button3 = new JButton("Pizza ($2.25)");
        food_button4 = new JButton("Gyro ($5.50)");
        food_button5 = new JButton("Sandwich ($4.50)");

        drink_button1 = new JButton("Soda ($1.50)");
        drink_button2 = new JButton("Beer ($4.50)");
        drink_button3 = new JButton("Coffee ($2.00)");
        drink_button4 = new JButton("Juice ($2.00)");
        drink_button5 = new JButton("Tea ($1.50)");

        addItem = new JButton("Add");
        clear = new JButton("CLEAR");

        ActionListener add_item = new ClickListener();
        addItem.addActionListener(add_item);

        ActionListener clear_itmes = new ClickListener();
        clear.addActionListener(clear_itmes);

        ActionListener food_listener1 = new ClickListener();
        ActionListener food_listener2 = new ClickListener();
        ActionListener food_listener3 = new ClickListener();
        ActionListener food_listener4 = new ClickListener();
        ActionListener food_listener5 = new ClickListener();

        food_button1.addActionListener(food_listener1);
        food_button2.addActionListener(food_listener2);
        food_button3.addActionListener(food_listener3);
        food_button4.addActionListener(food_listener4);
        food_button5.addActionListener(food_listener5);

        ActionListener drink_listener1 = new ClickListener();
        ActionListener drink_listener2 = new ClickListener();
        ActionListener drink_listener3 = new ClickListener();
        ActionListener drink_listener4 = new ClickListener();
        ActionListener drink_listener5 = new ClickListener();

        drink_button1.addActionListener(drink_listener1);
        drink_button2.addActionListener(drink_listener2);
        drink_button3.addActionListener(drink_listener3);
        drink_button4.addActionListener(drink_listener4);
        drink_button5.addActionListener(drink_listener5);

    }


    private void createPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel foodButtonPanel = new JPanel();
        foodButtonPanel.setPreferredSize(new Dimension(600, 100));
        JPanel drinkButtonPanel = new JPanel();
        drinkButtonPanel.setPreferredSize(new Dimension(600, 90));

        JPanel otherItems = new JPanel();
        otherItems.setPreferredSize(new Dimension(600, 100));

        drinkButtonPanel.setLayout(new GridLayout(1, 5));
        foodButtonPanel.setLayout(new GridLayout(1, 5));

        drinkButtonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Drinks"));
        foodButtonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Food"));
        otherItems.setBorder(new TitledBorder(new EtchedBorder(), "Other"));

        //adding food buttons
        foodButtonPanel.add(food_button1);
        foodButtonPanel.add(food_button2);
        foodButtonPanel.add(food_button3);
        foodButtonPanel.add(food_button4);
        foodButtonPanel.add(food_button5);

        //adding drink buttons
        drinkButtonPanel.add(drink_button1);
        drinkButtonPanel.add(drink_button2);
        drinkButtonPanel.add(drink_button3);
        drinkButtonPanel.add(drink_button4);
        drinkButtonPanel.add(drink_button5);

        panel.add(drinkButtonPanel, BorderLayout.NORTH);
        panel.add(foodButtonPanel, BorderLayout.CENTER);

        otherItems.add(orderLabel);
        otherItems.add(orderField);
        otherItems.add(priceLabel);
        otherItems.add(priceField);
        otherItems.add(quantityLabel);
        otherItems.add(quantityField);
        otherItems.add(addItem);
        otherItems.add(clear);
        otherItems.add(totalLabel);
        otherItems.add(taxLabel);
        otherItems.add(grandTotal);
        otherItems.add(tip);

        panel.add(otherItems, BorderLayout.SOUTH);

        add(panel);

    }

    class ClickListener implements ActionListener {
        private int counter = 0;

        public void actionPerformed(ActionEvent event) {
            //checking drinks
            if (event.getActionCommand().equals("Soda ($1.50)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 1.50;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);

            } else if (event.getActionCommand().equals("Beer ($4.50)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 4.50;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);


            } else if (event.getActionCommand().equals("Coffee ($2.00)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 2.00;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);

            } else if (event.getActionCommand().equals("Juice ($2.00)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 2.00;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);

            } else if (event.getActionCommand().equals("Tea ($1.50)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 1.50;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);
            }

            //checking food
            else if (event.getActionCommand().equals("Burger ($4.50)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 4.50;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);

            } else if (event.getActionCommand().equals("French Fries ($3.50)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 3.50;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);

            } else if (event.getActionCommand().equals("Pizza ($2.25)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 2.25;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);

            } else if (event.getActionCommand().equals("Gyro ($5.50)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 5.50;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);


            } else if (event.getActionCommand().equals("Sandwich ($4.50)")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");
                total = total + 4.50;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);

            }

            //checking for other items
            else if (event.getActionCommand().equals("Add")) {
                counter = counter + 1;
                System.out.println(event.getActionCommand() + " was ordered " + counter + " times ");

                double other = Double.parseDouble(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                total = total + other * price;

                tax = Math.round(total * .0875 * 100.0) / 100.0;
                gTotal = total + tax;
                gratutity = Math.round(gTotal * .25 * 100.0) / 100.0;
                totalLabel.setText("Total : " + total);
                taxLabel.setText("Tax: " + tax);
                grandTotal.setText("GrandTotal: " + gTotal);
                tip.setText("Gratuity: " + gratutity);

                orderField.setText("");
                priceField.setText("");
                quantityField.setText("");

            }

            //printing the Bill
            else if (event.getActionCommand().equals("CLEAR")) {
                totalLabel.setText("Total : " + "");
                taxLabel.setText("Tax: " + "");
                grandTotal.setText("GrandTotal: " + "");
                tip.setText("Gratuity: " + "");

                total = 0;
                tax = 0;
                gTotal = 0;
                gratutity = 0;

                orderField.setText("");
                priceField.setText("");
                quantityField.setText("");

            }
        }

    }

}





