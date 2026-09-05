import java.util.ArrayList;
import java.util.Scanner;
public class TreePath {
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
    // Find path from root to target
    static boolean findPath(Node root, int target,
                            ArrayList<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.data);
        if (root.data == target) {
            return true;
        }
        if (target < root.data) {
            if (findPath(root.left, target, path)) {
                return true;
            }
        } else {
            if (findPath(root.right, target, path)) {
                return true;
            }
        }
        // Remove node if target was not found in this path
        path.remove(path.size() - 1);
        return false;
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
        System.out.print("\n\nEnter target value: ");
        int target = sc.nextInt();
        ArrayList<Integer> path = new ArrayList<>();
        if (findPath(root, target, path)) {
            System.out.println("\nPath from Root to "
                    + target + ":");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
        } else {
            System.out.println("\n" + target
                    + " not found in the tree.");
        }
    }
}
