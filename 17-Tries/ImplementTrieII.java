import java.util.Scanner;
public class ImplementTrieII {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int endCount;
        int prefixCount;
    }
    static class Trie {
        private TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
                current.prefixCount++;
            }
            current.endCount++;
        }
        int countWordsEqualTo(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    return 0;
                }
                current = current.children[index];
            }
            return current.endCount;
        }
        int countWordsStartingWith(String prefix) {
            TrieNode current = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    return 0;
                }
                current = current.children[index];
            }
            return current.prefixCount;
        }
        void erase(String word) {
            TrieNode current = root;
            // First check whether the word exists
            if (countWordsEqualTo(word) == 0) {
                System.out.println(
                    "Word does not exist."
                );
                return;
            }
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                current = current.children[index];
                current.prefixCount--;
            }
            current.endCount--;
            System.out.println(
                "One occurrence of \"" +
                word +
                "\" was erased."
            );
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        int choice;
        do {
            System.out.println("\n===== TRIE II MENU =====");
            System.out.println("1. Insert Word");
            System.out.println("2. Count Exact Word");
            System.out.println("3. Count Words With Prefix");
            System.out.println("4. Erase Word");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter word: ");
                    String insertWord =
                        sc.next().toLowerCase();
                    trie.insert(insertWord);
                    System.out.println(
                        "Word inserted successfully."
                    );
                    break;
                case 2:
                    System.out.print(
                        "Enter word to count: "
                    );
                    String searchWord =
                        sc.next().toLowerCase();
                    int exactCount =
                        trie.countWordsEqualTo(searchWord);
                    System.out.println(
                        "Exact word count: " +
                        exactCount
                    );
                    break;
                case 3:
                    System.out.print(
                        "Enter prefix: "
                    );
                    String prefix =
                        sc.next().toLowerCase();
                    int prefixCount =
                        trie.countWordsStartingWith(prefix);
                    System.out.println(
                        "Words starting with \"" +
                        prefix +
                        "\": " +
                        prefixCount
                    );
                    break;
                case 4:
                    System.out.print(
                        "Enter word to erase: "
                    );
                    String eraseWord =
                        sc.next().toLowerCase();
                    trie.erase(eraseWord);
                    break;
                case 5:
                    System.out.println(
                        "Exiting program..."
                    );
                    break;
                default:
                    System.out.println(
                        "Invalid choice."
                    );
            }
        } while (choice != 5);
    }
}
