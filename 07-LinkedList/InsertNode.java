import java.util.Scanner;
public class InsertNode {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }
    static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    static Node insertAtPosition(Node head, int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            return newNode;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position.");
            return head;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
    static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter data for node " + i + ": ");
            int data = sc.nextInt();
            head = insertAtEnd(head, data);
        }
        System.out.println("\nOriginal Linked List:");
        display(head);
        System.out.print("\nEnter value to insert at beginning: ");
        int beginningValue = sc.nextInt();
        head = insertAtBeginning(head, beginningValue);
        System.out.println("After insertion at beginning:");
        display(head);
        System.out.print("\nEnter value to insert at end: ");
        int endValue = sc.nextInt();
        head = insertAtEnd(head, endValue);
        System.out.println("After insertion at end:");
        display(head);
        System.out.print("\nEnter value to insert at position: ");
        int positionValue = sc.nextInt();
        System.out.print("Enter position: ");
        int position = sc.nextInt();
        head = insertAtPosition(head, positionValue, position);
        System.out.println("After insertion at position " + position + ":");
        display(head);
    }
}
