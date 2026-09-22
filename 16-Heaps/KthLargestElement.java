import java.util.*;

public class KthLargestElement {

    // Find Kth largest element
    static int findKthLargest(int[] arr, int k) {

        if (k <= 0 || k > arr.length) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first k elements
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        // Process remaining elements
        for (int i = k; i < arr.length; i++) {

            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Root contains Kth largest
        return minHeap.peek();
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

        int result = findKthLargest(arr, k);

        if (result == -1) {
            System.out.println("Invalid value of K.");
        } else {
            System.out.println("Kth Largest Element: " + result);
        }

        sc.close();
    }
}
