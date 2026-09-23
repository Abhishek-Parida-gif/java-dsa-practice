import java.util.Scanner;

public class TrieSearch {

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

    // Search for a complete word
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
            System.out.println("Word found in Trie.");
        } else {
            System.out.println("Word not found in Trie.");
        }

        sc.close();
    }
}
