import java.util.Scanner;

public class FibonacciSequencer {
    public static void main(String[] args) {
        FibonacciSequencer sequence = new FibonacciSequencer();
        int length = enterSequenceLength();
        sequence.setSequenceLength(length);
        sequence.generate();
        sequence.print();
    }

    private int[] sequence;

    private static int enterSequenceLength() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a length for the sequence: ");
        return keyboard.nextInt();
    }

    private void setSequenceLength(int n) {
        this.sequence = new int[n];
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
            boolean lastOne = i == this.sequence.length - 1;
            String output = (lastOne ? "%d " : "%d, ");
            System.out.printf(output, this.sequence[i]);
        }
    }
}
