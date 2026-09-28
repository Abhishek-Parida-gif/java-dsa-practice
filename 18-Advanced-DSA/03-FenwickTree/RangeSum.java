package AdvancedDSA.FenwickTree;
import java.util.Scanner;
public class RangeSum {
    static int[] tree;
    static void update(int index, int value, int n) {
        index++;
        while (index <= n) {
            tree[index] += value;
            index += index & (-index);
        }
    }
    static void buildTree(int[] arr) {
        int n = arr.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, arr[i], n);
        }
    }
    static int prefixSum(int index) {
        if (index < 0) {
            return 0;
        }
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }
    static int rangeSum(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }
    static void displayArray(int[] arr) {
        System.out.print("Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    static void displayTree() {
        System.out.print("Fenwick Tree: ");
        for (int i = 1; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        buildTree(arr);
        System.out.println("\nFenwick Tree:");
        displayArray(arr);
        displayTree();
        System.out.print("\nHow many range sum queries? ");
        int queries = sc.nextInt();
        for (int i = 1; i <= queries; i++) {
            System.out.print("\nEnter left index for query " + i + ": ");
            int left = sc.nextInt();
            System.out.print("Enter right index for query " + i + ": ");
            int right = sc.nextInt();
            if (left >= 0 && right < n && left <= right) {
                int result = rangeSum(left, right);
                System.out.println(
                    "Range Sum [" + left + " to " + right + "] = " + result
                );
            } else {
                System.out.println("Invalid range.");
            }
        }
    }
}
