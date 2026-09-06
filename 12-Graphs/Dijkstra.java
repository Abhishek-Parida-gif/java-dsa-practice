import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
public class Dijkstra {
    static class Edge {
        int destination;
        int weight;
        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    static ArrayList<ArrayList<Edge>> graph;
    // Dijkstra's Algorithm
    static int[] dijkstra(int start, int vertices) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        distance[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDistance = current[1];
            // Ignore outdated queue entries
            if (currentDistance > distance[node]) {
                continue;
            }
            for (Edge edge : graph.get(node)) {
                int newDistance =
                        currentDistance + edge.weight;
                if (newDistance < distance[edge.destination]) {
                    distance[edge.destination] = newDistance;
                    pq.add(new int[]{
                            edge.destination,
                            newDistance
                    });
                }
            }
        }
        return distance;
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
        System.out.println(
                "Enter edges (source destination weight):"
        );
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int weight = sc.nextInt();
            // Undirected weighted graph
            graph.get(source).add(
                    new Edge(destination, weight)
            );
            graph.get(destination).add(
                    new Edge(source, weight)
            );
        }
        System.out.print("\nEnter starting vertex: ");
        int start = sc.nextInt();
        if (start < 0 || start >= vertices) {
            System.out.println("Invalid starting vertex.");
            sc.close();
            return;
        }
        int[] distance = dijkstra(start, vertices);
        System.out.println("\nShortest distances from vertex " + start + ":");
        for (int i = 0; i < vertices; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(i + " -> INF");
            } else {
                System.out.println(i + " -> " + distance[i]);
            }
        }
    }
}
