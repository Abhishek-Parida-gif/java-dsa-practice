package AdvancedDSA.AVLTree;
import java.util.Scanner;
public class AVLRotations {
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
    static void updateHeight(Node node) {
        node.height = 1 + max(
                getHeight(node.left),
                getHeight(node.right)
        );
    }
    static int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left)
                - getHeight(node.right);
    }
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node temp = x.right;
        x.right = y;
        y.left = temp;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node temp = y.left;
        y.left = x;
        x.right = temp;
        updateHeight(x);
        updateHeight(y);
        return y;
    }
    static Node LLCase(Node root) {
        System.out.println("\nLL Case");
        System.out.println(
                "Performing Right Rotation..."
        );
        return rightRotate(root);
    }
        System.out.println("\nRR Case");
        System.out.println(
                "Performing Left Rotation..."
        );
        return leftRotate(root);
    }
    static Node LRCase(Node root) {
        System.out.println("\nLR Case");
        System.out.println(
                "Performing Left Rotation on left child..."
        );
        root.left = leftRotate(root.left);
        System.out.println(
                "Performing Right Rotation on root..."
        );
        return rightRotate(root);
    }
    static Node RLCase(Node root) {
        System.out.println("\nRL Case");
        System.out.println(
                "Performing Right Rotation on right child..."
        );
        root.right = rightRotate(root.right);
        System.out.println(
                "Performing Left Rotation on root..."
        );
        return leftRotate(root);
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
    static void display(Node root) {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.println(
                "Root: " + root.data
        );
        System.out.println(
                "Height: " + root.height
        );
        System.out.println(
                "Balance Factor: "
                + getBalanceFactor(root)
        );
    }
    static Node createLLTree() {
        Node root = new Node(30);
        root.left = new Node(20);
        root.left.left = new Node(10);
        updateHeight(root.left);
        updateHeight(root);
        return root;
    }
    static Node createRRTree() {
        Node root = new Node(10);
        root.right = new Node(20);
        root.right.right = new Node(30);
        updateHeight(root.right);
        updateHeight(root);
        return root;
    }
    static Node createLRTree() {
        Node root = new Node(30);
        root.left = new Node(10);
        root.left.right = new Node(20);
        updateHeight(root.left);
        updateHeight(root);
        return root;
    }
    static Node createRLTree() {
        Node root = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(20);
        updateHeight(root.right);
        updateHeight(root);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("AVL Tree Rotations");
        System.out.println("-------------------");
        System.out.println("1. LL Rotation");
        System.out.println("2. RR Rotation");
        System.out.println("3. LR Rotation");
        System.out.println("4. RL Rotation");
        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();
        Node root;
        switch (choice) {
            case 1:
                root = createLLTree();
                System.out.println(
                        "\nBefore Rotation:"
                );
                display(root);
                root = LLCase(root);
                System.out.println(
                        "\nAfter Rotation:"
                );
                display(root);
                break;
            case 2:
                root = createRRTree();
                System.out.println(
                        "\nBefore Rotation:"
                );
                display(root);
                root = RRCase(root);
                System.out.println(
                        "\nAfter Rotation:"
                );
                display(root);
                break;
            case 3:
                root = createLRTree();
                System.out.println(
                        "\nBefore Rotation:"
                );
                display(root);
                root = LRCase(root);
                System.out.println(
                        "\nAfter Rotation:"
                );
                display(root);
                break;
            case 4:
                root = createRLTree();
                System.out.println(
                        "\nBefore Rotation:"
                );
                display(root);
                root = RLCase(root);
                System.out.println(
                        "\nAfter Rotation:"
                );
                display(root);
                break;
            default:
                System.out.println(
                        "Invalid choice."
                );
        }
    }
}
