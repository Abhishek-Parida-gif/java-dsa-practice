import java.util.Scanner;

public class MaximumXOR {

    // Bitwise Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    // Insert a number into the Bitwise Trie
    static void insert(int number) {

        TrieNode current = root;

        // Check bits from 31 to 0
        for (int i = 31; i >= 0; i--) {

            int bit = (number >> i) & 1;

            if (current.children[bit] == null) {
                current.children[bit] = new TrieNode();
            }

            current = current.children[bit];
        }
    }

    // Find maximum XOR for a number
    static int findMaximumXOR(int number) {

        TrieNode current = root;

        int xor = 0;

        // Check bits from 31 to 0
        for (int i = 31; i >= 0; i--) {

            int bit = (number >> i) & 1;

            // To maximize XOR, prefer opposite bit
            int oppositeBit = 1 - bit;

            if (current.children[oppositeBit] != null) {

                xor = xor | (1 << i);

                current = current.children[oppositeBit];

            } else {

                current = current.children[bit];
            }
        }

        return xor;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter the numbers:");

        for (int i = 0; i < n; i++) {

            numbers[i] = sc.nextInt();

            insert(numbers[i]);
        }

        int maximumXOR = 0;

        for (int number : numbers) {

            int currentXOR = findMaximumXOR(number);

            if (currentXOR > maximumXOR) {
                maximumXOR = currentXOR;
            }
        }

        System.out.println(
            "Maximum XOR: " + maximumXOR
        );

        sc.close();
    }
}
