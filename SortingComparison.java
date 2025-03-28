import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000}; // Different dataset sizes
        Random random = new Random();

        System.out.println("Dataset Size | Bubble Sort Time (ms) | Merge Sort Time (ms) | Quick Sort Time (ms)");
        System.out.println("----------------------------------------------------------------------------");

        for (int size : datasetSizes) {
            int[] data = generateRandomArray(size);

            // Bubble Sort (O(N²))
            int[] bubbleData = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            bubbleSort(bubbleData);
            long bubbleTime = System.nanoTime() - startTime;

            // Merge Sort (O(N log N))
            int[] mergeData = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeTime = System.nanoTime() - startTime;

            // Quick Sort (O(N log N))
            int[] quickData = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickTime = System.nanoTime() - startTime;

            // Print results
            System.out.printf("%12d | %21.3f | %21.3f | %21.3f%n",
                    size, bubbleTime / 1e6, mergeTime / 1e6, quickTime / 1e6);
        }
    }

    // Generates an array of random integers
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }

    // Bubble Sort (O(N²))
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N))
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort (O(N log N))
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
