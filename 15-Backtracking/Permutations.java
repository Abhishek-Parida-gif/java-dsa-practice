import java.util.*;
public class Permutations {
    static void generatePermutations(
            String str,
            String current,
            boolean[] used) {
        if (current.length() == str.length()) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                generatePermutations(
                    str,
                    current + str.charAt(i),
                    used
                );
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        boolean[] used = new boolean[str.length()];
        System.out.println("\nPermutations:");
        generatePermutations(str, "", used);
    }
}
