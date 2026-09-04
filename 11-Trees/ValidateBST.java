import java.util.Scanner;
public class ValidateBST {
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
    // Validate BST using range limits
    static boolean isValidBST(Node root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.data)
                && isValidBST(root.right, root.data, max);
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
        boolean result = isValidBST(
                root,
                Long.MIN_VALUE,
                Long.MAX_VALUE
        );
        System.out.println("\n\nIs Valid BST? " + result);
    }
}
