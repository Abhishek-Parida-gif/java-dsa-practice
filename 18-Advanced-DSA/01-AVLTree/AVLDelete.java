package AdvancedDSA.AVLTree;
import java.util.Scanner;
public class AVLDelete {
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
    static Node getMinValueNode(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
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
    static Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        }
        else if (data > root.data) {
            root.right = delete(root.right, data);
        }
        else {
            if (root.left == null &&
                root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node successor = getMinValueNode(root.right);
            root.data = successor.data
            root.right = delete(
                    root.right,
                    successor.data
            );
        }
        updateHeight(root);
        int balance = getBalanceFactor(root);
        if (balance > 1 &&
            getBalanceFactor(root.left) >= 0) {
            return rightRotate(root);
        }
        if (balance > 1 &&
            getBalanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 &&
            getBalanceFactor(root.right) <= 0) {
            return leftRotate(root);
        }
        if (balance < -1 &&
            getBalanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
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
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
        System.out.println("Root: " + root.data);
        System.out.println("Height: " + root.height);
        System.out.println(
                "Balance Factor: "
                + getBalanceFactor(root)
        );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.print("Enter number of values: ");
        int n = sc.nextInt();
        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }
        System.out.println("\nAVL Tree Before Deletion:");
        display(root);
        System.out.print("\nEnter value to delete: ");
        int deleteValue = sc.nextInt();
        root = delete(root, deleteValue);
        System.out.println("\nAVL Tree After Deletion:");
        display(root);
    }
}
