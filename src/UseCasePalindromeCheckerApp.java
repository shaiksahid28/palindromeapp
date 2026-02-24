import java.util.LinkedList;
import java.util.Scanner;

/**
 * =============================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * =============================================================
 * Use Case 8: Linked List Based Palindrome Checker
 * * Key Concepts:
 * - Singly Linked List for storage
 * - Fast and Slow Pointer to find the middle
 * - In-place reversal of the second half
 */
public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC8: Linked List Based Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 1. Convert string to a LinkedList (Singly Linked List behavior)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        LinkedList<Character> list = new LinkedList<>();
        for (char c : normalized.toCharArray()) {
            list.add(c);
        }

        boolean isPalindrome = checkPalindrome(list);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

        scanner.close();
    }

    private static boolean checkPalindrome(LinkedList<Character> list) {
        if (list.isEmpty() || list.size() == 1) return true;

        // Note: For a strict Singly Linked List implementation using standard Java Collections:
        // We simulate the 'Fast & Slow' pointer by finding the middle index.
        int size = list.size();
        int mid = size / 2;

        // Compare first half with second half (effectively simulating reversal comparison)
        for (int i = 0; i < mid; i++) {
            if (!list.get(i).equals(list.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}