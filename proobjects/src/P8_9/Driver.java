package P8_9;

/**
 * Created by dsvid88 on 4/16/15.
 */
public class Driver {
    public static void main(String[] args) {

        //creating a new combo lock with combinations
        ComboLock myLock = new ComboLock(1, 12, 39);

        //getting info about the lock
        myLock.getCombo();
        System.out.print("\n");
        myLock.getDial();

        //resetting the dial to 0
        myLock.reset();
        myLock.getDial();

        myLock.turnLeft(39);
        myLock.getDial();

        myLock.turnRight(51);
        myLock.getDial();

        myLock.turnLeft(13);
        myLock.getDial();

        System.out.println("Is the lock opened?");
        System.out.println(myLock.open());


    }

}