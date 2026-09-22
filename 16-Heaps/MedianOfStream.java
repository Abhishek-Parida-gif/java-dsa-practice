import java.util.*;

public class MedianOfStream {

    // Max Heap for smaller half
    static PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

    // Min Heap for larger half
    static PriorityQueue<Integer> minHeap =
            new PriorityQueue<>();

    // Add a number to the stream
    static void addNumber(int number) {

        // Add to Max Heap first
        if (maxHeap.isEmpty() || number <= maxHeap.peek()) {
            maxHeap.add(number);
        } else {
            minHeap.add(number);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Find median
    static double getMedian() {

        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int number = sc.nextInt();

            addNumber(number);

            System.out.println(
                "After adding " + number +
                " -> Median: " + getMedian()
            );
        }

        sc.close();
    }
}
