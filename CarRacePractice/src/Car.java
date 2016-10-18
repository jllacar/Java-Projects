/**
 * Playing around with objects.
 *
 * @author JL Lacar
 *
 */

public class Car {

    private int speed;

    private String driver;

    /*
     * Blank constructor
     */
    public Car() {
        this.speed = 0;
        this.driver = "";
    }

    /*
     * Overloaded constructor option
     */
    public Car(int speed, String driver) {
        this.speed = speed;
        this.driver = driver;
    }

    /*
     * Methods relating to speed
     */
    public int setSpeed(int speed) {
        return this.speed = speed;
    }

    public int speed() {
        return this.speed;
    }

    /*
     * Methods related to driver
     */
    public String setDriver(String name) {
        return this.driver = name;
    }

    public String getDriverName() {
        return this.driver;
    }

    public boolean wins(int speedOne, int speedTwo) {
        boolean win = false;
        if (speedOne > speedTwo) {
            win = true;
        }
        return win;
    }
}
