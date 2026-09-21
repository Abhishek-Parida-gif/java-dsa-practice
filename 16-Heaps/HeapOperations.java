import java.util.*;
public class HeapOperations {
    private int[] heap;
    private int size;
    HeapOperations(int capacity) {
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
    // Extract minimum element
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
    // Peek minimum element
    int peek() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }
        return heap[0];
    }
    // Return heap size
    int getSize() {
        return size;
    }
    boolean isEmpty() {
        return size == 0;
    }
    void display() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return;
        }
        System.out.print("Heap: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter heap capacity: ");
        int capacity = sc.nextInt();
        HeapOperations heap = new HeapOperations(capacity);
        int choice;
        do {
            System.out.println("\n--- Heap Operations ---");
            System.out.println("1. Insert");
            System.out.println("2. Extract Minimum");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Check Empty");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    heap.insert(value);
                    break;
                case 2:
                    int minimum = heap.extractMin();
                    if (minimum != -1) {
                        System.out.println(
                            "Minimum removed: " + minimum
                        );
                    }
                    break;
                case 3:
                    int min = heap.peek();
                    if (min != -1) {
                        System.out.println(
                            "Minimum element: " + min
                        );
                    }
                    break;
                case 4:
                    heap.display();
                    break;
                case 5:
                    System.out.println(
                        "Heap size: " + heap.getSize()
                    );
                    break;
                case 6:
                    System.out.println(
                        "Is heap empty? " + heap.isEmpty()
                    );
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }
}
