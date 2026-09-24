import java.util.Scanner;

public class XORQueries {

    // Bitwise Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    // Insert a number into the Bitwise Trie
    static void insert(int number) {

        TrieNode current = root;

        for (int i = 31; i >= 0; i--) {

            int bit = (number >> i) & 1;

            if (current.children[bit] == null) {
                current.children[bit] = new TrieNode();
            }

            current = current.children[bit];
        }
    }

    // Find maximum XOR for a query number
    static int findMaximumXOR(int number) {

        TrieNode current = root;

        int result = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (number >> i) & 1;

            // To maximize XOR, choose opposite bit
            int oppositeBit = 1 - bit;

            if (current.children[oppositeBit] != null) {

                result = result | (1 << i);

                current = current.children[oppositeBit];

            } else {

                current = current.children[bit];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {

            int number = sc.nextInt();

            insert(number);
        }

        // Input queries
        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        System.out.println("Enter the queries:");

        for (int i = 0; i < q; i++) {

            int query = sc.nextInt();

            int answer = findMaximumXOR(query);

            System.out.println(
                "Maximum XOR for " +
                query + ": " +
                answer
            );
        }

        sc.close();
    }
}
