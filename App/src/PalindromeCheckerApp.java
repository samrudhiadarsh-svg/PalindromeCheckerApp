public class PalindromeCheckerApp {
    import java.util.Scanner;

    // Service class following OOP principles
    class PalindromeChecker {

        // Method to check palindrome
        public boolean checkPalindrome(String str) {

            int start = 0;
            int end = str.length() - 1;

            while (start < end) {
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }
    }

    public class UseCase11PalindromeCheckerApp {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Create object of PalindromeChecker
            PalindromeChecker checker = new PalindromeChecker();

            boolean result = checker.checkPalindrome(input);

            if (result) {
                System.out.println("The string is a Palindrome.");
            } else {
                System.out.println("The string is NOT a Palindrome.");
            }

            scanner.close();
        }
    }