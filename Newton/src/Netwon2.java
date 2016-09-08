import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program uses Newton Iteration to calculate square roots.
 *
 * @author JL Lacar
 *
 */
public final class Netwon2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Netwon2() {
    }

    public static final double EPSILON = 0.0001;

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        boolean repeat = true;
        while (repeat) {
            double number = getNumber(in, out);
            out.println("The square root of " + number + " is about: "
                    + sqrt(number));
            out.print("Would you like to calculate another square root?(y/n)");
            String answer = in.nextLine();
            out.println();
            if (!answer.contentEquals("y")) {
                repeat = false;
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

    /**
     * Asks user for number to calculate.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return desired number
     */
    private static double getNumber(SimpleReader in, SimpleWriter out) {
        out.print("Enter a positive double: ");
        double number = in.nextDouble();
        return number;
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r = x;
        /*
         * Since we are dealing with doubles (floating point), we are not
         * dividing by absolute zero which results in this method executing
         * without an error.
         */
        while (Math.abs(r * r - x) / x > (EPSILON * EPSILON)) {
            r = (x / r + r) / 2;
        }
        return r;
    }
}
