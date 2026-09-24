import java.util.Scanner;

public class ImplementTrie {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    static class Trie {

        private TrieNode root;

        // Constructor
        Trie() {
            root = new TrieNode();
        }

        // Insert a word
        void insert(String word) {

            TrieNode current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.isEndOfWord = true;

            System.out.println("Word inserted: " + word);
        }

        // Search for a complete word
        boolean search(String word) {

            TrieNode current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    return false;
                }

                current = current.children[index];
            }

            return current.isEndOfWord;
        }

        // Check whether a prefix exists
        boolean startsWith(String prefix) {

            TrieNode current = root;

            for (char ch : prefix.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {
                    return false;
                }

                current = current.children[index];
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Trie trie = new Trie();

        int choice;

        do {

            System.out.println("\n===== TRIE MENU =====");
            System.out.println("1. Insert word");
            System.out.println("2. Search word");
            System.out.println("3. Check prefix");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter word: ");

                    String word = sc.next().toLowerCase();

                    trie.insert(word);
                    break;

                case 2:
                    System.out.print("Enter word to search: ");

                    String searchWord =
                        sc.next().toLowerCase();

                    if (trie.search(searchWord)) {
                        System.out.println(
                            "Word found: " + searchWord
                        );
                    } else {
                        System.out.println(
                            "Word not found: " + searchWord
                        );
                    }

                    break;

                case 3:
                    System.out.print("Enter prefix: ");

                    String prefix =
                        sc.next().toLowerCase();

                    if (trie.startsWith(prefix)) {
                        System.out.println(
                            "Prefix exists: " + prefix
                        );
                    } else {
                        System.out.println(
                            "Prefix does not exist: " + prefix
                        );
                    }

                    break;

                case 4:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Try again."
                    );
            }

        } while (choice != 4);

        sc.close();
    }
}
