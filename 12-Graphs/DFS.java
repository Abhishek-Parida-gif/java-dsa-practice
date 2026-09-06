import java.util.ArrayList;
import java.util.Scanner;
public class DFS {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static void dfs(int current) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
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
        System.out.print("\nEnter starting vertex: ");
        int start = sc.nextInt();
        if (start < 0 || start >= vertices) {
            System.out.println("Invalid starting vertex.");
        } else {
            System.out.print("DFS Traversal: ");
            dfs(start);
            System.out.println();
        }
    }
}
