import java.util.Scanner;
public class LongestCommonSubsequence {
    static int lcs(String first, String second) {
        int m = first.length();
        int n = second.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = sc.nextLine();
        System.out.print("Enter second string: ");
        String second = sc.nextLine();
        int result = lcs(first, second);
        System.out.println("Length of Longest Common Subsequence = " + result);
    }
}
