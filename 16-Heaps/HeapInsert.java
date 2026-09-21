import java.util.*;

public class HeapInsert {

    private int[] heap;
    private int size;

    HeapInsert(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Insert element into Min Heap
    void insert(int value) {

        if (size == heap.length) {
            System.out.println("Heap is full.");
            return;
        }

        // Add element at the end
        heap[size] = value;

        int current = size;
        size++;

        // Heapify Up
        while (current > 0) {

            int parent = (current - 1) / 2;

            // Min Heap property satisfied
            if (heap[parent] <= heap[current]) {
                break;
            }

            // Swap parent and child
            swap(parent, current);

            current = parent;
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

    // Return minimum element
    int peek() {

        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        return heap[0];
    }

    // Swap two elements
    void swap(int i, int j) {

        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter heap capacity: ");
        int capacity = sc.nextInt();

        HeapInsert heap = new HeapInsert(capacity);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();
            heap.insert(value);

            System.out.print("After inserting " + value + ": ");
            heap.display();
        }

        System.out.println("\nFinal Heap:");
        heap.display();

        System.out.println("Minimum element: " + heap.peek());

        sc.close();
    }
}
