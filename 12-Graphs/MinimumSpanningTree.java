import java.util.*;
public class MinimumSpanningTree {
    static class Edge {
        int source;
        int destination;
        int weight;
        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }
    static void union(int[] parent, int[] rank, int first, int second) {
        int root1 = find(parent, first);
        int root2 = find(parent, second);
        if (root1 == root2) {
            return;
        }
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }
    static void kruskalMST(int vertices, ArrayList<Edge> edges) {
        // Sort edges by weight
        edges.sort(Comparator.comparingInt(edge -> edge.weight));
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int totalWeight = 0;
        int edgesUsed = 0;
        System.out.println("\nEdges in Minimum Spanning Tree:");
        for (Edge edge : edges) {
            int rootSource = find(parent, edge.source);
            int rootDestination = find(parent, edge.destination);
            // Add edge only if it does not create a cycle
            if (rootSource != rootDestination) {
                System.out.println(
                    edge.source + " - " +
                    edge.destination + " : " +
                    edge.weight
                );
                totalWeight += edge.weight;
                edgesUsed++;
                union(parent, rank, edge.source, edge.destination);
                if (edgesUsed == vertices - 1) {
                    break;
                }
            }
        }
        if (edgesUsed != vertices - 1) {
            System.out.println("\nMST not possible!");
            System.out.println("Graph is not connected.");
        } else {
            System.out.println("\nMinimum Cost = " + totalWeight);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int edgesCount = sc.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < edgesCount; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(source, destination, weight));
        }
        kruskalMST(vertices, edges);
    }
}
