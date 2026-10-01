package AdvancedDSA.DisjointSet;
import java.util.Scanner;
public class UnionOperation {
    static int[] parent;
    static void makeSet(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
    static int find(int element) {
        while (parent[element] != element) {
            element = parent[element];
        }
        return element;
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            System.out.println(
                a + " and " + b + " are already in the same set."
            );
            return;
        }
        parent[rootB] = rootA;
        System.out.println(
            "Set containing " + a
            + " and set containing " + b
            + " have been merged."
        );
    }
    static void display(int n) {
        System.out.println("\nElement -> Parent");
        for (int i = 1; i <= n; i++) {
            System.out.println(
                i + " -> " + parent[i]
            );
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Number of elements must be positive.");
            sc.close();
            return;
        }
        makeSet(n);
        System.out.println("\nInitial Sets:");
        display(n);
        System.out.print("\nEnter number of union operations: ");
        int operations = sc.nextInt();
        for (int i = 1; i <= operations; i++) {
            System.out.print(
                "\nEnter two elements for union " + i + ": "
            );
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a >= 1 && a <= n &&
                b >= 1 && b <= n) {
                union(a, b);
            } else {
                System.out.println("Invalid elements.");
            }
        }
        System.out.println("\nFinal DSU Structure:");
        display(n);
    }
}
