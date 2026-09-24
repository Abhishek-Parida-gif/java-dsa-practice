import java.util.Scanner;
public class LongestWordTrie {
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

    // Find the longest word
    static String longestWord(
            TrieNode current,
            StringBuilder word) {

        String longest = word.toString();

        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null) {

                TrieNode child = current.children[i];

                // Continue only if the current prefix
                // is also a complete word
                if (child.isEndOfWord) {

                    word.append((char) ('a' + i));

                    String candidate =
                        longestWord(child, word);

                    // Keep the longer word
                    if (candidate.length() > longest.length()) {
                        longest = candidate;
                    }

                    // Backtracking
                    word.deleteCharAt(word.length() - 1);
                }
            }
        }

        return longest;
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

        StringBuilder word = new StringBuilder();

        String result = longestWord(root, word);

        System.out.println(
            "Longest Word: " + result
        );

        sc.close();
    }
}
