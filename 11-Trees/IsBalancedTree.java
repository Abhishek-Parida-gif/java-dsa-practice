import java.util.Scanner;
public class IsBalancedTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    // Insert node into BST
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
    // Calculate height
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(
                height(root.left),
                height(root.right)
        );
    }
    // Check if tree is balanced
    static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left)
                && isBalanced(root.right);
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
        if (n <= 0) {
            System.out.println("Tree is empty.");
            sc.close();
            return;
        }
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }
        System.out.println("\nInorder Traversal:");
        inorder(root);
        System.out.println("\n\nIs Tree Balanced? "
                + isBalanced(root));
    }
}
