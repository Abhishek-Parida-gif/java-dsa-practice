import java.util.Scanner;
public class DeleteNode {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
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
    }
    static Node deleteFromBeginning(Node head) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return null;
        }
        return head.next;
    }
    static Node deleteFromEnd(Node head) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }
    static Node deleteFromPosition(Node head, int position) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return null;
        }
        if (position == 1) {
            return head.next;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Invalid position.");
            return head;
        }
        current.next = current.next.next;
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
        head = deleteFromBeginning(head);
        System.out.println("\nAfter deleting from beginning:");
        display(head);
        head = deleteFromEnd(head);
        System.out.println("\nAfter deleting from end:");
        display(head);
        System.out.print("\nEnter position to delete: ");
        int position = sc.nextInt();
        head = deleteFromPosition(head, position);
        System.out.println("After deleting from position " + position + ":");
        display(head);
    }
}
