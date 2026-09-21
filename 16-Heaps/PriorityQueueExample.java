import java.util.*;
public class PriorityQueueExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            queue.add(value);
        }
        System.out.println("\nPriority Queue:");
        System.out.println(queue);
        System.out.println("Highest priority element: " + queue.peek());
        System.out.println("\nRemoving elements:");
        while (!queue.isEmpty()) {
            System.out.println("Removed: " + queue.poll());
        }
    }
}
