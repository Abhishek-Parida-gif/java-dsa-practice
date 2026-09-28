package AdvancedDSA.FenwickTree;
import java.util.Scanner;
public class FenwickBuild {
    static int[] tree;
    static void buildTree(int[] arr) {
        int n = arr.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int index = i + 1;
            while (index <= n) {
                tree[index] += arr[i];
                index += index & (-index);
            }
        }
    }
    static void displayArray(int[] arr) {
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
    static int prefixSum(int index) {

        int sum = 0;
        index++;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
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
        System.out.println();
        displayArray(arr);
        displayTree();
        System.out.print("\nEnter index for prefix sum: ");
        int index = sc.nextInt();
        if (index >= 0 && index < n) {
            System.out.println(
                "Prefix Sum from index 0 to " + index + ": "
                + prefixSum(index)
            );
        } else {
            System.out.println("Invalid index.");
        }
    }
}
