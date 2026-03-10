public class PalindromeCheckerApp {
 import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

    // Strategy Interface
    interface PalindromeStrategy {
        boolean checkPalindrome(String str);
    }

    // Stack Strategy Implementation
    class StackStrategy implements PalindromeStrategy {

        public boolean checkPalindrome(String str) {

            Stack<Character> stack = new Stack<>();

            for (char ch : str.toCharArray()) {
                stack.push(ch);
            }

            for (char ch : str.toCharArray()) {
                if (ch != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Deque Strategy Implementation
    class DequeStrategy implements PalindromeStrategy {

        public boolean checkPalindrome(String str) {

            Deque<Character> deque = new ArrayDeque<>();

            for (char ch : str.toCharArray()) {
                deque.addLast(ch);
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Context Class
    class PalindromeChecker {

        private PalindromeStrategy strategy;

        public PalindromeChecker(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean check(String str) {
            return strategy.checkPalindrome(str);
        }
    }

    // Application Class
    public class UseCase12PalindromeCheckerApp {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            System.out.println("Choose Algorithm:");
            System.out.println("1. Stack Strategy");
            System.out.println("2. Deque Strategy");

            int choice = scanner.nextInt();

            PalindromeStrategy strategy;

            if (choice == 1) {
                strategy = new StackStrategy();
            } else {
                strategy = new DequeStrategy();
            }

            PalindromeChecker checker = new PalindromeChecker(strategy);

            if (checker.check(input)) {
                System.out.println("The string is a Palindrome.");
            } else {
                System.out.println("The string is NOT a Palindrome.");
            }

            scanner.close();
        }
    }