public class PalindromeCheckerApp {
    public static void main(String[] args){
        public class UseCase4PalindromeCheckerApp {

            public static void main(String[] args) {

                // Original String
                String text = "radar";

                // Convert string to character array
                char[] characters = text.toCharArray();

                // Two-pointer technique
                int start = 0;
                int end = characters.length - 1;

                boolean isPalindrome = true;

                while (start < end) {

                    if (characters[start] != characters[end]) {
                        isPalindrome = false;
                        break;
                    }

                    start++;
                    end--;
                }


                if (isPalindrome) {
                    System.out.println("The string \"" + text + "\" is a Palindrome.");
                } else {
                    System.out.println("The string \"" + text + "\" is NOT a Palindrome.");
                }
            }
        }





