package AdvancedDSA.FenwickTree;
import java.util.Scanner;
public class FenwickUpdate {
    static int[] tree;
    static void update(int index, int value, int n) {
        index++;
        while (index <= n) {
            tree[index] += value;
            index += index & (-index);
        }
    }
    static int prefixSum(int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }
    static void buildTree(int[] arr) {
        int n = arr.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, arr[i], n);
        }
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
        System.out.println("\nBefore Update:");
        displayArray(arr);
        displayTree();
        System.out.print("\nEnter index to update: ");
        int index = sc.nextInt();
        System.out.print("Enter new value: ");
        int newValue = sc.nextInt();
        if (index >= 0 && index < n) {
            int difference = newValue - arr[index];
            arr[index] = newValue;
            update(index, difference, n);
            System.out.println("\nAfter Update:");
            displayArray(arr);
            displayTree();
            System.out.println(
                "Total Sum: " + prefixSum(n - 1)
            );
        } else {
            System.out.println("Invalid index.");
        }
    }
}
