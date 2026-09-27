package AdvancedDSA.AVLTree;
import java.util.Scanner;
public class AVLTree {
    static class Node {
        int data;
        int height;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }
    static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    static int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    static void updateHeight(Node node) {
        node.height = 1 + max(
                getHeight(node.left),
                getHeight(node.right)
        );
    }
    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    static void displayTree(Node root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        System.out.println("\nTree Information:");
        System.out.println("Root: " + root.data);
        System.out.println("Height: " + root.height);
        System.out.println(
                "Balance Factor: " + getBalanceFactor(root)
        );
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root value: ");
        int value = sc.nextInt();
        Node root = new Node(value)
        displayTree(root);
    }
}
