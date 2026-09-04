import java.util.Scanner;
public class LowestCommonAncestor {
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
    // Find Lowest Common Ancestor in BST
    static Node findLCA(Node root, int value1, int value2) {

        if (root == null) {
            return null;
        }
        // Both values are smaller than root
        if (value1 < root.data && value2 < root.data) {
            return findLCA(root.left, value1, value2);
        }
        // Both values are greater than root
        if (value1 > root.data && value2 > root.data) {
            return findLCA(root.right, value1, value2);
        }
        // Values are on different sides
        // or one value is the current node
        return root;
    }
    // Search value in BST
    static boolean search(Node root, int value) {

        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        if (value < root.data) {
            return search(root.left, value);
        }
        return search(root.right, value);
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
        System.out.print("\n\nEnter first value: ");
        int value1 = sc.nextInt();
        System.out.print("Enter second value: ");
        int value2 = sc.nextInt();
        if (!search(root, value1) || !search(root, value2)) {
            System.out.println("\nOne or both values are not present in the BST.");
        } else {
            Node lca = findLCA(root, value1, value2);
            System.out.println("\nLowest Common Ancestor: "
                    + lca.data);
        }
    }
}
