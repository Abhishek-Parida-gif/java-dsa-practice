import java.util.Scanner;
public class ReverseNumber {
    static int reverse = 0;
    static void reverseNumber(int n) {
        if (n == 0) {
            return;
        }
        reverse = reverse * 10 + (n % 10);
        reverseNumber(n / 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int original = n;
        n = Math.abs(n);
        reverseNumber(n);
        if (original < 0) {
            reverse = -reverse;
        }
        System.out.println("Reversed number = " + reverse);
    }
}
