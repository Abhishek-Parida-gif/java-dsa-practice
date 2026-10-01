package AdvancedDSA.DisjointSet;
import java.util.Scanner;
public class DSUProblems {
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
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        return true;
    }
    static int countSets(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }
    static void display(int n) {
        System.out.println("\nElement -> Parent -> Set Size");
        for (int i = 1; i <= n; i++) {
            System.out.println(
                i + " -> "
                + parent[i] + " -> "
                + size[i]
            );
        }
    }
    static boolean connected(int a, int b) {
        return find(a) == find(b);
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
        System.out.println("\nInitial DSU:");
        display(n);
        System.out.print(
            "\nEnter number of union operations: "
        );
        int operations = sc.nextInt();
        for (int i = 1; i <= operations; i++) {
            System.out.print(
                "Enter two elements for union "
                + i + ": "
            );
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a >= 1 && a <= n &&
                b >= 1 && b <= n) {
                if (union(a, b)) {
                    System.out.println(
                        "Union successful."
                    );
                } else {
                    System.out.println(
                        "Both elements are already "
                        + "in the same set."
                    );
                }
            } else {
                System.out.println(
                    "Invalid elements."
                );
            }
        }
        System.out.println("\nFinal DSU:");
        display(n);
        System.out.println(
            "\nNumber of separate sets: "
            + countSets(n)
        );
        System.out.print(
            "\nEnter element to find its representative: "
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
        System.out.print(
            "\nEnter two elements to check connectivity: "
        );
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a >= 1 && a <= n &&
            b >= 1 && b <= n) {
            if (connected(a, b)) {
                System.out.println(
                    a + " and " + b
                    + " belong to the same set."
                );
            } else {
                System.out.println(
                    a + " and " + b
                    + " belong to different sets."
                );
            }
        } else {
            System.out.println(
                "Invalid elements."
            );
        }
    }
}
