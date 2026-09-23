import java.util.Scanner;

public class TrieDelete {

    // Trie Node
    static class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
        }
    }

    static TrieNode root = new TrieNode();

    // Insert a word
    static void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Search a word
    static boolean search(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isEndOfWord;
    }

    // Check if node has any children
    static boolean hasChildren(TrieNode node) {

        for (TrieNode child : node.children) {

            if (child != null) {
                return true;
            }
        }

        return false;
    }

    // Delete a word
    static boolean delete(TrieNode current, String word, int depth) {

        // Word not found
        if (current == null) {
            return false;
        }

        // Reached end of word
        if (depth == word.length()) {

            if (!current.isEndOfWord) {
                return false;
            }

            current.isEndOfWord = false;

            // Delete node if it has no children
            return !hasChildren(current);
        }

        int index = word.charAt(depth) - 'a';

        TrieNode child = current.children[index];

        if (child == null) {
            return false;
        }

        boolean shouldDeleteChild =
                delete(child, word, depth + 1);

        if (shouldDeleteChild) {
            current.children[index] = null;

            return !current.isEndOfWord
                    && !hasChildren(current);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();

        System.out.println("Enter lowercase words:");

        for (int i = 0; i < n; i++) {

            String word = sc.next().toLowerCase();

            insert(word);
        }

        System.out.print("\nEnter word to delete: ");
        String word = sc.next().toLowerCase();

        if (search(word)) {

            delete(root, word, 0);

            System.out.println("Word deleted successfully.");

        } else {

            System.out.println("Word not found.");
        }

        System.out.print("\nSearch the word again: ");

        String searchWord = sc.next().toLowerCase();

        if (search(searchWord)) {
            System.out.println("Word found in Trie.");
        } else {
            System.out.println("Word not found in Trie.");
        }

        sc.close();
    }
}
