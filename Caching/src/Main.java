import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        // Initialize the cache system
        MultilevelCache<String, String> cache = new MultilevelCache<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Dynamic Cache System. Enter commands:");

        // Read commands in a loop
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Parse the command
                if (command.startsWith("addCacheLevel")) {
                    // Example: addCacheLevel(3, 'LRU')
                    String[] parts = command.split("[(),]");
                    int capacity = Integer.parseInt(parts[1].trim());
                    String policy = parts[2].trim().replace("'", "");
                    cache.addCacheLevel(capacity, policy);
                    System.out.println("Added cache level with capacity " + capacity + " and policy " + policy);
                } else if (command.startsWith("put")) {
                    // Example: put("A", "1")
                    String[] parts = command.split("[(),]");
                    String key = parts[1].trim().replace("\"", "");
                    String value = parts[2].trim().replace("\"", "");
                    cache.put(key, value);
                    System.out.println("Inserted key " + key + " with value " + value);
                } else if (command.startsWith("get")) {
                    // Example: get("A")
                    String[] parts = command.split("[(),]");
                    String key = parts[1].trim().replace("\"", "");
                    String value = cache.get(key);
                    if (value != null) {
                        System.out.println("Value for key " + key + ": " + value);
                    } else {
                        System.out.println("Key " + key + " not found");
                    }
                } else if (command.equalsIgnoreCase("display")) {
                    // Display the current state of the caches
                    cache.displayCaches();
                } else {
                    System.out.println("Unknown command. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error processing command. Please check the input format.");
            }
        }

        scanner.close();
        System.out.println("Exiting Dynamic Cache System. Goodbye!");
    }
}
