import java.util.Scanner;
public class LongestPalindromicSubsequence {
    static int findLPS(String str) {
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (length == 2) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(
                        dp[i + 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int result = findLPS(str);
        System.out.println(
            "Length of Longest Palindromic Subsequence = " + result
        );
    }
}
