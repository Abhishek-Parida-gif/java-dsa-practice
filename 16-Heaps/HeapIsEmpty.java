import java.util.*;

public class HeapIsEmpty {

    private int[] heap;
    private int size;

    HeapIsEmpty(int capacity) {
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

    // Extract minimum
    int extractMin() {

        if (isEmpty()) {
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

    // Check whether heap is empty
    boolean isEmpty() {
        return size == 0;
    }

    // Return heap size
    int getSize() {
        return size;
    }

    // Display heap
    void display() {

        if (isEmpty()) {
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

        HeapIsEmpty heap = new HeapIsEmpty(capacity);

        System.out.println("\nChecking empty heap...");
        System.out.println("Is heap empty? " + heap.isEmpty());

        System.out.print("\nEnter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }

        System.out.println("\nHeap:");
        heap.display();

        System.out.println("Is heap empty? " + heap.isEmpty());

        System.out.print("\nEnter number of elements to remove: ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            heap.extractMin();
        }

        System.out.println("\nAfter removal:");

        heap.display();

        System.out.println("Is heap empty? " + heap.isEmpty());

        sc.close();
    }
}
