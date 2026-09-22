import java.util.*;

public class HeapBuildFromArray {

    // Heapify a subtree
    static void heapify(int[] arr, int n, int i) {

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // Check right child
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If smallest is not the current node
        if (smallest != i) {

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Heapify affected subtree
            heapify(arr, n, smallest);
        }
    }

    // Build Min Heap
    static void buildMinHeap(int[] arr) {

        int n = arr.length;

        // Start from last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
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

        System.out.println("\nOriginal Array:");
        display(arr);

        buildMinHeap(arr);

        System.out.println("Min Heap:");
        display(arr);

        sc.close();
    }
}
