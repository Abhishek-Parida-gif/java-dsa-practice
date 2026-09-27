package Tries;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TrieProblems {
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
    static boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
    static void displayWords(TrieNode node,
                             StringBuilder word) {
        if (node.isEndOfWord) {
            System.out.println(word);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                word.append((char) ('a' + i));
                displayWords(node.children[i], word);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }
    static int countWordsWithPrefix(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return 0;
            }
            current = current.children[index];
        }
        return countWords(current);
    }
    static int countWords(TrieNode node) {
        int count = 0;
        if (node.isEndOfWord) {
            count++;
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                count += countWords(node.children[i]);
            }
        }
        return count;
    }
    static String longestWord() {
        String[] answer = {""};
        findLongestWord(root, new StringBuilder(), answer);
        return answer[0];
    }
    static void findLongestWord(TrieNode node,
                                 StringBuilder word,
                                 String[] answer) {
        if (node.isEndOfWord) {
            if (word.length() > answer[0].length()) {
                answer[0] = word.toString();
            } else if (word.length() == answer[0].length()
                    && word.toString().compareTo(answer[0]) < 0) {
                answer[0] = word.toString();
            }
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                word.append((char) ('a' + i));
                findLongestWord(
                        node.children[i],
                        word,
                        answer
                );
                word.deleteCharAt(word.length() - 1);
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
            insert(words[i]);
        }
        System.out.println("\nAll Words:");
        displayWords(root, new StringBuilder());
        System.out.print("\nEnter word to search: ");
        String searchWord = sc.next().toLowerCase();
        if (search(searchWord)) {
            System.out.println("Word found.");
        } else {
            System.out.println("Word not found.");
        }
        System.out.print("\nEnter prefix: ");
        String prefix = sc.next().toLowerCase();
        if (startsWith(prefix)) {
            System.out.println("Prefix exists.");
        } else {
            System.out.println("Prefix does not exist.");
        }
        int count = countWordsWithPrefix(prefix);
        System.out.println(
                "Words starting with \"" + prefix + "\": " + count
        );
        System.out.println(
                "\nLongest word: " + longestWord()
        );
    }
}
