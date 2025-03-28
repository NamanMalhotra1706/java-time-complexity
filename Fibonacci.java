public class Fibonacci {
    public static void main(String[] args) {
        int n = 30; // Adjust for testing

        // Measure time for Recursive Fibonacci
        long startRecursive = System.nanoTime();
        int fibRecursive = fibonacciRecursive(n);
        long endRecursive = System.nanoTime();
        long timeRecursive = (endRecursive - startRecursive) / 1_000_000; // Convert ns to ms

        // Measure time for Iterative Fibonacci
        long startIterative = System.nanoTime();
        int fibIterative = fibonacciIterative(n);
        long endIterative = System.nanoTime();
        long timeIterative = (endIterative - startIterative) / 1_000_000; // Convert ns to ms

        // Print results
        System.out.println("Fibonacci(" + n + ") Recursive: " + fibRecursive + " | Time: " + timeRecursive + " ms");
        System.out.println("Fibonacci(" + n + ") Iterative: " + fibIterative + " | Time: " + timeIterative + " ms");
    }

    // Recursive Fibonacci (Exponential Time Complexity O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time Complexity O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

}
