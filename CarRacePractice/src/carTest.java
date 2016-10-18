/**
 * Test the Car object.
 *
 * @author jllacar
 *
 */
public class carTest {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        int speed1 = (int) (Math.random() * 10) + 20;
        int speed2 = (int) (Math.random() * 10) + 20;

        car1.setSpeed(speed1);
        car2.setSpeed(speed2);

        car1.setDriver("Jim");
        car2.setDriver("Pam");

        System.out.println(car1.getDriverName() + "'s speed: " + car1.speed());
        System.out.println(car2.getDriverName() + "'s speed: " + car2.speed());

        if (car1.wins(car1.speed(), car2.speed())) {
            System.out.println(car1.getDriverName() + " wins!");
        } else {
            System.out.println(car2.getDriverName() + " wins!");
        }

    }
}
