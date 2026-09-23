import java.util.*;

public class AutoComplete {

    // Trie Node
    static class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
        }
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
        }

        current.isEndOfWord = true;
    }

    // Find node corresponding to prefix
    static TrieNode findPrefixNode(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }

    // Generate autocomplete suggestions
    static void findSuggestions(
            TrieNode current,
            StringBuilder word) {

        if (current.isEndOfWord) {
            System.out.println(word);
        }

        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null) {

                word.append((char) ('a' + i));

                findSuggestions(
                        current.children[i],
                        word
                );

                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    // Autocomplete
    static void autoComplete(String prefix) {

        TrieNode prefixNode = findPrefixNode(prefix);

        if (prefixNode == null) {

            System.out.println("No suggestions found.");
            return;
        }

        StringBuilder word =
                new StringBuilder(prefix);

        System.out.println("Suggestions:");

        findSuggestions(prefixNode, word);
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

        System.out.print("\nEnter prefix: ");

        String prefix = sc.next().toLowerCase();

        autoComplete(prefix);

        sc.close();
    }
}
