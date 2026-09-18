import java.util.*;
public class HuffmanCoding {
    static class Node {
        char character;
        int frequency;
        Node left;
        Node right;
        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
        Node(int frequency, Node left, Node right) {
            this.character = '-';
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }
    static void printCodes(Node root, String code) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.character + " : " + code);
            return;
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }
    static void buildHuffmanTree(char[] characters, int[] frequencies) {
        PriorityQueue<Node> queue = new PriorityQueue<>(
            Comparator.comparingInt(node -> node.frequency)
        );
        for (int i = 0; i < characters.length; i++) {
            queue.add(new Node(characters[i], frequencies[i]));
        }
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node newNode = new Node(
                left.frequency + right.frequency,
                left,
                right
            );
            queue.add(newNode);
        }
        Node root = queue.poll();
        System.out.println("\nHuffman Codes:");
        printCodes(root, "");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();
        char[] characters = new char[n];
        int[] frequencies = new int[n];
        System.out.println("Enter character and frequency:");
        for (int i = 0; i < n; i++) {
            characters[i] = sc.next().charAt(0);
            frequencies[i] = sc.nextInt();
        }
        buildHuffmanTree(characters, frequencies);
    }
}
