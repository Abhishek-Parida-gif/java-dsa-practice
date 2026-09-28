package AdvancedDSA.FenwickTree;
import java.util.Scanner;
public class FenwickTree {
    static int[] tree;
    static int[] arr;
    static void update(int index, int value) {
        index++;
        while (index < tree.length) {
            tree[index] += value;
            index += index & (-index);
        }
    }
    static int prefixSum(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            // Move to parent index
            index -= index & (-index);
        }
        return sum;
    }
    static void displayArray() {
        System.out.print("Original Array: ");
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
        arr = new int[n];
        tree = new int[n + 1];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            update(i, arr[i]);
        }
        displayArray();
        displayTree();
        System.out.print("Enter index for prefix sum: ");
        int index = sc.nextInt();
        if (index >= 0 && index < n) {
            System.out.println(
                "Prefix Sum from index 0 to " + index + ": "
                + prefixSum(index)
            );
        } else {
            System.out.println("Invalid index.");
        }
        System.out.print("Enter index to update: ");
        int updateIndex = sc.nextInt();
        System.out.print("Enter new value: ");
        int newValue = sc.nextInt();
        if (updateIndex >= 0 && updateIndex < n) {
            int difference = newValue - arr[updateIndex];
            arr[updateIndex] = newValue;
            update(updateIndex, difference);
            System.out.println("\nAfter Update:");
            displayArray();
            displayTree();
        } else {
            System.out.println("Invalid index.");
        }
    }
}
