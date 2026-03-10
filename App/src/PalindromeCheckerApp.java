public class PalindromeCheckerApp {
    import java.util.Scanner;

    public class UseCase10PalindromeCheckerApp {

        public static boolean isPalindrome(String str) {

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

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            // Normalize string: remove spaces and convert to lowercase
            String normalized = input.replaceAll("\\s+", "").toLowerCase();

            // Check palindrome
            if (isPalindrome(normalized)) {
                System.out.println("The string is a Palindrome (ignoring spaces and case).");
            } else {
                System.out.println("The string is NOT a Palindrome.");
            }

            scanner.close();
        }
    }