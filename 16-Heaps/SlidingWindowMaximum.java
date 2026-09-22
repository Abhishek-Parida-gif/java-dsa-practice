import java.util.*;

public class SlidingWindowMaximum {

    static void findMaximum(int[] arr, int k) {

        if (k <= 0 || k > arr.length) {
            System.out.println("Invalid window size.");
            return;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        System.out.println("Maximum of each window:");

        for (int i = 0; i < arr.length; i++) {

            // Remove elements outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty()
                    && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.addLast(i);

            // Print maximum when window is complete
            if (i >= k - 1) {
                System.out.print(arr[deque.peekFirst()] + " ");
            }
        }

        System.out.println();
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

        System.out.print("Enter window size K: ");
        int k = sc.nextInt();

        System.out.println("\nOriginal Array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();

        findMaximum(arr, k);

        sc.close();
    }
}
