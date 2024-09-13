import java.util.ArrayList;
import java.util.List;

public class MultilevelCache<K, V> {
    private List<CachePolicy<K, V>> levels;

    public MultilevelCache() {
        this.levels = new ArrayList<>();
    }

    // Method to add a new cache level
    public void addCacheLevel(int capacity, String policyType) {
        CachePolicy<K, V> level = null;
        switch (policyType.toUpperCase()) {
            case "LRU":
                level = new LRUCache<>(capacity);
                break;
            case "LFU":
                level = new LFUCache<>(capacity);
                break;
            default:
                throw new IllegalArgumentException("Unknown policy: " + policyType);
        }
        levels.add(level);
    }

    // Get the value from cache, promoting it to the first level if found
    public V get(K key) {
        for (int i = 0; i < levels.size(); i++) {
            CachePolicy<K, V> level = levels.get(i);
            if (level.contains(key)) {
                V value = level.get(key);
                // Promote the value to the first level
                levels.get(0).put(key, value);
                return value;
            }
        }
        return null;
    }

    // Put the value in the first level cache
    public void put(K key, V value) {
        levels.get(0).put(key, value);
    }

    // Display all cache levels
    public void displayCaches() {
        for (int i = 0; i < levels.size(); i++) {
            System.out.print("L" + (i + 1) + " Cache: ");
            levels.get(i).displayCache();
        }
    }
}
