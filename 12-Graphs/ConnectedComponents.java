import java.util.ArrayList;
import java.util.Scanner;
public class ConnectedComponents {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    // DFS traversal
    static void dfs(int current) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
    // Count connected components
    static int countComponents(int vertices) {
        int count = 0;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                count++;
                System.out.print("Component " + count + ": ");
                dfs(i);
                System.out.println();
            }
        }
        return count;
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
        System.out.println("\nConnected Components:");
        int components = countComponents(vertices);
        System.out.println("\nTotal Connected Components: " + components);
    }
}
