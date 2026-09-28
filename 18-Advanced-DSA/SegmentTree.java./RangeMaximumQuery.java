package AdvancedDSA.SegmentTree;
import java.util.Scanner;
public class RangeMaximumQuery {
    static int[] arr;
    static int[] tree;
    static void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(2 * node, start, mid);
        buildTree(2 * node + 1, mid + 1, end);
        tree[node] = Math.max(
                tree[2 * node],
                tree[2 * node + 1]
        );
    }
    static int rangeMaximum(
            int node,
            int start,
            int end,
            int queryLeft,
            int queryRight) {
        if (queryRight < start || queryLeft > end) {
            return Integer.MIN_VALUE;
        }
        if (queryLeft <= start && end <= queryRight) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftMaximum = rangeMaximum(
                2 * node,
                start,
                mid,
                queryLeft,
                queryRight
        );
        int rightMaximum = rangeMaximum(
                2 * node + 1,
                mid + 1,
                end,
                queryLeft,
                queryRight
        );
        return Math.max(leftMaximum, rightMaximum);
    }
    static void displayArray() {
        System.out.print("Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    static void displayTree() {
        System.out.print("Segment Tree: ");
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] != 0) {
                System.out.print(tree[i] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        tree = new int[4 * n];
        buildTree(1, 0, n - 1);
        System.out.println("\nSegment Tree created successfully.");
        displayArray();
        displayTree();
        System.out.print("\nEnter number of queries: ");
        int q = sc.nextInt();
        for (int i = 1; i <= q; i++) {
            System.out.println("\nQuery " + i);
            System.out.print("Enter left index: ");
            int left = sc.nextInt();
            System.out.print("Enter right index: ");
            int right = sc.nextInt();
            if (left < 0 || right >= n || left > right) {
                System.out.println("Invalid range.");
                continue;
            }
            int result = rangeMaximum(
                    1,
                    0,
                    n - 1,
                    left,
                    right
            );
            System.out.println(
                    "Maximum from index " +
                    left +
                    " to " +
                    right +
                    " = " +
                    result
            );
        }
    }
}
