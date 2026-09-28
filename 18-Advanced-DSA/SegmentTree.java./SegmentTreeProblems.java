package AdvancedDSA.SegmentTree;
import java.util.Scanner;
public class SegmentTreeProblems {
    static int[] arr;
    static int[] sumTree;
    static int[] minTree;
    static int[] maxTree;
    static void buildSumTree(int node, int start, int end) {
        if (start == end) {
            sumTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildSumTree(2 * node, start, mid);
        buildSumTree(2 * node + 1, mid + 1, end);
        sumTree[node] =
                sumTree[2 * node] +
                sumTree[2 * node + 1];
    }
    static void buildMinTree(int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildMinTree(2 * node, start, mid);
        buildMinTree(2 * node + 1, mid + 1, end);
        minTree[node] = Math.min(
                minTree[2 * node],
                minTree[2 * node + 1]
        );
    }
    static void buildMaxTree(int node, int start, int end) {
        if (start == end) {
            maxTree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildMaxTree(2 * node, start, mid);
        buildMaxTree(2 * node + 1, mid + 1, end);
        maxTree[node] = Math.max(
                maxTree[2 * node],
                maxTree[2 * node + 1]
        );
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
            return sumTree[node];
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
    static int rangeMinimum(
            int node,
            int start,
            int end,
            int left,
            int right) {
        if (right < start || left > end) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return minTree[node];
        }
        int mid = (start + end) / 2;
        int leftMin = rangeMinimum(
                2 * node,
                start,
                mid,
                left,
                right
        );
        int rightMin = rangeMinimum(
                2 * node + 1,
                mid + 1,
                end,
                left,
                right
        );
        return Math.min(leftMin, rightMin);
    }
    static int rangeMaximum(
            int node,
            int start,
            int end,
            int left,
            int right) {
        if (right < start || left > end) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }
        int mid = (start + end) / 2;
        int leftMax = rangeMaximum(
                2 * node,
                start,
                mid,
                left,
                right
        );
        int rightMax = rangeMaximum(
                2 * node + 1,
                mid + 1,
                end,
                left,
                right
        );
        return Math.max(leftMax, rightMax);
    }
    static void updateSumTree(
            int node,
            int start,
            int end,
            int index,
            int value) {
        if (start == end) {
            sumTree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            updateSumTree(
                    2 * node,
                    start,
                    mid,
                    index,
                    value
            );
        } else {
            updateSumTree(
                    2 * node + 1,
                    mid + 1,
                    end,
                    index,
                    value
            );
        }
        sumTree[node] =
                sumTree[2 * node] +
                sumTree[2 * node + 1];
    }
    static void updateMinTree(
            int node,
            int start,
            int end,
            int index,
            int value) {
        if (start == end) {
            minTree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            updateMinTree(
                    2 * node,
                    start,
                    mid,
                    index,
                    value
            );
        } else {
            updateMinTree(
                    2 * node + 1,
                    mid + 1,
                    end,
                    index,
                    value
            );
        }
        minTree[node] = Math.min(
                minTree[2 * node],
                minTree[2 * node + 1]
        );
    }
    static void updateMaxTree(
            int node,
            int start,
            int end,
            int index,
            int value) {
        if (start == end) {
            maxTree[node] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            updateMaxTree(
                    2 * node,
                    start,
                    mid,
                    index,
                    value
            );
        } else {
            updateMaxTree(
                    2 * node + 1,
                    mid + 1,
                    end,
                    index,
                    value
            );
        }
        maxTree[node] = Math.max(
                maxTree[2 * node],
                maxTree[2 * node + 1]
        );
    }
    static void update(
            int node,
            int start,
            int end,
            int index,
            int value) {
        updateSumTree(
                node,
                start,
                end,
                index,
                value
        );
        updateMinTree(
                node,
                start,
                end,
                index,
                value
        );
        updateMaxTree(
                node,
                start,
                end,
                index,
                value
        );
        arr[index] = value;
    }
    static void displayArray() {
        System.out.print("Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    static void displaySummary(int n) {
        System.out.println("\n========== TREE SUMMARY ==========");
        System.out.println(
                "Total Sum: " +
                sumTree[1]
        );
        System.out.println(
                "Minimum Value: " +
                minTree[1]
        );
        System.out.println(
                "Maximum Value: " +
                maxTree[1]
        );
        System.out.println("==================================");
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
        sumTree = new int[4 * n];
        minTree = new int[4 * n];
        maxTree = new int[4 * n];
        buildSumTree(1, 0, n - 1);
        buildMinTree(1, 0, n - 1);
        buildMaxTree(1, 0, n - 1);
        System.out.println(
                "\nSegment Trees created successfully."
        );
        displayArray();
        displaySummary(n);
        System.out.print(
                "\nEnter left index for query: "
        );
        int left = sc.nextInt();
        System.out.print(
                "Enter right index for query: "
        );
        int right = sc.nextInt();
        if (left >= 0 &&
            right < n &&
            left <= right) {
            int sum = rangeSum(
                    1,
                    0,
                    n - 1,
                    left,
                    right
            );
            int minimum = rangeMinimum(
                    1,
                    0,
                    n - 1,
                    left,
                    right
            );
            int maximum = rangeMaximum(
                    1,
                    0,
                    n - 1,
                    left,
                    right
            );
            System.out.println(
                    "\n========== RANGE RESULTS =========="
            );
            System.out.println(
                    "Range: [" +
                    left +
                    ", " +
                    right +
                    "]"
            );
            System.out.println(
                    "Sum = " + sum
            );
            System.out.println(
                    "Minimum = " + minimum
            );
            System.out.println(
                    "Maximum = " + maximum
            );
            System.out.println(
                    "==================================="
            );
        } else {
            System.out.println("Invalid range.");
        }
        System.out.print(
                "\nEnter index to update: "
        );
        int index = sc.nextInt();
        System.out.print(
                "Enter new value: "
        );
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
            System.out.println(
                    "\nAfter update:"
            );
            displayArray();
            displaySummary(n);
        } else {
            System.out.println("Invalid index.");
        }
    }
}
