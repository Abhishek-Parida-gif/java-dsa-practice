import java.util.Scanner;

public class MinimumXOR {

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

    // Find minimum XOR for a number
    static int findMinimumXOR(int number) {

        TrieNode current = root;

        int xor = 0;

        // Check bits from 31 to 0
        for (int i = 31; i >= 0; i--) {

            int bit = (number >> i) & 1;

            // For minimum XOR, prefer the same bit
            if (current.children[bit] != null) {

                current = current.children[bit];

            } else {

                // Opposite bit must be selected
                xor = xor | (1 << i);

                current = current.children[1 - bit];
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

        int minimumXOR = Integer.MAX_VALUE;

        for (int number : numbers) {

            int currentXOR = findMinimumXOR(number);

            if (currentXOR < minimumXOR) {
                minimumXOR = currentXOR;
            }
        }

        System.out.println(
            "Minimum XOR: " + minimumXOR
        );

        sc.close();
    }
}
