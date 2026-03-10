public class PalindromeCheckerApp {
    public static void main(String[] args){
import java.util.Scanner;

        class Node {
            char data;
            Node next;

            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        public class UseCase8PalindromeCheckerApp {

            // Reverse a linked list
            public static Node reverse(Node head) {
                Node prev = null;
                Node current = head;
                Node next = null;

                while (current != null) {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                return prev;
            }

            // Check palindrome using linked list
            public static boolean isPalindrome(Node head) {
                if (head == null || head.next == null)
                    return true;

                Node slow = head;
                Node fast = head;

                // Find middle using fast & slow pointer
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }

                // Reverse second half
                Node secondHalf = reverse(slow);
                Node firstHalf = head;

                // Compare both halves
                while (secondHalf != null) {
                    if (firstHalf.data != secondHalf.data)
                        return false;

                    firstHalf = firstHalf.next;
                    secondHalf = secondHalf.next;
                }

                return true;
            }

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter a string: ");
                String input = scanner.nextLine();

                // Convert string to linked list
                Node head = null;
                Node tail = null;

                for (char ch : input.toCharArray()) {
                    Node newNode = new Node(ch);

                    if (head == null) {
                        head = newNode;
                        tail = newNode;
                    } else {
                        tail.next = newNode;
                        tail = newNode;
                    }
                }

                // Check palindrome
                if (isPalindrome(head)) {
                    System.out.println("The string is a Palindrome.");
                } else {
                    System.out.println("The string is NOT a Palindrome.");
                }

                scanner.close();
            }
        }

