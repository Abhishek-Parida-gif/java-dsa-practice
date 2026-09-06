import java.util.ArrayList;
import java.util.Scanner;
public class DetectCycle {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    // DFS cycle detection
    static boolean hasCycle(int current, int parent) {
        visited[current] = true;
        for (int neighbor : graph.get(current)) {
            // If neighbor is not visited, continue DFS
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, current)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Visited neighbor that is not the parent
                // means a cycle exists
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        graph = new ArrayList<>();
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
        visited = new boolean[vertices];
        boolean cycleFound = false;
        // Check every component
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (hasCycle(i, -1)) {
                    cycleFound = true;
                    break;
                }
            }
        }
        if (cycleFound) {
            System.out.println("\nCycle detected in the graph.");
        } else {
            System.out.println("\nNo cycle found in the graph.");
        }
    }
}
