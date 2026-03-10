public class PalindromeCheckerApp {
    public static void main(String[] args){
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

        public class UseCase6PalindromeCheckerApp {


                Scanner scanner = new Scanner(System.in);

                Stack<Character> stack = new Stack<>();
                Queue<Character> queue = new LinkedList<>();

                System.out.print("Enter a string: ");
                String input = scanner.nextLine();

                // Insert characters into both stack and queue
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    stack.push(ch);      // LIFO
                    queue.add(ch);       // FIFO
                }

                boolean isPalindrome = true;

                // Compare dequeue (queue) and pop (stack)
                while (!stack.isEmpty() && !queue.isEmpty()) {
                    if (stack.pop() != queue.remove()) {
                        isPalindrome = false;
                        break;
                    }
                }

                // Print result
                if (isPalindrome) {
                    System.out.println("The string is a Palindrome.");
                } else {
                    System.out.println("The string is NOT a Palindrome.");
                }

                scanner.close();
            }
        }




