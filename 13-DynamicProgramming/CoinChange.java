import java.util.Scanner;
public class CoinChange {
    static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(
                        dp[i],
                        dp[i - coin] + 1
                    );
                }
            }
        }
        if (dp[amount] > amount) {
            return -1;
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter coin values:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();
        int result = minCoins(coins, amount);
        if (result == -1) {
            System.out.println("Amount cannot be formed.");
        } else {
            System.out.println("Minimum number of coins = " + result);
        }
    }
}
