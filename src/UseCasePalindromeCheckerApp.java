import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class UseCasePalindromeCheckerApp {

    private static boolean isPalindromeStack(String input) {
        if (input == null) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (stack.isEmpty()) return false;
            if (!stack.pop().equals(c)) return false;
        }

        return true;
    }

    private static boolean isPalindromeDeque(String input) {
        if (input == null) return false;

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            Character left = deque.removeFirst();
            Character right = deque.removeLast();
            if (!left.equals(right)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");
        String input = scanner.nextLine();

        long startStack = System.nanoTime();
        boolean resultStack = isPalindromeStack(input);
        long endStack = System.nanoTime();

        long startDeque = System.nanoTime();
        boolean resultDeque = isPalindromeDeque(input);
        long endDeque = System.nanoTime();

        long timeStack = endStack - startStack;
        long timeDeque = endDeque - startDeque;

        boolean finalResult = resultStack && resultDeque;

        System.out.println("Is Palindrome? : " + finalResult);

        if (timeStack <= timeDeque) {
            System.out.println("Fastest Algorithm : Stack");
            System.out.println("Execution Time : " + timeStack + " ns");
        } else {
            System.out.println("Fastest Algorithm : Deque");
            System.out.println("Execution Time : " + timeDeque + " ns");
        }

        System.out.println("Stack Time : " + timeStack + " ns");
        System.out.println("Deque Time : " + timeDeque + " ns");

        scanner.close();
    }
}