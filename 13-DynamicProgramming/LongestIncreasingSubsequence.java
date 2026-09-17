import java.util.Scanner;
public class LongestIncreasingSubsequence {
    static int findLIS(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(
                        dp[i],
                        dp[j] + 1
                    );
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = findLIS(arr);
        System.out.println("Length of Longest Increasing Subsequence = " + result);
    }
}
