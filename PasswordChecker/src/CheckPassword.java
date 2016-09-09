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
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    public static final String VALID = "Valid password.";
    public static final String INVALID = "This is not a valid password.";

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.println("Passwords must be");
        out.println("-At least 6 characters long");
        out.println("-Contain an uppercase letter");
        out.println("-Contain a lowercase letter");
        out.println("-Contains digits");
        String password = getPassword(in, out);
        checkPassword(password, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

    /**
     * Gets password from user input.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return password string
     */
    private static String getPassword(SimpleReader in, SimpleWriter out) {
        out.print("Enter a password: ");
        String password = in.nextLine();
        return password;
    }

    /**
     * Checks whether the given String satisfies the CSE department criteria for
     * a valid password. Prints an appropriate message to the given output
     * stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {
        if (s.length() >= 6) {
            if (containsUpperCaseLetter(s)) {
                if (containsLowerCaseLetter(s)) {
                    if (containsDigit(s)) {
                        out.print(VALID);
                    }
                }
            }
        } else {
            out.println(INVALID);
        }
    }

    private static boolean containsUpperCaseLetter(String s) {
        boolean contains = false;
        for (int i = 0; i < s.length() - 1; i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                contains = true;
            }
        }
        return contains;
    }

    private static boolean containsLowerCaseLetter(String s) {
        boolean contains = false;
        for (int i = 0; i < s.length() - 1; i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                contains = true;
            }
        }
        return contains;
    }

    private static boolean containsDigit(String s) {
        boolean contains = false;
        for (int i = 0; i < s.length() - 1; i++) {
            if (Character.isDigit(s.charAt(i))) {
                contains = true;
            }
        }
        return contains;
    }
}
