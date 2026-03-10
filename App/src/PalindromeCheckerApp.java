public class PalindromeCheckerApp {
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

    public class UsernameChecker {

        // Stores taken usernames -> userId
        private final Set<String> usernames;

        // Tracks how many times a username was attempted
        private final Map<String, AtomicInteger> attemptFrequency;

        public UsernameChecker() {
            usernames = ConcurrentHashMap.newKeySet(); // thread-safe set
            attemptFrequency = new ConcurrentHashMap<>();
        }

        // Add a username to the system (simulate registration)
        public void registerUsername(String username) {
            usernames.add(username.toLowerCase());
        }

        // Check if username is available
        public boolean checkAvailability(String username) {
            username = username.toLowerCase();

            // Increment attempt count
            attemptFrequency.putIfAbsent(username, new AtomicInteger(0));
            attemptFrequency.get(username).incrementAndGet();

            // Return availability
            return !usernames.contains(username);
        }

        // Suggest alternative usernames if taken
        public List<String> suggestAlternatives(String username) {
            List<String> suggestions = new ArrayList<>();
            String base = username.replaceAll("\\W+", ""); // remove special chars

            for (int i = 1; i <= 5; i++) { // generate 5 suggestions
                String suggestion = base + i;
                if (!usernames.contains(suggestion.toLowerCase())) {
                    suggestions.add(suggestion);
                }
            }

            // Add a variant with dot
            String dotVariant = base.replace("_", ".").toLowerCase();
            if (!usernames.contains(dotVariant)) {
                suggestions.add(dotVariant);
            }

            return suggestions;
        }

        // Return the most attempted username
        public String getMostAttempted() {
            return attemptFrequency.entrySet()
                    .stream()
                    .max(Comparator.comparingInt(e -> e.getValue().get()))
                    .map(Map.Entry::getKey)
                    .orElse(null);
        }

        // For demo purposes: print attempt frequency
        public void printAttemptFrequency() {
            attemptFrequency.forEach((k, v) -> System.out.println(k + " → " + v.get()));
        }

        // Main method to test
        public static void main(String[] args) {
            UsernameChecker checker = new UsernameChecker();

            // Simulate existing users
            checker.registerUsername("john_doe");
            checker.registerUsername("admin");
            checker.registerUsername("jane_smith");

            System.out.println("Availability check:");
            System.out.println("john_doe → " + checker.checkAvailability("john_doe")); // false
            System.out.println("jane_smith → " + checker.checkAvailability("jane_smith")); // false
            System.out.println("new_user → " + checker.checkAvailability("new_user")); // true

            System.out.println("\nSuggestions for 'john_doe':");
            System.out.println(checker.suggestAlternatives("john_doe")); // ["john_doe1", "john_doe2", ...]

            System.out.println("\nMost attempted username:");
            System.out.println(checker.getMostAttempted()); // "john_doe"

            System.out.println("\nAttempt frequencies:");
            checker.printAttemptFrequency();
        }
    }