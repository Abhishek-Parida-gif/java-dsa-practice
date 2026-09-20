import java.util.*;
public class RatInMaze {
    static int n;
    static boolean isSafe(int[][] maze, int row, int col) {
        return row >= 0 &&
               row < n &&
               col >= 0 &&
               col < n &&
               maze[row][col] == 1;
    }
    static boolean solveMaze(int[][] maze, int[][] solution,
                             int row, int col) {
        if (row == n - 1 && col == n - 1) {
            solution[row][col] = 1;
            return true;
        }
        if (isSafe(maze, row, col)) {
            solution[row][col] = 1;
            if (solveMaze(maze, solution, row + 1, col)) {
                return true;
            }
            if (solveMaze(maze, solution, row, col + 1)) {
                return true;
            }
            if (solveMaze(maze, solution, row - 1, col)) {
                return true;
            }
            if (solveMaze(maze, solution, row, col - 1)) {
                return true;
            }
            solution[row][col] = 0;
        }
        return false;
    }
    static void printSolution(int[][] solution) {
        System.out.println("\nPath:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maze size: ");
        n = sc.nextInt();
        int[][] maze = new int[n][n];
        int[][] solution = new int[n][n];
        System.out.println("Enter maze values:");
        System.out.println("1 = Open path, 0 = Blocked");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        if (solveMaze(maze, solution, 0, 0)) {
            printSolution(solution);
        } else {
            System.out.println("\nNo path exists.");
        }
    }
}
