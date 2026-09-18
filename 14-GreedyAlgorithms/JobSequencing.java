import java.util.*;
public class JobSequencing {
    static class Job {
        char id;
        int deadline;
        int profit;
        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    static void jobSequencing(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        char[] slots = new char[maxDeadline + 1];
        boolean[] filled = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        int jobCount = 0;
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!filled[j]) {
                    slots[j] = job.id;
                    filled[j] = true;
                    totalProfit += job.profit;
                    jobCount++;
                    break;
                }
            }
        }
        System.out.println("\nScheduled Jobs:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (filled[i]) {
                System.out.println(
                    "Slot " + i + " -> Job " + slots[i]
                );
            }
        }
        System.out.println("\nNumber of jobs = " + jobCount);
        System.out.println("Maximum profit = " + totalProfit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        System.out.println("Enter job ID, deadline and profit:");
        for (int i = 0; i < n; i++) {
            char id = sc.next().charAt(0);
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }
        jobSequencing(jobs);
    }
}
