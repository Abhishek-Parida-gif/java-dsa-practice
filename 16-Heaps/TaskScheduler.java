import java.util.*;

public class TaskScheduler {

    static int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] frequency = new int[26];

        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add frequencies to Max Heap
        for (int count : frequency) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        int time = 0;

        // Process tasks
        while (!maxHeap.isEmpty()) {

            List<Integer> remaining = new ArrayList<>();

            // Process at most n + 1 different tasks
            for (int i = 0; i <= n; i++) {

                if (!maxHeap.isEmpty()) {

                    int count = maxHeap.poll();

                    count--;

                    if (count > 0) {
                        remaining.add(count);
                    }

                    time++;
                } else {

                    // No task available, CPU stays idle
                    if (!remaining.isEmpty()) {
                        time++;
                    }
                }
            }

            // Put remaining tasks back into heap
            for (int count : remaining) {
                maxHeap.add(count);
            }
        }

        return time;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int size = sc.nextInt();

        char[] tasks = new char[size];

        System.out.println("Enter tasks:");

        for (int i = 0; i < size; i++) {
            tasks[i] = sc.next().charAt(0);
        }

        System.out.print("Enter cooldown time: ");
        int n = sc.nextInt();

        int result = leastInterval(tasks, n);

        System.out.println("Minimum CPU intervals: " + result);

        sc.close();
    }
}
