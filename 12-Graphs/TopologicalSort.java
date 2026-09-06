import java.util.*;
public class TopologicalSort {
    static void topologicalSort(int vertices, ArrayList<ArrayList<Integer>> graph) {
        int[] indegree = new int[vertices];
        // Calculate indegree of each vertex
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : graph.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        // Add vertices with indegree 0
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        System.out.println("\nTopological Order:");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            count++;
            // Reduce indegree of neighboring vertices
            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // If not all vertices are processed, graph has a cycle
        if (count != vertices) {
            System.out.println("\n\nTopological Sort not possible!");
            System.out.println("Graph contains a cycle.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println("Enter directed edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.get(source).add(destination);
        }
        topologicalSort(vertices, graph);
    }
}
