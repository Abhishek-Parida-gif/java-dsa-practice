import java.util.*;

public class TopKElements {

    // Find K largest elements
    static void findTopK(int[] arr, int k) {

        if (k <= 0 || k > arr.length) {
            System.out.println("Invalid value of K.");
            return;
        }

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first K elements
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

        System.out.println("Top " + k + " Largest Elements:");

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }

        System.out.println();
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

        findTopK(arr, k);
    }
}
