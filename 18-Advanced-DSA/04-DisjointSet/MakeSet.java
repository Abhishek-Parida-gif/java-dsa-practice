package AdvancedDSA.DisjointSet;
import java.util.Scanner;
public class MakeSet {
    static int[] parent;
    static void makeSet(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
    static void displaySets(int n) {
        System.out.println("\nDisjoint Sets:");
        for (int i = 1; i <= n; i++) {
            System.out.println(
                "Element " + i + " -> Parent " + parent[i]
            );
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Number of elements must be positive.");
        } else {
            makeSet(n);
            System.out.println("\nEach element is now in its own set.");
            displaySets(n);
        }
    }
}
