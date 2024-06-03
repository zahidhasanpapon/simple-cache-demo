package org.zahid;

import java.util.HashMap;
import java.util.Map;

// Generic class
public class SimpleCache<K, V> {

    private final Map<K, V> cache = new HashMap<>();

    // Method to get data from the cache
    public V get(K key) {
        return cache.get(key);
    }

    // Method to put data int the cache
    public void put(K key, V value) {
        cache.put(key, value);
    }

    // Method to check if the cache contains a key
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    // Method to remove data from the cache
    public void remove(K key) {
        cache.remove(key);
    }

    // Method to clear the cache
    public void clear() {
        cache.clear();
    }

}