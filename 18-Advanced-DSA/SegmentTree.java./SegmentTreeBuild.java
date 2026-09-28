package AdvancedDSA.SegmentTree;
import java.util.Scanner;
public class SegmentTreeBuild {
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
    static void displayArray() {
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void displayTree(int node, int start, int end) {
        if (start == end) {
            System.out.println(
                    "Node " + node +
                    " -> Index [" + start + "]" +
                    " -> Value = " + tree[node]
            );
            return;
        }
        int mid = (start + end) / 2;
        System.out.println(
                "Node " + node +
                " -> Range [" + start + ", " + end + "]" +
                " -> Sum = " + tree[node]
        );
        displayTree(2 * node, start, mid);
        displayTree(2 * node + 1, mid + 1, end);
    }
    static void displayTreeArray() {
        System.out.print("\nSegment Tree Array: ");
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
        System.out.println("\nSegment Tree built successfully!");
        displayArray();
        System.out.println("\nSegment Tree Structure:");
        displayTree(1, 0, n - 1);
        displayTreeArray();
    }
}
