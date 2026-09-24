import java.util.ArrayList;
import java.util.Scanner;

public class AutoCompleteFrequency {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];

        boolean isEndOfWord;

        // Frequency of the complete word
        int frequency;
    }

    // Store word and frequency
    static class WordFrequency {
        String word;
        int frequency;

        WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
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
        current.frequency++;
    }

    // Find node corresponding to prefix
    static TrieNode findPrefixNode(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }

    // Collect all words below a Trie node
    static void collectWords(
            TrieNode current,
            StringBuilder word,
            ArrayList<WordFrequency> results) {

        if (current.isEndOfWord) {

            results.add(
                new WordFrequency(
                    word.toString(),
                    current.frequency
                )
            );
        }

        for (int i = 0; i < 26; i++) {

            if (current.children[i] != null) {

                word.append((char) ('a' + i));

                collectWords(
                    current.children[i],
                    word,
                    results
                );

                // Backtracking
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    // Sort words by frequency
    static void sortByFrequency(
            ArrayList<WordFrequency> results) {

        for (int i = 0; i < results.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < results.size(); j++) {
                if (results.get(j).frequency >
                    results.get(maxIndex).frequency) {
                    maxIndex = j;
                }
            }
            WordFrequency temp = results.get(i);
            results.set(i, results.get(maxIndex));
            results.set(maxIndex, temp);
        }
    }
    // Display autocomplete suggestions
    static void autocomplete(String prefix) {
        TrieNode prefixNode = findPrefixNode(prefix);
        if (prefixNode == null) {
            System.out.println(
                "No suggestions found."
            );
            return;
        }
        ArrayList<WordFrequency> results =
            new ArrayList<>();
        StringBuilder word =
            new StringBuilder(prefix);
        collectWords(
            prefixNode,
            word,
            results
        );
        sortByFrequency(results);
        System.out.println(
            "\nAutocomplete Suggestions:"
        );
        for (WordFrequency result : results) {
            System.out.println(
                result.word + " -> " +
                result.frequency
            );
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            String word =
                sc.next().toLowerCase();
            insert(word);
        }
        System.out.print("Enter prefix: ");
        String prefix =
            sc.next().toLowerCase();
        autocomplete(prefix);
    }
}
