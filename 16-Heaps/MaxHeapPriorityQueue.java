import java.util.*;
public class MaxHeapPriorityQueue {
    private int[] heap;
    private int size;
    MaxHeapPriorityQueue(int capacity) {
        heap = new int[capacity];
        size = 0;
    }
    void insert(int value) {
        if (size == heap.length) {
            System.out.println("Priority Queue is full.");
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
    int remove() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return -1;
        }
        int maximum = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return maximum;
    }
    int peek() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return -1;
        }
        return heap[0];
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
    boolean isEmpty() {
        return size == 0;
    }
    void display() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return;
        }
        System.out.print("Max Heap Priority Queue: ");
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
        System.out.print("Enter capacity: ");
        int capacity = sc.nextInt();
        MaxHeapPriorityQueue pq =
                new MaxHeapPriorityQueue(capacity);
        int choice;
        do {
            System.out.println("\n--- Max Heap Priority Queue ---");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    pq.insert(value);
                    break;
                case 2:
                    int removed = pq.remove();
                    if (removed != -1) {
                        System.out.println(
                            "Removed element: " + removed
                        );
                    }
                    break;
                case 3:
                    int maximum = pq.peek();
                    if (maximum != -1) {
                        System.out.println(
                            "Highest priority element: " + maximum
                        );
                    }
                    break;
                case 4:
                    pq.display();
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
