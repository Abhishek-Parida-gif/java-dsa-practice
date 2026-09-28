package AdvancedDSA.FenwickTree;
import java.util.Scanner;
public class FenwickProblems {
    static int[] tree;
    static int[] arr;
    static void update(int index, int difference) {
        index++;
        while (index < tree.length) {
            tree[index] += difference;
            index += index & (-index);
        }
    }
    static void buildTree() {
        tree = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
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
    static void displayArray() {
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
    static void display() {
        displayArray();
        displayTree();
        System.out.println("Total Sum: " + prefixSum(arr.length - 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        buildTree();
        System.out.println("\nInitial Fenwick Tree:");
        display();
        System.out.print("\nEnter index for prefix sum: ");
        int prefixIndex = sc.nextInt();
        if (prefixIndex >= 0 && prefixIndex < n) {
            System.out.println(
                "Prefix Sum [0 to " + prefixIndex + "] = "
                + prefixSum(prefixIndex)
            );
        } else {
            System.out.println("Invalid index.");
        }
        System.out.print("\nEnter left index: ");
        int left = sc.nextInt();
        System.out.print("Enter right index: ");
        int right = sc.nextInt();
        if (left >= 0 && right < n && left <= right) {
            System.out.println(
                "Range Sum [" + left + " to " + right + "] = "
                + rangeSum(left, right)
            );
        } else {
            System.out.println("Invalid range.");
        }
        System.out.print("\nEnter index to update: ");
        int updateIndex = sc.nextInt();
        System.out.print("Enter new value: ");
        int newValue = sc.nextInt();
        if (updateIndex >= 0 && updateIndex < n) {
            int difference = newValue - arr[updateIndex];
            arr[updateIndex] = newValue;
            update(updateIndex, difference);
            System.out.println("\nAfter Update:");
            display();
        } else {
            System.out.println("Invalid index.");
        }
        System.out.print("\nEnter left index for final range sum: ");
        left = sc.nextInt();
        System.out.print("Enter right index for final range sum: ");
        right = sc.nextInt();
        if (left >= 0 && right < n && left <= right) {
            System.out.println(
                "Final Range Sum [" + left + " to " + right + "] = "
                + rangeSum(left, right)
            );
        } else {
            System.out.println("Invalid range.");
        }
    }
}
