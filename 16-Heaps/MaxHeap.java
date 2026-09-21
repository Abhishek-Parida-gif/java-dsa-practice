import java.util.*;
public class MaxHeap {
    private int[] heap;
    private int size;
    MaxHeap(int capacity) {
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
            if (heap[parent] >= heap[current]) {
                break;
            }
            swap(parent, current);
            current = parent;
        }
    }
    int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }
    void heapifyDown(int index) {
        while (true) {
            int largest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest == index) {
                break;
            }
            swap(index, largest);
            index = largest;
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
        System.out.print("Max Heap: ");
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
        MaxHeap maxHeap = new MaxHeap(capacity);
        int choice;
        do {
            System.out.println("\n--- Max Heap Menu ---");
            System.out.println("1. Insert");
            System.out.println("2. Extract Maximum");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    maxHeap.insert(value);
                    break;
                case 2:
                    int max = maxHeap.extractMax();
                    if (max != -1) {
                        System.out.println("Maximum element removed: " + max);
                    }
                    break;
                case 3:
                    int maximum = maxHeap.peek();
                    if (maximum != -1) {
                        System.out.println("Maximum element: " + maximum);
                    }
                    break;
                case 4:
                    maxHeap.display();
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
