import java.util.*;
public class HeapDelete {
    private int[] heap;
    private int size;

    HeapDelete(int capacity) {
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

    // Delete an element by value
    boolean delete(int value) {

        int index = -1;

        // Find the element
        for (int i = 0; i < size; i++) {

            if (heap[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        // Replace the element with the last element
        heap[index] = heap[size - 1];
        size--;

        // Restore heap property
        if (index > 0 &&
            heap[index] < heap[(index - 1) / 2]) {

            heapifyUp(index);

        } else {
            heapifyDown(index);
        }

        return true;
    }

    // Heapify Up
    void heapifyUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (heap[parent] <= heap[index]) {
                break;
            }

            swap(parent, index);
            index = parent;
        }
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

        HeapDelete heap = new HeapDelete(capacity);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }

        System.out.println("\nOriginal Heap:");
        heap.display();

        System.out.print("Enter element to delete: ");
        int value = sc.nextInt();

        if (heap.delete(value)) {
            System.out.println("Element deleted successfully.");
        } else {
            System.out.println("Element not found.");
        }

        System.out.println("Heap after deletion:");
        heap.display();

        sc.close();
    }
}
