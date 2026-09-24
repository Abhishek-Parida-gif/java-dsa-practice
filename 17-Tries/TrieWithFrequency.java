import java.util.Scanner;

public class TrieWithFrequency {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];

        boolean isEndOfWord;

        // Frequency of complete word
        int frequency;
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
        current.frequency++;
    }

    // Search frequency of a word
    static int getFrequency(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return 0;
            }

            current = current.children[index];
        }

        if (current.isEndOfWord) {
            return current.frequency;
        }

        return 0;
    }

    // Display all words and their frequencies
    static void display(TrieNode current, StringBuilder word) {

        if (current.isEndOfWord) {
            System.out.println(
                word + " -> " + current.frequency
            );
        }

        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null) {

                word.append((char) ('a' + i));

                display(current.children[i], word);

                // Backtracking
                word.deleteCharAt(word.length() - 1);
            }
        }
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

        System.out.println("\nWords and Frequencies:");

        display(root, new StringBuilder());

        System.out.print("\nEnter a word to check frequency: ");

        String searchWord = sc.next().toLowerCase();

        int frequency = getFrequency(searchWord);

        if (frequency == 0) {
            System.out.println(
                "Word \"" + searchWord + "\" was not found."
            );
        } else {
            System.out.println(
                "Frequency of \"" + searchWord + "\": " + frequency
            );
        }

        sc.close();
    }
}
