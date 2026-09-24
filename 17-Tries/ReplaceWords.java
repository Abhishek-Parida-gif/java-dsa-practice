import java.util.Scanner;

public class ReplaceWords {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    static TrieNode root = new TrieNode();

    // Insert root word into Trie
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

    // Find shortest root for a word
    static String findRoot(String word) {

        TrieNode current = root;

        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            // No matching root
            if (current.children[index] == null) {
                return word;
            }

            current = current.children[index];

            prefix.append(ch);

            // Shortest root found
            if (current.isEndOfWord) {
                return prefix.toString();
            }
        }

        return word;
    }

    // Replace words in sentence
    static String replaceWords(String sentence) {

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            String replacement = findRoot(word);

            result.append(replacement);
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of root words: ");
        int n = sc.nextInt();

        System.out.println("Enter the root words:");

        for (int i = 0; i < n; i++) {

            String word = sc.next().toLowerCase();

            insert(word);
        }

        sc.nextLine();

        System.out.print("Enter the sentence: ");

        String sentence = sc.nextLine().toLowerCase();

        String result = replaceWords(sentence);

        System.out.println("\nOriginal Sentence:");
        System.out.println(sentence);

        System.out.println("\nReplaced Sentence:");
        System.out.println(result);

        sc.close();
    }
}
