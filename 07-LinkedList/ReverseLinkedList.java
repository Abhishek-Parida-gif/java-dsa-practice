import java.util.Scanner;
public class ReverseLinkedList {
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
    static Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
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
        head = reverse(head);
        System.out.println("\nReversed Linked List:");
        display(head);
    }
}
