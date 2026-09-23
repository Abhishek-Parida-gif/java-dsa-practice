import java.util.Scanner;

public class WordDictionary {

    // Trie Node
    static class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
        }
    }

    static TrieNode root = new TrieNode();

    // Add a word
    static void addWord(String word) {

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

    // Search word with wildcard '.'
    static boolean search(String word) {

        return searchWord(root, word, 0);
    }

    // Recursive search
    static boolean searchWord(
            TrieNode current,
            String word,
            int index) {

        // Reached end of search word
        if (index == word.length()) {
            return current.isEndOfWord;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {

            int childIndex = ch - 'a';

            if (current.children[childIndex] == null) {
                return false;
            }

            return searchWord(
                    current.children[childIndex],
                    word,
                    index + 1
            );
        }

        // Wildcard '.'
        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null) {

                if (searchWord(
                        current.children[i],
                        word,
                        index + 1)) {

                    return true;
                }
            }
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

            addWord(word);
        }

        System.out.print("\nEnter word to search: ");

        String word = sc.next().toLowerCase();

        if (search(word)) {
            System.out.println("Word found.");
        } else {
            System.out.println("Word not found.");
        }

        sc.close();
    }
}
