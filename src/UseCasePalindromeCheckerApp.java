import java.util.*;

public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Checker App (Strategy Pattern) =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\nChoose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            default:
                strategy = new StackStrategy();
        }

        boolean result = strategy.isPalindrome(input);

        System.out.println("\nResult: \"" + input + "\" is "
                + (result ? "a Palindrome" : "NOT a Palindrome"));

        scanner.close();
    }
}

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {

        if (input == null) return false;

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {

        if (input == null) return false;

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}