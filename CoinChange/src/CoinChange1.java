import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author JL Lacar
 *
 */
public final class CoinChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange1() {
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

        askAmount(in, out);

        in.close();
        out.close();
    }

    public static int askAmount(SimpleReader in, SimpleWriter out) {
        out.print("Enter an amount (in cents) to make change: ");
        int amount = in.nextInteger();
        return amount;

    }

    public static int makeChange(int[] coinType, int n, int amount) {
        int change = amount % coinType[n];
        return change;
    }
}
