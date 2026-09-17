import java.util.Scanner;
public class MatrixChainMultiplication {
    static int matrixChainMultiplication(int[] dimensions) {
        int n = dimensions.length - 1;
        int[][] dp = new int[n][n];
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k]
                            + dp[k + 1][j]
                            + dimensions[i]
                            * dimensions[k + 1]
                            * dimensions[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();
        int[] dimensions = new int[n + 1];
        System.out.println(
            "Enter dimensions (" + (n + 1) + " values):"
        );
        for (int i = 0; i <= n; i++) {
            dimensions[i] = sc.nextInt();
        }
        int result = matrixChainMultiplication(dimensions);
        System.out.println(
            "Minimum number of multiplications = " + result
        );
    }
}
