import java.util.HashMap;
import java.util.Scanner;
public class TwoSum {
    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
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
        int[] result = twoSum(arr, target);
        if (result[0] == -1) {
            System.out.println("No two numbers found.");
        } else {
            System.out.println(
                "Two numbers found at indices: "
                + result[0] + " and " + result[1]
            );
            System.out.println(
                "Values: "
                + arr[result[0]] + " + " + arr[result[1]]
                + " = " + target
            );
        }
    }
}
