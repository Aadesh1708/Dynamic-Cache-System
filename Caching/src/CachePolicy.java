public interface CachePolicy<K, V> {
    V get(K key);
    void put(K key, V value);
    boolean contains(K key);
    void setCapacity(int capacity);
    void displayCache();  // New method to display the cache contents
}
