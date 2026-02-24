import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC7: Deque Based Optimized Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

       
        Deque<Character> deque = new ArrayDeque<>();

     
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

       
        boolean isPalindrome = true;

      
        while (deque.size() > 1) {
          
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

        scanner.close();
    }
}
