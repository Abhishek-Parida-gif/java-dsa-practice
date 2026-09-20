import java.util.*;
public class PalindromePartitioning {
    static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    static void partition(
            String str,
            int start,
            List<String> current) {
        if (start == str.length()) {
            System.out.println(current);
            return;
        }
        for (int end = start; end < str.length(); end++) {
            if (isPalindrome(str, start, end)) {
                current.add(str.substring(start, end + 1));
                partition(str, end + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        System.out.println("\nPalindrome Partitions:");
        partition(str, 0, new ArrayList<>());
    }
}
