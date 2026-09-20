import java.util.*;
public class WordSearch {
    static int rows;
    static int cols;
    static boolean searchWord(
            char[][] board,
            String word,
            int row,
            int col,
            int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        char original = board[row][col];
        board[row][col] = '#';
        boolean found =
                searchWord(board, word, row + 1, col, index + 1) ||
                searchWord(board, word, row - 1, col, index + 1) ||
                searchWord(board, word, row, col + 1, index + 1) ||
                searchWord(board, word, row, col - 1, index + 1);
        board[row][col] = original;
        return found;
    }
    static boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (searchWord(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        cols = sc.nextInt();
        char[][] board = new char[rows][cols];
        System.out.println("Enter characters:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }
        System.out.print("Enter word to search: ");
        String word = sc.next();
        if (exist(board, word)) {
            System.out.println("\nWord found!");
        } else {
            System.out.println("\nWord not found.");
        }
    }
}
