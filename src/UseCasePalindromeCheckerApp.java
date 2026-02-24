import java.util.LinkedList;

public class UseCasePalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "level";
        LinkedList<Character> list = new LinkedList<>();

        for (char c : input.toCharArray()) {
            list.addLast(c);
        }

        boolean isPalindrome = true;

        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}