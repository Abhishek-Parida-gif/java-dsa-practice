package Tries;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class PalindromePairs {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordIndex = -1;
        List<Integer> palindromeSuffixIndexes = new ArrayList<>();
    }
    static TrieNode root = new TrieNode();
    static boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    static void insert(String word, int index) {
        TrieNode current = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (isPalindrome(word, 0, i)) {
                current.palindromeSuffixIndexes.add(index);
            }
            int charIndex = word.charAt(i) - 'a';
            if (current.children[charIndex] == null) {
                current.children[charIndex] = new TrieNode();
            }
            current = current.children[charIndex];
        }
        current.wordIndex = index;
    }
    static List<List<Integer>> findPalindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            TrieNode current = root;
            String word = words[i];
            boolean stopped = false;
            for (int j = 0; j < word.length(); j++) {
                if (current.wordIndex != -1
                        && current.wordIndex != i
                        && isPalindrome(word, j, word.length() - 1)) {
                    addPair(result, i, current.wordIndex);
                }
                int charIndex = word.charAt(j) - 'a';
                if (current.children[charIndex] == null) {
                    stopped = true;
                    break;
                }
                current = current.children[charIndex];
            }
            if (stopped) {
                continue;
            }
            if (current.wordIndex != -1
                    && current.wordIndex != i) {
                addPair(result, i, current.wordIndex);
            }
            for (int index : current.palindromeSuffixIndexes) {
                if (index != i) {
                    addPair(result, i, index);
                }
            }
        }
        return result;
    }
    static void addPair(List<List<Integer>> result,
                         int first,
                         int second) {
        List<Integer> pair = new ArrayList<>();
        pair.add(first);
        pair.add(second);
        result.add(pair);
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
        List<List<Integer>> result =
                findPalindromePairs(words);
        System.out.println("\nPalindrome Pairs:");
        for (List<Integer> pair : result) {
            int first = pair.get(0);
            int second = pair.get(1);
            System.out.println(
                    "(" + first + ", " + second + ")"
                    + " -> "
                    + words[first] + " + " + words[second]
                    + " = "
                    + words[first] + words[second]
            );
        }
    }
}
