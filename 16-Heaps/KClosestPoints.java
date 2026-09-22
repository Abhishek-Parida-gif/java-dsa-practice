import java.util.*;

public class KClosestPoints {

    // Find K closest points to origin
    static List<int[]> findKClosestPoints(int[][] points, int k) {

        if (k <= 0 || k > points.length) {
            return new ArrayList<>();
        }

        // Max Heap based on distance
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(
                    (a, b) -> Integer.compare(
                        distance(b),
                        distance(a)
                    )
                );

        for (int[] point : points) {

            maxHeap.add(point);

            // Keep only K closest points
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<int[]> result = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        return result;
    }

    // Calculate squared distance from origin
    static int distance(int[] point) {

        int x = point[0];
        int y = point[1];

        return x * x + y * y;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        int[][] points = new int[n][2];

        System.out.println("Enter points (x y):");

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        List<int[]> result =
                findKClosestPoints(points, k);

        if (result.isEmpty()) {

            System.out.println("Invalid value of K.");

        } else {

            System.out.println(
                "\n" + k + " Closest Points to Origin:"
            );

            for (int[] point : result) {
                System.out.println(
                    "(" + point[0] + ", " + point[1] + ")"
                );
            }
        }

        sc.close();
    }
}
