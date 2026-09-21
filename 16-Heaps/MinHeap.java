import java.util.*;
public class MinHeap {
    private int[] heap;
    private int size;
    MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }
    void insert(int value) {
        if (size == heap.length) {
            System.out.println("Heap is full.");
            return;
        }
        heap[size] = value;
        int current = size;
        size++;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap[parent] <= heap[current]) {
                break;
            }
            swap(parent, current);
            current = parent;
        }
    }
    int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }
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
    int peek() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }
        return heap[0];
    }
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
    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter heap capacity: ");
        int capacity = sc.nextInt();
        MinHeap minHeap = new MinHeap(capacity);
        int choice;
        do {
            System.out.println("\n--- Min Heap Menu ---");
            System.out.println("1. Insert");
            System.out.println("2. Extract Minimum");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    minHeap.insert(value);
                    break;
                case 2:
                    int min = minHeap.extractMin();
                    if (min != -1) {
                        System.out.println("Minimum element removed: " + min);
                    }
                    break;
                case 3:
                    int minimum = minHeap.peek();
                    if (minimum != -1) {
                        System.out.println("Minimum element: " + minimum);
                    }
                    break;
                case 4:
                    minHeap.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
