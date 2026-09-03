import java.util.Scanner;
public class QueueUsingLinkedList {
    // Node class
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node front = null;
    static Node rear = null;
    // Add element to queue
    static void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(value + " added to queue.");
    }
    // Remove element from queue
    static void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow! Queue is empty.");
            return;
        }
        System.out.println(front.data + " removed from queue.");
        front = front.next;
        // If queue becomes empty
        if (front == null) {
            rear = null;
        }
    }
    // View front element
    static void peek() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element: " + front.data);
    }
    // Check if queue is empty
    static boolean isEmpty() {
        return front == null;
    }
    // Display queue
    static void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }
        Node current = front;
        System.out.println("Queue elements:");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== QUEUE USING LINKED LIST =====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check Empty");
            System.out.println("6. Exit");
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
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }
}
