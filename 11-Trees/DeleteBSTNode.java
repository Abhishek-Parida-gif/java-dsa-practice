import java.util.Scanner;
public class DeleteBSTNode {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    // Insert a node
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
    // Find the minimum node
    static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    // Delete a node
    static Node delete(Node root, int value) {
        if (root == null) {
            return null;
        }
        // Search in left subtree
        if (value < root.data) {
            root.left = delete(root.left, value);
        }
        // Search in right subtree
        else if (value > root.data) {
            root.right = delete(root.right, value);
        }
        // Node found
        else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }
            // Case 2: Only left child
            if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }
    // Inorder traversal
    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
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
        System.out.println("\nBST before deletion:");
        inorder(root);
        System.out.print("\n\nEnter value to delete: ");
        int value = sc.nextInt();
        root = delete(root, value);
        System.out.println("\nBST after deletion:");
        inorder(root);
    }
}
