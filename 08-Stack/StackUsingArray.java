import java.util.Scanner;
public class StackUsingArray {
    static int[] stack;
    static int top = -1;
    // Push element into stack
    static void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack Overflow! Stack is full.");
            return;
        }
        top++;
        stack[top] = value;
        System.out.println(value + " pushed into stack.");
    }
    // Pop element from stack
    static void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
            return;
        }
        System.out.println(stack[top] + " popped from stack.");
        top--;
    }
    // View top element
    static void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top element: " + stack[top]);
    }
    // Check if stack is empty
    static boolean isEmpty() {
        return top == -1;
    }
    // Check if stack is full
    static boolean isFull() {
        return top == stack.length - 1;
    }
    // Display stack
    static void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = sc.nextInt();
        stack = new int[size];
        int choice;
        do {
            System.out.println("\n===== STACK MENU =====");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Check Empty");
            System.out.println("6. Check Full");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    push(value);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    if (isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 6:
                    if (isFull()) {
                        System.out.println("Stack is full.");
                    } else {
                        System.out.println("Stack is not full.");
                    }
                    break;
                case 7:
                    System.out.println("Program ended.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }
}
