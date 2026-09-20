import java.util.*;
public class SubsetSum {
    static void findSubsets(
            int[] arr,
            int index,
            int target,
            List<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        if (index == arr.length) {
            return;
        }
        current.add(arr[index]);
        findSubsets(
            arr,
            index + 1,
            target - arr[index],
            current
        );
        current.remove(current.size() - 1);
        findSubsets(
            arr,
            index + 1,
            target,
            current
        );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        System.out.println("\nSubsets with target sum:");
        findSubsets(
            arr,
            0,
            target,
            new ArrayList<>()
        );
    }
}
