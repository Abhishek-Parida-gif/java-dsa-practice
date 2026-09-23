import java.util.Scanner;

public class LongestPrefix {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
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
        }

        current.isEndOfWord = true;
    }

    // Find the Longest Common Prefix
    static String longestCommonPrefix() {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();

        while (true) {

            // If current word ends here, stop
            if (current.isEndOfWord) {
                break;
            }

            int count = 0;
            int nextIndex = -1;

            // Count children
            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    count++;
                    nextIndex = i;
                }
            }

            // More than one path means common prefix ends
            if (count != 1) {
                break;
            }

            // Add character to prefix
            prefix.append((char) ('a' + nextIndex));

            current = current.children[nextIndex];
        }

        return prefix.toString();
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

        String result = longestCommonPrefix();

        if (result.length() == 0) {
            System.out.println("No common prefix.");
        } else {
            System.out.println("Longest Common Prefix: " + result);
        }

        sc.close();
    }
}
