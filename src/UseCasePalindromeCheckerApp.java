import java.util.LinkedList;
import java.util.Scanner;


public class UseCasePalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC8: Linked List Based Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

       
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

        int size = list.size();
        int mid = size / 2;

        
        for (int i = 0; i < mid; i++) {
            if (!list.get(i).equals(list.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
