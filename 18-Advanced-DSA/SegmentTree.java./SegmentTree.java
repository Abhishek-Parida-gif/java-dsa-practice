package AdvancedDSA.SegmentTree;
import java.util.Scanner;
public class SegmentTree {
    static int[] tree;
    static int[] arr;
    static void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(2 * node, start, mid);
        buildTree(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
    static int rangeSum(
            int node,
            int start,
            int end,
            int queryLeft,
            int queryRight) {
        if (queryRight < start || queryLeft > end) {
            return 0;
        }
        if (queryLeft <= start && end <= queryRight) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftSum = rangeSum(
                2 * node,
                start,
                mid,
                queryLeft,
                queryRight
        );
        int rightSum = rangeSum(
                2 * node + 1,
                mid + 1,
                end,
                queryLeft,
                queryRight
        );
        return leftSum + rightSum;
    }
    static void update(
            int node,
            int start,
            int end,
            int index,
            int value) {
        if (start == end) {
            arr[index] = value;
            tree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            update(
                    2 * node,
                    start,
                    mid,
                    index,
                    value
            );
        }
        else {
            update(
                    2 * node + 1,
                    mid + 1,
                    end,
                    index,
                    value
            );
        }
        tree[node] =
                tree[2 * node] +
                tree[2 * node + 1];
    }
    static void displayArray() {
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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
        System.out.print("\nEnter left index for range sum: ");
        int left = sc.nextInt();
        System.out.print("Enter right index for range sum: ");
        int right = sc.nextInt();
        int sum = rangeSum(
                1,
                0,
                n - 1,
                left,
                right
        );
        System.out.println(
                "Sum from index " + left +
                " to " + right +
                " = " + sum
        );
        System.out.print("\nEnter index to update: ");
        int index = sc.nextInt();
        System.out.print("Enter new value: ");
        int value = sc.nextInt();
        update(
                1,
                0,
                n - 1,
                index,
                value
        );
        System.out.println("\nAfter update:");
        displayArray();
        displayTree();
    }
}
