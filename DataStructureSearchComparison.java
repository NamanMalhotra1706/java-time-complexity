import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int n = 1_000_000;
        int target = n / 2;


        int[] array = new int[n];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long startArray = System.nanoTime();
        boolean foundInArray = linearSearch(array, target);
        long endArray = System.nanoTime();
        long timeArray = (endArray - startArray) / 1_000_000; // Convert to ms


        long startHashSet = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long endHashSet = System.nanoTime();
        long timeHashSet = (endHashSet - startHashSet) / 1_000_000; // Convert to ms


        long startTreeSet = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long endTreeSet = System.nanoTime();
        long timeTreeSet = (endTreeSet - startTreeSet) / 1_000_000; // Convert to ms

        // Print results
        System.out.println("Search Results:");
        System.out.println("Array Search (O(N)) - Found: " + foundInArray + " | Time: " + timeArray + " ms");
        System.out.println("HashSet Search (O(1)) - Found: " + foundInHashSet + " | Time: " + timeHashSet + " ms");
        System.out.println("TreeSet Search (O(log N)) - Found: " + foundInTreeSet + " | Time: " + timeTreeSet + " ms");
    }


    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
