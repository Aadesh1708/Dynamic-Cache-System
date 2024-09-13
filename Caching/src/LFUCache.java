import java.util.*;

public class LFUCache<K, V> implements CachePolicy<K, V> {
    private int capacity;
    private Map<K, V> cache;
    private Map<K, Integer> frequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequency = new HashMap<>();
    }

    @Override
    public V get(K key) {
        if (!cache.containsKey(key)) return null;
        frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            K leastFrequent = Collections.min(frequency.entrySet(), Map.Entry.comparingByValue()).getKey();
            cache.remove(leastFrequent);
            frequency.remove(leastFrequent);
        }
        cache.put(key, value);
        frequency.put(key, 1);
    }

    @Override
    public boolean contains(K key) {
        return cache.containsKey(key);
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void displayCache() {
        System.out.println(cache);
    }
}
