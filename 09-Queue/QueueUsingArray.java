import java.util.Scanner;
public class QueueUsingArray {
    static int[] queue;
    static int front = -1;
    static int rear = -1;
    // Add element to queue
    static void enqueue(int value) {
        if (rear == queue.length - 1) {
            System.out.println("Queue Overflow! Queue is full.");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear++;
        queue[rear] = value;
        System.out.println(value + " added to queue.");
    }
    // Remove element from queue
    static void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow! Queue is empty.");
            return;
        }
        System.out.println(queue[front] + " removed from queue.");
        front++;
        // Reset queue when it becomes empty
        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }
    // View front element
    static void peek() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element: " + queue[front]);
    }
    // Check if queue is empty
    static boolean isEmpty() {
        return front == -1;
    }
    // Check if queue is full
    static boolean isFull() {
        return rear == queue.length - 1;
    }
    // Display queue
    static void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue elements:");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        int size = sc.nextInt();
        queue = new int[size];
        int choice;
        do {
            System.out.println("\n===== QUEUE MENU =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check Empty");
            System.out.println("6. Check Full");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = sc.nextInt();
                    enqueue(value);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    if (isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue is not empty.");
                    }
                    break;
                case 6:
                    if (isFull()) {
                        System.out.println("Queue is full.");
                    } else {
                        System.out.println("Queue is not full.");
                    }
                    break;
                case 7:
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }
}
