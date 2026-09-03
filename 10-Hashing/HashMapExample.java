import java.util.HashMap;
import java.util.Scanner;
public class HashMapExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        // Add student ID and name
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            System.out.print("Enter student name: ");
            String name = sc.next();
            students.put(id, name);
        }
        // Display HashMap
        System.out.println("\nStudent HashMap:");
        System.out.println(students);
        // Search by ID
        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();
        if (students.containsKey(searchId)) {
            System.out.println("Student name: " + students.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }
        // Remove a student
        System.out.print("\nEnter ID to remove: ");
        int removeId = sc.nextInt();
        if (students.containsKey(removeId)) {
            students.remove(removeId);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
        // Display updated HashMap
        System.out.println("\nUpdated Student HashMap:");
        System.out.println(students);
        System.out.println("\nTotal students: " + students.size());
    }
}
