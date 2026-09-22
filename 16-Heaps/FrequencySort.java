import java.util.*;

public class FrequencySort {

    static String frequencySort(String str) {

        // Count frequency of each character
        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char ch : str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Max Heap based on frequency
        PriorityQueue<Character> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> frequency.get(b) - frequency.get(a)
                );

        // Add all characters to heap
        maxHeap.addAll(frequency.keySet());

        StringBuilder result = new StringBuilder();

        // Build result
        while (!maxHeap.isEmpty()) {

            char ch = maxHeap.poll();

            for (int i = 0; i < frequency.get(ch); i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String result = frequencySort(str);

        System.out.println("Frequency Sorted String:");
        System.out.println(result);

        sc.close();
    }
}
