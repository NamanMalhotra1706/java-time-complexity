import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000};  // Different dataset sizes
        Random random = new Random();

        System.out.println("Dataset Size | Linear Search Time (ms) | Binary Search Time (ms)");
        System.out.println("------------------------------------------------------------");

        for (int size : datasetSizes) {
            int[] data = generateRandomArray(size);
            int target = data[random.nextInt(size)];  // Pick a random target from the dataset

            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            Arrays.sort(data);

            startTime = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.printf("%12d | %21.3f | %22.3f%n",
                    size, linearTime / 1e6, binaryTime / 1e6);
        }
    }


    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }

    // Linear Search Algorithm (O(N))
    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }


    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
