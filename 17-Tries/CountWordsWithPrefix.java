import java.util.Scanner;

public class CountWordsWithPrefix {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int prefixCount;
        boolean isEndOfWord;
    }

    static TrieNode root = new TrieNode();

    // Insert a word into Trie
    static void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];

            // Count words passing through this node
            current.prefixCount++;
        }

        current.isEndOfWord = true;
    }

    // Count words starting with a prefix
    static int countWordsWithPrefix(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            // Prefix does not exist
            if (current.children[index] == null) {
                return 0;
            }

            current = current.children[index];
        }

        return current.prefixCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        System.out.println("Enter the words:");

        for (int i = 0; i < n; i++) {

            String word = sc.next().toLowerCase();

            insert(word);
        }

        System.out.print("Enter prefix: ");
        String prefix = sc.next().toLowerCase();

        int result = countWordsWithPrefix(prefix);

        System.out.println(
            "Number of words starting with \"" + prefix + "\": " + result
        );

        sc.close();
    }
}
