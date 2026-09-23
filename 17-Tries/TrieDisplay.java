import java.util.Scanner;

public class TrieDisplay {

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

    // Display all words
    static void displayWords(
            TrieNode current,
            StringBuilder word) {

        // If current node is the end of a word
        if (current.isEndOfWord) {
            System.out.println(word);
        }

        // Visit all children
        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null) {

                // Add character
                word.append((char) ('a' + i));

                // Recursive DFS
                displayWords(
                        current.children[i],
                        word
                );

                // Remove character
                word.deleteCharAt(word.length() - 1);
            }
        }
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

        System.out.println("\nWords stored in Trie:");

        StringBuilder word = new StringBuilder();

        displayWords(root, word);

        sc.close();
    }
}
