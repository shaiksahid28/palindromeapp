public class UseCasePalindromeCheckerApp {
    public static void main(String[] args) {
        // UC2: Hardcoded palindrome check
        String str = "madam"; // hardcoded string
        String reversed = new StringBuilder(str).reverse().toString();

        if(str.equals(reversed)) {
            System.out.println(str + " is a palindrome!");
        } else {
            System.out.println(str + " is NOT a palindrome!");
        }
    }
}
