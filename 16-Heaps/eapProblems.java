import java.util.*;

public class HeapProblems {

    // 1. Find Kth Largest Element
    static int kthLargest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int value : arr) {

            minHeap.add(value);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    // 2. Find Kth Smallest Element
    static int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int value : arr) {

            maxHeap.add(value);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }

    // 3. Find Top K Largest Elements
    static void topKLargest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int value : arr) {

            minHeap.add(value);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        System.out.print("Top " + k + " largest elements: ");

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }

        System.out.println();
    }

    // 4. Find K Smallest Elements
    static void kSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int value : arr) {

            maxHeap.add(value);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        System.out.print("K smallest elements: ");

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }

        System.out.println();
    }

    // 5. Find Maximum Element
    static int findMaximum(int[] arr) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int value : arr) {
            maxHeap.add(value);
        }

        return maxHeap.peek();
    }

    // 6. Find Minimum Element
    static int findMinimum(int[] arr) {

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        for (int value : arr) {
            minHeap.add(value);
        }

        return minHeap.peek();
    }

    // 7. Sort an Array using Heap
    static void heapSort(int[] arr) {

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        for (int value : arr) {
            minHeap.add(value);
        }

        int index = 0;

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

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nArray:");
        display(arr);

        System.out.println("Maximum element: "
                + findMaximum(arr));

        System.out.println("Minimum element: "
                + findMinimum(arr));

        System.out.print("\nEnter K: ");
        int k = sc.nextInt();

        if (k > 0 && k <= n) {

            System.out.println(
                    "Kth largest element: "
                    + kthLargest(arr, k));

            System.out.println(
                    "Kth smallest element: "
                    + kthSmallest(arr, k));

            topKLargest(arr, k);

            kSmallest(arr, k);

        } else {

            System.out.println("Invalid value of K.");
        }

        heapSort(arr);

        System.out.println("\nSorted Array using Heap:");
        display(arr);

        sc.close();
    }
}
