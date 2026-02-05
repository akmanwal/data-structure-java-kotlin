package javademo.collections.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

    public static void main(String[] args) {

        // Notes:
        // 1. Always maintains insertion and get() [access] order
        // 2. Uses HashTable (array) plus a doubly-linked list
        // 3. All methods are same as HashMap (extends HashMap)
        // 4. Slower in get(), put() because uses a linked list
        // 5. Traversing is faster than HashMap because only traverse LinkedList
        // 6. Uses more memory because needs to use extra pointers for LinkedList
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
        // Takes-> initialCapacity, load factor, access order (by default false)
        // true -> access order, false -> insertion order
        map.put("Ashish", 101);
        map.put("Manwal", 102);
        map.put("Manish", 103);
        map.put("Max", 104);

        // if we access something that will appear in last because it maintains
        // LRU (Least Recently Used)
        map.get("Manwal");

        System.out.println(map);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Ashish", 101);
        hashMap.put("Manwal", 102);
        hashMap.put("Manish", 103);
        hashMap.put("Max", 104);



        System.out.println(hashMap.getOrDefault("AKM", 0));
        hashMap.putIfAbsent("AKM", 105);
        System.out.println(hashMap);
    }
}
