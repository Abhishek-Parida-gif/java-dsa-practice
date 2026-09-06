import java.util.Arrays;
import java.util.Scanner;
public class FloydWarshall {
    static final int INF = 1000000000;
    // Floyd-Warshall Algorithm
    static void floydWarshall(int[][] distance, int vertices) {
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (distance[i][k] != INF
                            && distance[k][j] != INF) {
                        distance[i][j] = Math.min(
                                distance[i][j],
                                distance[i][k] + distance[k][j]
                        );
                    }
                }
            }
        }
    }
    // Display shortest distance matrix
    static void display(int[][] distance, int vertices) {
        System.out.println("\nShortest Distance Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (distance[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        int[][] distance = new int[vertices][vertices];
        // Initialize matrix
        for (int i = 0; i < vertices; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        System.out.println(
                "Enter edges (source destination weight):"
        );
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();

            distance[source][destination] = weight;
        }
        floydWarshall(distance, vertices);
        display(distance, vertices);
        // Check for negative weight cycle
        boolean negativeCycle = false;
        for (int i = 0; i < vertices; i++) {
            if (distance[i][i] < 0) {
                negativeCycle = true;
                break;
            }
        }
        if (negativeCycle) {
            System.out.println(
                    "\nNegative weight cycle detected!"
            );
        } else {
            System.out.println(
                    "\nNo negative weight cycle detected."
            );
        }
    }
}
