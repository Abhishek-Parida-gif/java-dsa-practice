import java.util.*;
public class ActivitySelection {
    static class Activity {
        int start;
        int finish;
        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    static void selectActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));
        System.out.println("\nSelected Activities:");
        int lastFinish = activities[0].finish;
        System.out.println(
            "(" + activities[0].start + ", " +
            activities[0].finish + ")"
        );
        int count = 1;
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastFinish) {
                System.out.println(
                    "(" + activities[i].start + ", " +
                    activities[i].finish + ")"
                );
                lastFinish = activities[i].finish;
                count++;
            }
        }
        System.out.println("\nMaximum number of activities = " + count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();
        Activity[] activities = new Activity[n];
        System.out.println("Enter start and finish time:");
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int finish = sc.nextInt();
            activities[i] = new Activity(start, finish);
        }
        selectActivities(activities);
    }
}
