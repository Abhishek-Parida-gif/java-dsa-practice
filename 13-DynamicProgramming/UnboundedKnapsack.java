import java.util.Scanner;
public class UnboundedKnapsack {
    static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        for (int w = 1; w <= capacity; w++) {
            for (int i = 0; i < n; i++) {
                if (weights[i] <= w) {
                    dp[w] = Math.max(
                        dp[w],
                        values[i] + dp[w - weights[i]]
                    );
                }
            }
        }
        return dp[capacity];
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
        int result = unboundedKnapsack(weights, values, capacity);
        System.out.println("Maximum value = " + result);
    }
}
