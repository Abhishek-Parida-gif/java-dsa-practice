import java.util.*;
public class SudokuSolver {
    static final int SIZE = 9;
    static boolean isSafe(int[][] board, int row, int col, int number) {
        for (int j = 0; j < SIZE; j++) {
            if (board[row][j] == number) {
                return false;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (isSafe(board, row, col, number)) {
                            board[row][col] = number;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static void printBoard(int[][] board) {
        System.out.println("\nSolved Sudoku:");
        for (int i = 0; i < SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[SIZE][SIZE];
        System.out.println("Enter Sudoku puzzle:");
        System.out.println("Use 0 for empty cells.");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("\nNo solution exists.");
        }
    }
}
