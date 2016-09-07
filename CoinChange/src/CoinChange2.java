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
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
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

        int amount = askAmount(in, out);
        int[] denominations = { 100, 50, 25, 10, 5, 1 };
        int[] coinCount = getCoinCount(denominations, amount);
        printCount(out, coinCount);
        in.close();
        out.close();
    }

    public static int askAmount(SimpleReader in, SimpleWriter out) {
        out.print("Enter an amount (in cents) to make change: ");
        int amount = in.nextInteger();
        return amount;
    }

    public static int[] getCoinCount(int[] a, int amount) {
        int[] coinCount = new int[6];
        coinCount[0] = amount / a[0];
        for (int n = 1; n < a.length - 1; n++) {
            coinCount[n] = (amount % a[n - 1]) / a[n];
        }
        return coinCount;
    }

    public static void printCount(SimpleWriter out, int[] a) {
        out.println("Dollars: " + a[0]);
        out.println("Half dollars: " + a[1]);
        out.println("Quarters: " + a[2]);
        out.println("Dimes: " + a[3]);
        out.println("Nickels: " + a[4]);
        out.println("Pennies: " + a[5]);
    }

}
