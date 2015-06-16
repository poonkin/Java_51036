package P8_9;

import java.lang.Math;

/**
 * Created by dsvid88 on 4/16/15.
 */
public class ComboLock {

    private int secret1;
    private int secret2;
    private int secret3;
    private int dial;
    private boolean s1;
    private boolean s2;
    private boolean s3;

    //creating a locker combo
    public ComboLock(int secret1, int secret2, int secret3) {

        if (0 <= secret1 && secret1 <= 39) {
            this.secret1 = secret1;
            this.s1 = false;
        } else {
            System.out.println("You entered invalid input");
        }

        if (0 <= secret2 && secret2 <= 39) {
            this.secret2 = secret2;
            this.s2 = false;
        } else {
            System.out.println("You entered invalid input");
        }

        if (0 <= secret3 && secret3 <= 39) {
            this.secret3 = secret3;
            this.s3 = false;
        } else {
            System.out.println("You entered invalid input");
        }

        //the dial is set to a random number between 0 and 39
        this.dial = (int) (Math.random() * 40 - 1);
    }

    //keeping track of things
    public void getCombo() {
        System.out.println("The lock combo is " + this.secret1 + ", " + this.secret2 + ", " + this.secret3);
    }

    public void getDial() {
        System.out.println("The dial is set at " + this.dial);
    }

    //resetting dial to zero
    public void reset() {
        this.dial = 0;
    }


    //Im assuming on second and third turns need to be past 0
    public void turnLeft(int ticks) {

        if (this.s1 == false && this.s2 == false) {
            if (ticks > 40) {
                ticks = ticks % 40;
                this.dial = Math.abs(this.dial - (40 - ticks));
            } else {
                this.dial = Math.abs(this.dial - (40 - ticks));
            }

            if (Math.abs(this.dial) == this.secret1) {
                this.s1 = true;
            }
        } else if (s1 == true && s2 == true) {

            if (ticks < Math.abs(this.dial)) {
                System.out.println("You need to pass 0!");
            } else if (ticks > Math.abs(this.dial) && ticks < 40) {
                this.dial = 40 - Math.abs(ticks - this.dial);
                if (this.dial == this.secret3) {
                    this.s3 = true;
                }
            } else if (ticks > 40 && ticks <= (this.dial + 40)) {
                ticks = ticks % 40;
                this.dial = this.dial - ticks;

                if (this.dial == this.secret3) {
                    this.s3 = true;
                }

            } else {
                System.out.println("You did something wrong");
            }

        }
    }

    public void turnRight(int ticks) {

        if (ticks < Math.abs(40 - this.dial)) {
            System.out.println("You need to pass 0!");
        } else if (ticks > 40 && ticks < 80) {
            ticks = ticks % 40;
            this.dial = Math.abs(this.dial) + ticks;
            if (Math.abs(this.dial) == this.secret2) {
                this.s2 = true;
            }
        } else {
            this.dial = ticks - Math.abs(40 - this.dial);
            if (Math.abs(this.dial) == this.secret2) {
                this.s2 = true;
            }
        }
    }

    public boolean open() {
        if (this.s1 == true && this.s2 == true && this.s3 == true) {
            return true;
        } else {
            return false;
        }
    }

}//end of class ComboLock

