import java.util.*;
public class GasStation {
    static int findStartingStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }
        if (totalGas < totalCost) {
            return -1;
        }
        return start;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of gas stations: ");
        int n = sc.nextInt();
        int[] gas = new int[n];
        int[] cost = new int[n];
        System.out.println("Enter gas available at each station:");
        for (int i = 0; i < n; i++) {
            gas[i] = sc.nextInt();
        }
        System.out.println("Enter cost to travel to next station:");
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        int start = findStartingStation(gas, cost);
        if (start == -1) {
            System.out.println("\nNo valid starting station exists.");
        } else {
            System.out.println(
                "\nValid starting station = " + start
            );
        }
    }
}
