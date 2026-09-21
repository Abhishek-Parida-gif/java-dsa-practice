import java.util.*;

public class HeapSize {

    private int[] heap;
    private int size;

    HeapSize(int capacity) {
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

    // Remove minimum element
    int extractMin() {

        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        int minimum = heap[0];

        heap[0] = heap[size - 1];
        size--;

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

    // Return current heap size
    int getSize() {
        return size;
    }

    // Check if heap is empty
    boolean isEmpty() {
        return size == 0;
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

        HeapSize heap = new HeapSize(capacity);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }

        System.out.println("\nHeap:");
        heap.display();

        System.out.println("Heap size: " + heap.getSize());

        System.out.print("\nEnter number of elements to extract: ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {

            int removed = heap.extractMin();

            if (removed == -1) {
                break;
            }

            System.out.println("Removed: " + removed);
            System.out.println("Current heap size: " + heap.getSize());
        }

        System.out.println("\nFinal Heap:");
        heap.display();

        System.out.println("Final heap size: " + heap.getSize());

        sc.close();
    }
}
