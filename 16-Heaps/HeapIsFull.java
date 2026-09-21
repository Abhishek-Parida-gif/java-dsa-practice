import java.util.*;

public class HeapIsFull {

    private int[] heap;
    private int size;

    HeapIsFull(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Insert element
    void insert(int value) {

        if (isFull()) {
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

    // Check whether heap is full
    boolean isFull() {
        return size == heap.length;
    }

    // Check whether heap is empty
    boolean isEmpty() {
        return size == 0;
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

    // Return current size
    int getSize() {
        return size;
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

        HeapIsFull heap = new HeapIsFull(capacity);

        System.out.println("\nIs heap full? " + heap.isFull());

        System.out.print("\nEnter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();
            heap.insert(value);

            System.out.println(
                "Current size: " + heap.getSize()
            );

            System.out.println(
                "Is heap full? " + heap.isFull()
            );
        }

        System.out.println("\nFinal Heap:");
        heap.display();

        System.out.println("Final size: " + heap.getSize());
        System.out.println("Is heap full? " + heap.isFull());

        sc.close();
    }
}
