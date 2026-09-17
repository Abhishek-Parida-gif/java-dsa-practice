import java.util.Scanner;
public class PartitionEqualSubsetSum {
    static boolean canPartition(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : arr) {
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }
        return dp[target];
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
        if (canPartition(arr)) {
            System.out.println("Array can be partitioned into two equal subsets.");
        } else {
            System.out.println("Array cannot be partitioned into two equal subsets.");
        }
    }
}
