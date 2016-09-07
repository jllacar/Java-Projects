import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Hailstone4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone4() {
    }

    /**
     * Asks user for a positive starting value for the Hailstone series.
     *
     * @param out
     *            the output stream
     * @param in
     *            the input stream
     */
    private static int getStartValue(SimpleWriter out, SimpleReader in) {
        out.print("Enter a positive starting value: ");
        int startValue = in.nextInteger();
        return startValue;
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int x = n;
        int max = n;
        int count = 1;
        out.print(x + " ");
        while (x != 1) {
            if (x % 2 == 0) {
                x = x / 2;
            } else {
                x = (3 * x) + 1;
            }
            count++;
            out.print(x + " ");

            if (x > max) {
                max = x;
            }
        }
        out.println("\nMax: " + max);
        out.println("Length: " + count);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        boolean repeat = true;
        while (repeat) {
            int startValue = getStartValue(out, in);
            generateSeries(startValue, out);
            out.print(
                    "Do you want to run another series? Type \"y\" to continue:");
            String answer = in.nextLine();
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

}
