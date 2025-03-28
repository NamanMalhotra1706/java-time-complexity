public class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] operationCounts = {1_000, 10_000, 1_000_000}; // Different sizes

        System.out.println("Operations | String (O(N²)) Time (ms) | StringBuilder (O(N)) Time (ms) | StringBuffer (O(N)) Time (ms)");
        System.out.println("--------------------------------------------------------------------------------------------------");

        for (int n : operationCounts) {
            long stringTime = measureStringConcatenation(n);
            long stringBuilderTime = measureStringBuilderConcatenation(n);
            long stringBufferTime = measureStringBufferConcatenation(n);

            System.out.printf("%10d | %25d | %30d | %25d%n",
                    n, stringTime, stringBuilderTime, stringBufferTime);
        }
    }

    // Using String (Inefficient O(N²))
    private static long measureStringConcatenation(int n) {
        long startTime = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a";
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }

    // Using StringBuilder (Efficient O(N))
    private static long measureStringBuilderConcatenation(int n) {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }

    // Using StringBuffer (Efficient O(N), Thread-Safe)
    private static long measureStringBufferConcatenation(int n) {
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return (System.nanoTime() - startTime) / 1_000_000;
    }
}
