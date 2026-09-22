import java.util.*;

public class ConnectRopes {

    // Find minimum cost to connect all ropes
    static int minCost(int[] ropes) {

        if (ropes.length <= 1) {
            return 0;
        }

        // Min Heap
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        // Add all ropes
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Connect two smallest ropes
        while (minHeap.size() > 1) {

            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;

            totalCost += cost;

            // Add newly connected rope
            minHeap.add(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of ropes: ");
        int n = sc.nextInt();

        int[] ropes = new int[n];

        System.out.println("Enter rope lengths:");

        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }

        int result = minCost(ropes);

        System.out.println(
            "Minimum Cost to Connect Ropes: " + result
        );

        sc.close();
    }
}
