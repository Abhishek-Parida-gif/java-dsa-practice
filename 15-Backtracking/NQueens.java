import java.util.*;
public class NQueens {
    static int n;
    static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    static boolean solveNQueens(char[][] board, int row) {
        if (row == n) {
            printBoard(board);
            return true;
        }
        boolean solutionFound = false;
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                if (solveNQueens(board, row + 1)) {
                    solutionFound = true;
                }
                board[row][col] = '.';
            }
        }
        return solutionFound;
    }
    static void printBoard(char[][] board) {
        System.out.println("\nSolution:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        n = sc.nextInt();
        if (n <= 0) {
            System.out.println("N must be greater than 0.");
            sc.close();
            return;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        System.out.println("\nN-Queens Solutions:");
        boolean solutionFound = solveNQueens(board, 0);
        if (!solutionFound) {
            System.out.println("\nNo solution exists for N = " + n);
        }
    }
}
