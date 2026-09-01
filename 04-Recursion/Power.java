import java.util.Scanner;
public class Power {
    static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base: ");
        int base = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int exponent = sc.nextInt();
        if (exponent < 0) {
            System.out.println("Please enter a non-negative exponent.");
        } else {
            long result = power(base, exponent);
            System.out.println(base + "^" + exponent + " = " + result);
        }
    }
}
