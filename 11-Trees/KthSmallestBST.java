import java.util.Scanner;
public class KthSmallestBST {
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
    // Find kth smallest element
    static int kthSmallest(Node root, int[] count, int k) {
        if (root == null) {
            return -1;
        }
        // Search left subtree
        int leftResult = kthSmallest(root.left, count, k);
        if (leftResult != -1) {
            return leftResult;
        }
        // Visit current node
        count[0]++;
        if (count[0] == k) {
            return root.data;
        }
        // Search right subtree
        return kthSmallest(root.right, count, k);
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
        System.out.print("\n\nEnter k: ");
        int k = sc.nextInt();
        if (k <= 0 || k > n) {
            System.out.println("Invalid value of k.");
        } else {
            int[] count = {0};
            int result = kthSmallest(root, count, k);
            System.out.println(
                    k + "th Smallest Element: " + result
            );
        }
    }
}
