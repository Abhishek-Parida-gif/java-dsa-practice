import java.util.Scanner;
public class HouseRobber {
    static int maxRobAmount(int[] money) {
        int n = money.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return money[0];
        }
        int[] dp = new int[n];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();
        int[] money = new int[n];
        System.out.println("Enter money in each house:");
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }
        int result = maxRobAmount(money);
        System.out.println("Maximum money that can be robbed = " + result);
    }
}
