import java.util.ArrayList;
import java.util.Scanner;
public class AdjacencyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            // Undirected graph
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int node : graph.get(i)) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
