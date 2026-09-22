import java.util.*;

public class SortNearlySortedArray {

    // Sort a nearly sorted array
    static void sortNearlySorted(int[] arr, int k) {

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        int index = 0;

        // Add first k + 1 elements
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k + 1; i < arr.length; i++) {

            arr[index++] = minHeap.poll();

            minHeap.add(arr[i]);
        }

        // Empty remaining heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    // Display array
    static void display(int[] arr) {

        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter nearly sorted elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        System.out.println("\nOriginal Array:");
        display(arr);

        sortNearlySorted(arr, k);

        System.out.println("Sorted Array:");
        display(arr);

        sc.close();
    }
}
