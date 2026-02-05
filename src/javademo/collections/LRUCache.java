package javademo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;

    }

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        lruCache.put("Ashish", 1);
        lruCache.put("Manish", 2);
        lruCache.put("Manwal", 3);
        lruCache.get("Ashish");
        lruCache.put("Max", 4);

        System.out.println(lruCache);

    }
}
