import java.util.*;

public class MergeKSortedArrays {

    // Node to store value, array index and element index
    static class Node {
        int value;
        int arrayIndex;
        int elementIndex;

        Node(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    // Merge K sorted arrays
    static List<Integer> mergeArrays(int[][] arrays) {

        PriorityQueue<Node> minHeap =
                new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.value, b.value)
                );

        List<Integer> result = new ArrayList<>();

        // Add first element of every array
        for (int i = 0; i < arrays.length; i++) {

            if (arrays[i].length > 0) {
                minHeap.add(new Node(arrays[i][0], i, 0));
            }
        }

        // Process heap
        while (!minHeap.isEmpty()) {

            Node current = minHeap.poll();

            result.add(current.value);

            int nextIndex = current.elementIndex + 1;

            // Add next element from same array
            if (nextIndex < arrays[current.arrayIndex].length) {

                minHeap.add(
                    new Node(
                        arrays[current.arrayIndex][nextIndex],
                        current.arrayIndex,
                        nextIndex
                    )
                );
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sorted arrays: ");
        int k = sc.nextInt();

        int[][] arrays = new int[k][];

        for (int i = 0; i < k; i++) {

            System.out.print(
                "Enter size of array " + (i + 1) + ": "
            );

            int n = sc.nextInt();

            arrays[i] = new int[n];

            System.out.println(
                "Enter sorted elements:"
            );

            for (int j = 0; j < n; j++) {
                arrays[i][j] = sc.nextInt();
            }
        }

        List<Integer> result = mergeArrays(arrays);

        System.out.println("\nMerged Sorted Array:");

        for (int value : result) {
            System.out.print(value + " ");
        }

        System.out.println();

        sc.close();
    }
}
