package AdvancedDSA.DisjointSet;
import java.util.Scanner;
public class UnionBySize {
    static int[] parent;
    static int[] size;
    static void makeSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    static int find(int element) {
        if (parent[element] != element) {
            parent[element] = find(parent[element]);
        }
        return parent[element];
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            System.out.println(
                a + " and " + b
                + " are already in the same set."
            );
            return;
        }
        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        System.out.println(
            "Set containing " + a
            + " and set containing " + b
            + " have been merged."
        );
    }
    static void display(int n) {
        System.out.println("\nElement -> Parent -> Size");
        for (int i = 1; i <= n; i++) {
            System.out.println(
                i + " -> "
                + parent[i] + " -> "
                + size[i]
            );
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println(
                "Number of elements must be positive."
            );
            sc.close();
            return;
        }
        makeSet(n);
        System.out.println("\nInitial Sets:");
        display(n);
        System.out.print(
            "\nEnter number of union operations: "
        );
        int operations = sc.nextInt();
        for (int i = 1; i <= operations; i++) {
            System.out.print(
                "\nEnter two elements for union "
                + i + ": "
            );
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a >= 1 && a <= n &&
                b >= 1 && b <= n) {
                union(a, b);
            } else {
                System.out.println(
                    "Invalid elements."
                );
            }
        }
        System.out.println("\nFinal DSU Structure:");
        display(n);
        System.out.print(
            "\nEnter element to find: "
        );
        int element = sc.nextInt();
        if (element >= 1 && element <= n) {
            int representative = find(element);
            System.out.println(
                "Representative of "
                + element + " = "
                + representative
            );
        } else {
            System.out.println(
                "Invalid element."
            );
        }
    }
}
