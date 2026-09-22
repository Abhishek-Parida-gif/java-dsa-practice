import java.util.*;

public class HeapReplaceRoot {

    private int[] heap;
    private int size;

    HeapReplaceRoot(int capacity) {
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

    // Replace root
    int replaceRoot(int newValue) {

        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        int oldRoot = heap[0];

        // Replace root
        heap[0] = newValue;

        // Restore Min Heap property
        heapifyDown(0);

        return oldRoot;
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

        HeapReplaceRoot heap = new HeapReplaceRoot(capacity);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }

        System.out.println("\nOriginal Heap:");
        heap.display();

        System.out.print("\nEnter new root value: ");
        int newValue = sc.nextInt();

        int oldRoot = heap.replaceRoot(newValue);

        if (oldRoot != -1) {
            System.out.println("Old Root: " + oldRoot);
            System.out.println("New Root: " + newValue);
        }

        System.out.println("\nHeap after replacing root:");
        heap.display();

        sc.close();
    }
}
