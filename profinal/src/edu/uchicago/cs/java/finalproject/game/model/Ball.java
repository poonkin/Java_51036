package edu.uchicago.cs.java.finalproject.game.model;
import java.awt.*;

/**
 * Created by dsvid88 on 5/23/15.
 */
public class Ball extends Sprite{

    Color color;
    int diameter;
    long delay;
    private int x;
    private int y;
    private int vx;
    private int vy;

    //constructor
    public Ball(String ballcolor, int xvelocity, int yvelocity) {
        if(ballcolor == "red") {
            color = Color.red;
        }
        else if(ballcolor == "blue") {
            color = Color.blue;
        }
        else if(ballcolor == "black") {
            color = Color.black;
        }
        else if(ballcolor == "cyan") {
            color = Color.cyan;
        }
        else if(ballcolor == "darkGray") {
            color = Color.darkGray;
        }
        else if(ballcolor == "gray") {
            color = Color.gray;
        }
        else if(ballcolor == "green") {
            color = Color.green;
        }
        else if(ballcolor == "yellow") {
            color = Color.yellow;
        }
        else if(ballcolor == "lightGray") {
            color = Color.lightGray;
        }
        else if(ballcolor == "magenta") {
            color = Color.magenta;
        }
        else if(ballcolor == "orange") {
            color = Color.orange;
        }
        else if(ballcolor == "pink") {
            color = Color.pink;
        }
        else if(ballcolor == "white") {
            color = Color.white;
        }
        diameter = 30;
        delay = 40;
        x = 1;
        y = 1;
        vx = xvelocity;
        vy = yvelocity;
    }

   public void move() {
        if(x + vx < 0 || x + diameter + vx > 1100) {
            vx *= -1;
        }
        if(y + vy < 0 || y + diameter + vy > 900) {
            vy *= -1;
        }
        x += vx;
        y += vy;
    }

    protected void paintComponent(Graphics g) {
     //   super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillOval(x,y,30,30); //adds color to circle
        g.setColor(Color.black);
        g2.drawOval(x,y,30,30); //draws circle
    }



}
