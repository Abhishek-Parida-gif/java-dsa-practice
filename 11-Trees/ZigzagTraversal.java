import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class ZigzagTraversal {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    // Insert into BST
    static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }
    // Zigzag traversal
    static void zigzagTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int[] level = new int[levelSize];
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                int index;
                if (leftToRight) {
                    index = i;
                } else {
                    index = levelSize - 1 - i;
                }
                level[index] = current.data;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            for (int value : level) {
                System.out.print(value + " ");
            }
            leftToRight = !leftToRight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }
        System.out.println("\nZigzag Traversal:");
        zigzagTraversal(root);
    }
}
