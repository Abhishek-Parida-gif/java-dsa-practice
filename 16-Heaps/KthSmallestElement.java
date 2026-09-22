import java.util.*;

public class KthSmallestElement {

    // Find Kth smallest element
    static int findKthSmallest(int[] arr, int k) {

        if (k <= 0 || k > arr.length) {
            return -1;
        }

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add first k elements
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k; i < arr.length; i++) {

            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        // Root contains Kth smallest
        return maxHeap.peek();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        int result = findKthSmallest(arr, k);

        if (result == -1) {
            System.out.println("Invalid value of K.");
        } else {
            System.out.println("Kth Smallest Element: " + result);
        }

        sc.close();
    }
}
