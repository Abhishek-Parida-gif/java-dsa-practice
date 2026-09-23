import java.util.Scanner;

public class Trie {

    // Trie Node
    static class TrieNode {

        TrieNode[] children = new TrieNode[26];

        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;

            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
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

    // Search a complete word
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

    // Check if a prefix exists
    static boolean startsWith(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return true;
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

        System.out.print("\nEnter word to search: ");
        String word = sc.next().toLowerCase();

        if (search(word)) {
            System.out.println("Word found.");
        } else {
            System.out.println("Word not found.");
        }

        System.out.print("\nEnter prefix to search: ");
        String prefix = sc.next().toLowerCase();

        if (startsWith(prefix)) {
            System.out.println("Prefix exists.");
        } else {
            System.out.println("Prefix does not exist.");
        }

        sc.close();
    }
}
