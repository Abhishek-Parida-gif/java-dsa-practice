package AdvancedDSA.AVLTree;
import java.util.Scanner;
public class AVLProblems {
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
    static int getBalance(Node node) {
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
        int balance = getBalance(root);
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
    static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }
    static Node findMin(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = delete(root.left, key);
        }
        else if (key > root.data) {
            root.right = delete(root.right, key);
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            }
            else if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else {
                Node successor = findMin(root.right);
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
            }
        }
        updateHeight(root);
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        if (balance < -1 && getBalance(root.right) > 0) {
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
    static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    static int countLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafNodes(root.left)
                + countLeafNodes(root.right);
    }
    static int findMinimum(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }
    static int findMaximum(Node root) {
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
    static void display(Node root) {
        System.out.println("\n========== AVL TREE ==========");
        System.out.print("Inorder: ");
        inorder(root);
        System.out.print("\nPreorder: ");
        preorder(root);
        System.out.println("\nHeight: " + getHeight(root));
        System.out.println("Root: " + root.data);
        System.out.println("Balance Factor: " + getBalance(root));
        System.out.println("Total Nodes: " + countNodes(root));
        System.out.println("Leaf Nodes: " + countLeafNodes(root));
        System.out.println("Minimum: " + findMinimum(root));
        System.out.println("Maximum: " + findMaximum(root));
        System.out.println("==============================");
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
        System.out.print("\nEnter value to search: ");
        int searchValue = sc.nextInt();
        if (search(root, searchValue)) {
            System.out.println(searchValue + " found in AVL Tree.");
        } else {
            System.out.println(searchValue + " not found in AVL Tree.");
        }
        System.out.print("\nEnter value to delete: ");
        int deleteValue = sc.nextInt();
        if (search(root, deleteValue)) {
            root = delete(root, deleteValue);
            System.out.println(deleteValue + " deleted successfully.");
            if (root != null) {
                display(root);
            } else {
                System.out.println("AVL Tree is empty.");
            }
        } else {
            System.out.println(deleteValue + " not found. Nothing deleted.");
        }
    }
}
