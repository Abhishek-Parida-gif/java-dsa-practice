package Tries;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class WordSearchTrie {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
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
        current.word = word;
    }
    static void search(char[][] board,
                       int row,
                       int col,
                       TrieNode node,
                       List<String> result) {
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }
        char ch = board[row][col];
        if (ch == '#') {
            return;
        }
        int index = ch - 'a';
        if (node.children[index] == null) {
            return;
        }
        TrieNode current = node.children[index];
        if (current.word != null) {
            result.add(current.word);
            current.word = null;
        }
        board[row][col] = '#';
        search(board, row - 1, col, current, result);
        search(board, row + 1, col, current, result);
        search(board, row, col - 1, current, result);
        search(board, row, col + 1, current, result);
        board[row][col] = ch;
    }
    static List<String> findWords(char[][] board,
                                   String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            insert(word);
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                search(board, row, col, root, result);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        char[][] board = new char[rows][cols];
        System.out.println("Enter board characters:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = sc.next().toLowerCase().charAt(0);
            }
        }
        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        String[] words = new String[n];
        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.next().toLowerCase();
        }
        List<String> result = findWords(board, words);
        System.out.println("\nWords Found:");
        if (result.isEmpty()) {
            System.out.println("No words found.");
        } else {
            for (String word : result) {
                System.out.println(word);
            }
        }
    }
}
