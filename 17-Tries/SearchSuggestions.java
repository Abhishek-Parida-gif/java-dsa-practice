package Tries;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SearchSuggestions {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
        String word = null;
    }
    static TrieNode root = new TrieNode();
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
        current.word = word;
    }
    static void findSuggestions(TrieNode node, List<String> suggestions) {

        if (node == null || suggestions.size() == 3) {
            return;
        }

        // If current node is a complete word
        if (node.isEndOfWord) {
            suggestions.add(node.word);
        }

        // Visit children from a to z
        for (int i = 0; i < 26; i++) {

            if (node.children[i] != null) {

                findSuggestions(node.children[i], suggestions);

                if (suggestions.size() == 3) {
                    return;
                }
            }
        }
    }

    // Search suggestions for every prefix
    static void searchSuggestions(String searchWord) {

        TrieNode current = root;

        String prefix = "";

        for (char ch : searchWord.toCharArray()) {

            prefix += ch;

            int index = ch - 'a';

            // Prefix does not exist
            if (current.children[index] == null) {

                System.out.println(prefix + " -> []");

                // All future prefixes will also have no suggestions
                current = null;

                continue;
            }

            current = current.children[index];

            List<String> suggestions = new ArrayList<>();

            findSuggestions(current, suggestions);

            System.out.println(prefix + " -> " + suggestions);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Products
        String[] products = {
            "mobile",
            "mouse",
            "moneypot",
            "monitor",
            "mousepad"
        };

        // Insert products
        for (String product : products) {
            insert(product);
        }

        System.out.print("Enter search word: ");
        String searchWord = sc.nextLine().toLowerCase();

        System.out.println("\nSearch Suggestions:");

        searchSuggestions(searchWord);

        sc.close();
    }
}
