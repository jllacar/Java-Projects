import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program uses nested for loops to optimize exponent values of the de
 * Jager formula.
 *
 * @author J.L. Lacar
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * Gets desired value of mu.
     *
     * @param in
     * @param out
     * @return mu
     */
    public static double getMu(SimpleReader in, SimpleWriter out) {
        out.print("Enter a value for mu: ");
        double mu = in.nextDouble();
        return mu;
    }

    /**
     * Method that calculates optimized exponents and prints them, the formula
     * value, and percent error.
     *
     * @param w
     * @param x
     * @param y
     * @param z
     * @param mu
     * @param in
     * @param out
     */
    public static void calculateJager(double w, double x, double y, double z,
            double mu, SimpleReader in, SimpleWriter out) {
        double[] jager = { -5, -4, -3, -2, -1, -(1 / 2), -(1 / 3), -(1 / 4), 0,
                (1 / 4), (1 / 3), (1 / 2), 1, 2, 3, 4, 5 };
        double bestEstimate = 0, currentEstimate, bestA = 1, bestB = 1,
                bestC = 1, bestD = 1;

        for (int i = 0; i < jager.length; i++) {
            double a = jager[i];
            for (int j = 0; j < jager.length; j++) {
                double b = jager[j];
                for (int k = 0; k < jager.length; k++) {
                    double c = jager[k];
                    for (int l = 0; l < jager.length; l++) {
                        double d = jager[l];
                        currentEstimate = Math.pow(w, a) * Math.pow(x, b)
                                * Math.pow(y, c) * Math.pow(z, d);
                        if (Math.abs(mu - currentEstimate) < Math
                                .abs(mu - bestEstimate)) {
                            bestEstimate = currentEstimate;

                            bestA = a;
                            bestB = b;
                            bestC = c;
                            bestD = d;
                        }
                    }
                }
            }
        }

        double error = percentError(mu, bestEstimate);
        out.println("Optimized exponents: " + bestA + ", " + bestB + ", "
                + bestC + ", " + bestD);
        out.println("Jager formula value: " + bestEstimate);
        out.println("Relative error: " + error);
    }

    /**
     * Calculates percent error.
     *
     * @param a
     * @param b
     * @return error
     */
    public static double percentError(double a, double b) {
        double error = Math.abs(a - b) / a * 100;
        return error;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        double mu = getMu(in, out);
        out.println(
                "Please enter your four personal numbers (must be greater than 1): ");
        out.print("Enter W: ");
        double w = in.nextDouble();
        out.print("Enter X: ");
        double x = in.nextDouble();
        out.print("Enter Y: ");
        double y = in.nextDouble();
        out.print("Enter Z: ");
        double z = in.nextDouble();

        calculateJager(w, x, y, z, mu, in, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
