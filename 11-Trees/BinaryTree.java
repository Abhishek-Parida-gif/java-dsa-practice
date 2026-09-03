import java.util.Scanner;
public class BinaryTree {
    // Node class
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // Create Binary Tree
    static Node createTree(Scanner sc) {
        System.out.print("Enter node value (-1 for no node): ");
        int value = sc.nextInt();
        if (value == -1) {
            return null;
        }
        Node newNode = new Node(value);
        System.out.println("Enter left child of " + value);
        newNode.left = createTree(sc);
        System.out.println("Enter right child of " + value);
        newNode.right = createTree(sc);
        return newNode;
    }
    // Inorder: Left -> Root -> Right
    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== CREATE BINARY TREE =====");
        Node root = createTree(sc);
        System.out.println("\nInorder Traversal:");
        inorder(root);
        System.out.println("\n\nPreorder Traversal:");
        preorder(root);
        System.out.println("\n\nPostorder Traversal:");
        postorder(root);
        System.out.println();
    }
}
