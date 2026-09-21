import java.util.*;

public class HeapPeek {

    private int[] heap;
    private int size;

    HeapPeek(int capacity) {
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

    // Peek minimum element
    int peek() {

        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        return heap[0];
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

        HeapPeek heap = new HeapPeek(capacity);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }

        System.out.println("\nHeap:");
        heap.display();

        // Peek operation
        int minimum = heap.peek();

        if (minimum != -1) {
            System.out.println("\nMinimum element: " + minimum);
            System.out.println("The element was not removed.");
        }

        System.out.println("\nHeap after peek:");
        heap.display();

        sc.close();
    }
}
