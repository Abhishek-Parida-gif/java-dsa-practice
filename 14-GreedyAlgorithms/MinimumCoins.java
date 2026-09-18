import java.util.*;
public class MinimumCoins {
    static void findMinimumCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        System.out.println("\nCoins used:");
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
                System.out.println(coins[i]);
            }
        }
        if (amount == 0) {
            System.out.println("\nMinimum number of coins = " + count);
        } else {
            System.out.println("\nAmount cannot be formed using given coins.");
        }
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
        findMinimumCoins(coins, amount);
    }
}
