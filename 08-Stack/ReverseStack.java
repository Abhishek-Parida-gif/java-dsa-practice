import java.util.Scanner;
import java.util.Stack;
public class ReverseStack {
    // Reverse the stack
    static void reverse(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        // Push elements into stack
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter element " + i + ": ");
            int value = sc.nextInt();
            stack.push(value);
        }
        System.out.println("\nOriginal Stack:");
        System.out.println(stack);
        // Reverse stack
        reverse(stack);
        System.out.println("\nReversed Stack:");
        System.out.println(stack);
        sc.close();
    }
}
