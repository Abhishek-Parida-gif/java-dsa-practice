import java.util.Scanner;

public class UniquePrefix {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count;
        boolean isEndOfWord;
    }

    static TrieNode root = new TrieNode();

    // Insert word into Trie
    static void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
            current.count++;
        }

        current.isEndOfWord = true;
    }

    // Find unique prefix of a word
    static String findUniquePrefix(String word) {

        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            current = current.children[index];
            prefix.append(ch);

            // Only one word has this prefix
            if (current.count == 1) {
                break;
            }
        }

        return prefix.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        String[] words = new String[n];

        System.out.println("Enter the words:");

        // Read and insert words
        for (int i = 0; i < n; i++) {
            words[i] = sc.next().toLowerCase();
            insert(words[i]);
        }

        System.out.println("\nUnique Prefixes:");

        // Find unique prefix for every word
        for (String word : words) {
            String prefix = findUniquePrefix(word);

            System.out.println(word + " -> " + prefix);
        }

        sc.close();
    }
}
