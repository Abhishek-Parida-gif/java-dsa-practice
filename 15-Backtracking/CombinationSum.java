import java.util.*;
public class CombinationSum {
    static void findCombinations(
            int[] candidates,
            int target,
            int start,
            List<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            findCombinations(
                candidates,
                target - candidates[i],
                i,
                current
            );
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        int[] candidates = new int[n];
        System.out.println("Enter candidate values:");
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }
        System.out.print("Enter target: ");
        int target = sc.nextInt();
        Arrays.sort(candidates);
        System.out.println("\nCombinations:");
        findCombinations(
            candidates,
            target,
            0,
            new ArrayList<>()
        );
    }
}
