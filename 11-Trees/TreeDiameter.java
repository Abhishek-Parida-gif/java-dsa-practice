import java.util.Scanner;
public class TreeDiameter {
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
    // Calculate height and diameter together
    static int diameter(Node root, int[] maxDiameter) {
        if (root == null) {
            return 0;
        }
        int leftHeight = diameter(root.left, maxDiameter);
        int rightHeight = diameter(root.right, maxDiameter);
        // Diameter passing through current node
        int currentDiameter = leftHeight + rightHeight + 1;
        maxDiameter[0] = Math.max(
                maxDiameter[0],
                currentDiameter
        );
        return Math.max(leftHeight, rightHeight) + 1;
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
        int[] maxDiameter = {0};
        diameter(root, maxDiameter);
        System.out.println("\n\nDiameter of Tree: "
                + maxDiameter[0]); 
    }
}
