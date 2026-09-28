package AdvancedDSA.SegmentTree;
import java.util.Scanner;
public class SegmentTreeUpdate {
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
        tree[node] =
                tree[2 * node] +
                tree[2 * node + 1];
    }
    static void update(
            int node,
            int start,
            int end,
            int index,
            int newValue) {
        if (start == end) {
            arr[index] = newValue;
            tree[node] = newValue;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            update(
                    2 * node,
                    start,
                    mid,
                    index,
                    newValue
            );
        }
        else {
            update(
                    2 * node + 1,
                    mid + 1,
                    end,
                    index,
                    newValue
            );
        }
        tree[node] =
                tree[2 * node] +
                tree[2 * node + 1];
    }
    static int rangeSum(
            int node,
            int start,
            int end,
            int left,
            int right) {
        if (right < start || left > end) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftSum = rangeSum(
                2 * node,
                start,
                mid,
                left,
                right
        );
        int rightSum = rangeSum(
                2 * node + 1,
                mid + 1,
                end,
                left,
                right
        );
        return leftSum + rightSum;
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
        System.out.print("\nEnter left index for sum: ");
        int left = sc.nextInt();
        System.out.print("Enter right index for sum: ");
        int right = sc.nextInt();
        if (left >= 0 && right < n && left <= right) {
            int sum = rangeSum(
                    1,
                    0,
                    n - 1,
                    left,
                    right
            );
            System.out.println(
                    "Sum from index " +
                    left +
                    " to " +
                    right +
                    " = " +
                    sum
            );
        } else {
            System.out.println("Invalid range.");
        }
        System.out.print("\nEnter index to update: ");
        int index = sc.nextInt();
        System.out.print("Enter new value: ");
        int newValue = sc.nextInt();
        if (index >= 0 && index < n) {
            System.out.println(
                    "\nUpdating index " +
                    index +
                    " from " +
                    arr[index] +
                    " to " +
                    newValue
            );
            update(
                    1,
                    0,
                    n - 1,
                    index,
                    newValue
            );
            System.out.println("\nAfter update:");
            displayArray();
            displayTree();
        } else {
            System.out.println("Invalid index.");
        }
        System.out.print(
                "\nEnter left index for new sum: "
        );
        left = sc.nextInt();
        System.out.print(
                "Enter right index for new sum: "
        );
        right = sc.nextInt();
        if (left >= 0 && right < n && left <= right) {
            int sum = rangeSum(
                    1,
                    0,
                    n - 1,
                    left,
                    right
            );
            System.out.println(
                    "New sum from index " +
                    left +
                    " to " +
                    right +
                    " = " +
                    sum
            );
        } else {
            System.out.println("Invalid range.");
        }
    }
}
