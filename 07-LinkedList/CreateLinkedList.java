import java.util.Scanner;
public class CreateLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Linked List is empty.");
            sc.close();
            return;
        }
        Node head = null;
        Node tail = null;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter data for node " + i + ": ");
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        System.out.println("\nLinked List:");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
