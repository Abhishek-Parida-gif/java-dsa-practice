package Tries;
import java.util.Scanner;
public class ConcatenatedWords {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    static TrieNode root = new TrieNode();
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
    static boolean canForm(String word, int start, int count) {
        if (start == word.length()) {
            return count >= 2;
        }
        TrieNode current = root;
        for (int i = start; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
            if (current.isEndOfWord) {
                if (canForm(word, i + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    static void findConcatenatedWords(String[] words) {
        System.out.println("\nConcatenated Words:");
        for (String word : words) {
            if (canForm(word, 0, 0)) {
                System.out.println(word);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        String[] words = new String[n];
        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.next().toLowerCase();
        }
        for (String word : words) {
            insert(word);
        }
        findConcatenatedWords(words);
    }
}
