import java.util.*;

public class HeapExtract {

    private int[] heap;
    private int size;

    HeapExtract(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Insert element
    void insert(int value) {

        if (size == heap.length) {
            System.out.println("Heap is full.");
            return;
        }

        heap[size] = value;

        int current = size;
        size++;

        // Heapify Up
        while (current > 0) {

            int parent = (current - 1) / 2;

            if (heap[parent] <= heap[current]) {
                break;
            }

            swap(parent, current);
            current = parent;
        }
    }

    // Extract minimum element
    int extractMin() {

        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        // Minimum is at root
        int minimum = heap[0];

        // Move last element to root
        heap[0] = heap[size - 1];
        size--;

        // Restore Min Heap
        heapifyDown(0);

        return minimum;
    }

    // Heapify Down
    void heapifyDown(int index) {

        while (true) {

            int smallest = index;

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    // Display heap
    void display() {

        if (size == 0) {
            System.out.println("Heap is empty.");
            return;
        }

        System.out.print("Min Heap: ");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    // Swap elements
    void swap(int i, int j) {

        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter heap capacity: ");
        int capacity = sc.nextInt();

        HeapExtract heap = new HeapExtract(capacity);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }

        System.out.println("\nOriginal Heap:");
        heap.display();

        System.out.print("\nHow many elements do you want to extract? ");
        int count = sc.nextInt();

        System.out.println("\nExtracted elements:");

        for (int i = 0; i < count; i++) {

            int minimum = heap.extractMin();

            if (minimum == -1) {
                break;
            }

            System.out.println("Extracted: " + minimum);
        }

        System.out.println("\nHeap after extraction:");
        heap.display();

        sc.close();
    }
}
