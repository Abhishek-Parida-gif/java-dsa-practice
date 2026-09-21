import java.util.*;

public class HeapDisplay {

    private int[] heap;
    private int size;

    HeapDisplay(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // Insert element into Min Heap
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

    // Display heap
    void display() {

        if (size == 0) {
            System.out.println("Heap is empty.");
            return;
        }

        System.out.print("Heap elements: ");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    // Display heap with indexes
    void displayWithIndex() {

        if (size == 0) {
            System.out.println("Heap is empty.");
            return;
        }

        System.out.println("\nIndex\tValue");

        for (int i = 0; i < size; i++) {
            System.out.println(i + "\t" + heap[i]);
        }
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

        HeapDisplay heap = new HeapDisplay(capacity);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            heap.insert(value);
        }

        System.out.println("\nMin Heap:");
        heap.display();

        heap.displayWithIndex();

        sc.close();
    }
}
