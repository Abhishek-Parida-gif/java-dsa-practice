import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class SerializeDeserialize {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    // Insert into BST
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
    // Serialize tree using preorder traversal
    static void serialize(Node root, StringBuilder result) {
        if (root == null) {
            result.append("#,");
            return;
        }
        result.append(root.data).append(",");

        serialize(root.left, result);
        serialize(root.right, result);
    }
    // Deserialize tree
    static Node deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.add(value);
        }
        return buildTree(queue);
    }
    // Build tree from serialized data
    static Node buildTree(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node root = new Node(Integer.parseInt(value));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
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
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }
        // Serialize
        StringBuilder result = new StringBuilder();
        serialize(root, result);
        String serializedTree = result.toString();
        System.out.println("\nSerialized Tree:");
        System.out.println(serializedTree);
        // Deserialize
        Node newRoot = deserialize(serializedTree);
        System.out.println("Inorder Traversal After Deserialization:");
        inorder(newRoot);
    }
}
