package AdvancedDSA.AVLTree;
import java.util.Scanner;
public class AVLSearch {
    static class Node {
        int data;
        Node left;
        Node right;
        int height;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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
        return getHeight(node.left) - getHeight(node.right);
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
    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } 
        else if (data > root.data) {
            root.right = insert(root.right, data);
        } 
        else {
            return root;
        }
        updateHeight(root);
        int balance = getBalanceFactor(root);
        if (balance > 1 && data < root.left.data) {
            return rightRotate(root);
        }
        if (balance < -1 && data > root.right.data) {
            return leftRotate(root);
        }
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    static boolean recursiveSearch(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            return recursiveSearch(root.left, key);
        }
        return recursiveSearch(root.right, key);
    }
    static boolean iterativeSearch(Node root, int key) {
        Node current = root;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            if (key < current.data) {
                current = current.left;
            } 
            else {
                current = current.right;
            }
        }
        return false;
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
        System.out.println("\nInorder Traversal:");
        inorder(root);
        System.out.println("\n\nPreorder Traversal:");
        preorder(root);
        System.out.println("\n\nRoot: " + root.data);
        System.out.println("Height: " + getHeight(root));
        System.out.println("Balance Factor: " + getBalanceFactor(root));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }
        display(root);
        System.out.print("\nEnter element to search: ");
        int key = sc.nextInt();
        if (recursiveSearch(root, key)) {
            System.out.println("Recursive Search: " + key + " found");
        } else {
            System.out.println("Recursive Search: " + key + " not found");
        }
        if (iterativeSearch(root, key)) {
            System.out.println("Iterative Search: " + key + " found");
        } else {
            System.out.println("Iterative Search: " + key + " not found");
        }
    }
}
