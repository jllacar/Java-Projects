import java.util.Scanner;

public class fibonacciSequencer {
    public static void main(String[] args) {
        fibonacciSequencer sequence = new fibonacciSequencer();
        sequence.setSequenceLength();
        sequence.generate();
        sequence.print();
    }

    private int length;
    private int[] sequence;

    private void setSequenceLength() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a length for the sequence: ");
        this.length = keyboard.nextInt();
        this.sequence = new int[this.length];
        keyboard.close();
    }

    private void generate() {
        for (int i = 0; i < this.sequence.length; i++) {
            this.sequence[i] = this.calculateFibonacci(i);
        }

    }

    private int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return this.calculateFibonacci(n - 1)
                    + this.calculateFibonacci(n - 2);
        }
    }

    private void print() {
        for (int i = 0; i < this.sequence.length; i++) {
            boolean reachesLength = i == this.sequence.length - 1;
            String output = (reachesLength ? "%d " : "%d, ");
            System.out.printf(output, this.sequence[i]);
        }
    }
}
