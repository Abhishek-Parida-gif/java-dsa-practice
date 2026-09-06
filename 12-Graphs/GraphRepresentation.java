import java.util.ArrayList;
import java.util.Scanner;
public class GraphRepresentation {
    static class Edge {
        int source;
        int destination;
        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        ArrayList<Edge> graph = new ArrayList<>();
        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.add(new Edge(source, destination));
        }
        System.out.println("\nGraph Edges:");
        for (Edge edge : graph) {
            System.out.println(
                edge.source + " -> " + edge.destination
            );
        }
    }
}
