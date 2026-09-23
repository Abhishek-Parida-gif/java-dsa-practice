import java.util.Scanner;

public class WordBreak {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
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
        }

        current.isEndOfWord = true;
    }

    // Check if string can be broken into dictionary words
    static boolean wordBreak(String text) {

        int n = text.length();

        // dp[i] = true if first i characters can be formed
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 0; i < n; i++) {

            if (!dp[i]) {
                continue;
            }

            TrieNode current = root;

            for (int j = i; j < n; j++) {

                int index = text.charAt(j) - 'a';

                // Character not present in Trie
                if (current.children[index] == null) {
                    break;
                }

                current = current.children[index];

                // A valid dictionary word is found
                if (current.isEndOfWord) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of dictionary words: ");
        int n = sc.nextInt();

        System.out.println("Enter dictionary words:");

        for (int i = 0; i < n; i++) {
            String word = sc.next().toLowerCase();
            insert(word);
        }

        System.out.print("Enter the string: ");
        String text = sc.next().toLowerCase();

        if (wordBreak(text)) {
            System.out.println("The string can be broken into valid words.");
        } else {
            System.out.println("The string cannot be broken into valid words.");
        }

        sc.close();
    }
}
