import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo2() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */

    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();

        /*
         * Create pseudo-random number generator
         */

        /*
         * Estimate percentage of points generated in [0.0,1.0) interval that
         * fall in the [0.0,0.5) subinterval
         */
        double estimate = (100.0 * ptsInSubinterval) / ptsInInterval;
        output.println("Estimate of percentage: " + estimate + "%");
        double area = 4 * (estimate / 100);
        output.println(area);
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        boolean inCircle = true;
        double distance = ((xCoord - 1) * (xCoord - 1))
                + ((1 - yCoord) * (1 - yCoord));
        if (distance > 1.0) {
            inCircle = false;
        }
        return inCircle;
    }

    private static int numberOfPointsInCircle(int n) {
        int ptsInInterval = 0, ptsInSubinterval = 0;

        Random rnd = new Random1L();

        while (ptsInInterval < n) {
            double x = rnd.nextDouble() * 2;
            double y = rnd.nextDouble() * 2;

            ptsInInterval++;

            if (pointIsInCircle(x, y)) {
                ptsInSubinterval++;
            }
        }
        return ptsInSubinterval;
    }

}
