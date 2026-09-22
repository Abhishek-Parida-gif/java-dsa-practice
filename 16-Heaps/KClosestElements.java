import java.util.*;

public class KClosestElements {

    // Find K closest elements
    static List<Integer> findKClosest(int[] arr, int k, int target) {

        if (k <= 0 || k > arr.length) {
            return new ArrayList<>();
        }

        // Max Heap
        // Stores: [difference, value]
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>(
                    (a, b) -> {
                        if (a[0] != b[0]) {
                            return Integer.compare(b[0], a[0]);
                        }

                        return Integer.compare(b[1], a[1]);
                    }
                );

        for (int value : arr) {

            int difference = Math.abs(value - target);

            maxHeap.add(new int[]{difference, value});

            // Keep only K elements
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }

        // Sort result for easy reading
        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        List<Integer> result =
                findKClosest(arr, k, target);

        if (result.isEmpty()) {
            System.out.println("Invalid value of K.");
        } else {
            System.out.println(
                "K closest elements to " + target + ":"
            );

            for (int value : result) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
