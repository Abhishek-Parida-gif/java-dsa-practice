import java.util.Scanner;
public class Knapsack01 {
    static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i][w],
                        values[i - 1] + dp[i - 1][w - weights[i - 1]]
                    );
                }
            }
        }
        return dp[n][capacity];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();
        int result = knapsack(weights, values, capacity);
        System.out.println("Maximum value = " + result);
    }
}
