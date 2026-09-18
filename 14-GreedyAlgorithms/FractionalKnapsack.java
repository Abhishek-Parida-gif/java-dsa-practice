import java.util.*;
public class FractionalKnapsack {
    static class Item {
        int weight;
        int value;
        double ratio;
        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }
    static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double totalValue = 0;
        for (Item item : items) {
            if (capacity == 0) {
                break;
            }
            if (item.weight <= capacity) {
                capacity -= item.weight;
                totalValue += item.value;
                System.out.println(
                    "Taken: 100% of item (Weight = " +
                    item.weight + ", Value = " + item.value + ")"
                );
            }
            else {
                double fraction = (double) capacity / item.weight;
                totalValue += item.value * fraction;
                System.out.println(
                    "Taken: " +
                    String.format("%.2f", fraction * 100) +
                    "% of item (Weight = " +
                    item.weight + ", Value = " +
                    item.value + ")"
                );
                capacity = 0;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        System.out.println("Enter weight and value of each item:");
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            items[i] = new Item(weight, value);
        }
        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();
        double maximumValue = fractionalKnapsack(items, capacity);
        System.out.printf(
            "\nMaximum value = %.2f\n",
            maximumValue
        );
    }
}
