import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class TreeLevelCount {
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
    // Count nodes at a specific level
    static int countNodesAtLevel(Node root, int targetLevel) {
        if (root == null || targetLevel < 0) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (currentLevel == targetLevel) {
                return levelSize;
            }
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            currentLevel++;
        }
        return 0;
    }
    // Level order traversal
    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
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
        System.out.println("\nLevel Order Traversal:");
        levelOrder(root);
        System.out.print("\n\nEnter level to count nodes: ");
        int level = sc.nextInt();
        int count = countNodesAtLevel(root, level);
        System.out.println("Number of nodes at level "
                + level + ": " + count);
    }
}
