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
public final class Hailstone2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone2() {
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
        int count = 1;
        out.print(x + " ");
        while (x != 1) {
            if (x % 2 == 0) {
                x = x / 2;
            } else {
                x = (3 * x) + 1;
            }
            out.print(x + " ");
            count++;
        }
        out.println("\nLength: " + count);
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
        int startValue = getStartValue(out, in);
        generateSeries(startValue, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
