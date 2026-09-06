import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BellmanFord {
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
    static ArrayList<Edge> edges = new ArrayList<>();
    // Bellman-Ford Algorithm
    static boolean bellmanFord(int start, int vertices) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        // Relax all edges V - 1 times
        for (int i = 1; i < vertices; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE
                        && distance[edge.source] + edge.weight
                        < distance[edge.destination]) {

                    distance[edge.destination] =
                            distance[edge.source] + edge.weight;
                    updated = true;
                }
            }
            // Stop early if no distance was updated
            if (!updated) {
                break;
            }
        }
        // Check for negative weight cycle
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE
                    && distance[edge.source] + edge.weight
                    < distance[edge.destination]) {

                return false;
            }
        }
        System.out.println(
                "\nShortest distances from vertex " + start + ":"
        );
        for (int i = 0; i < vertices; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(i + " -> INF");
            } else {
                System.out.println(i + " -> " + distance[i]);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int numberOfEdges = sc.nextInt();
        System.out.println(
                "Enter edges (source destination weight):"
        );
        for (int i = 0; i < numberOfEdges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(
                    new Edge(source, destination, weight)
            );
        }
        System.out.print("\nEnter starting vertex: ");
        int start = sc.nextInt();
        if (start < 0 || start >= vertices) {
            System.out.println("Invalid starting vertex.");
            sc.close();
            return;
        }
        boolean result = bellmanFord(start, vertices);
        if (!result) {
            System.out.println(
                    "\nNegative weight cycle detected!"
            );
        }
    }
}
