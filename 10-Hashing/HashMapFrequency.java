import java.util.HashMap;
import java.util.Scanner;
public class HashMapFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        // Input array
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // HashMap to store element and frequency
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int value : arr) {
            if (frequency.containsKey(value)) {
                frequency.put(value, frequency.get(value) + 1);
            } else {
                frequency.put(value, 1);
            }
        }
        // Display frequencies
        System.out.println("\nElement Frequencies:");
        for (int key : frequency.keySet()) {
            System.out.println(key + " → " + frequency.get(key));
        }
    }
}
