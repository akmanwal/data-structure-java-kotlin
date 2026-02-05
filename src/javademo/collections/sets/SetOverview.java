package javademo.collections.sets;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {
    public static void main(String[] args) {

        // Set is a collection that cannot contain duplicate elements
        // Based on HashMap principles
        // Faster operations
        // Map -> HashMap, LinkedHashMap, TreeMap, EnumMap -> not thread safe
        // Set -> HashSet, LinkedHashSet, TreeSet, EnumSet -> not thread safe
        // Unordered
        // For ordered LinkedHashSet
        // TreeSet for sorted orders
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(1);

        System.out.println(hashSet);

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Manish");
        hashMap.put(2, "Manwal");

        // because keys are unique in Set from HashMap
        Set<Integer> integerSet = hashMap.keySet();

        // thread safety with any Map or Set Collections.synchronizedSet(object of any collection)
        // Do not use this one -> not recommended
        //Set<Integer> sysncSet = Collections.synchronizedSet(integerSet);

        // use this one
        Set<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>(integerSet);

        // unmodifiable set -> any no of entries
        Set<Integer> unmodifiable = Set.of(1,2,3);

        // unmodifiable set -> only takes 10 entries
        Map<String , Integer> hashMap2 = Map.of("A",1, "B2", 2);

        // make any collection unmodifiable
        Collections.unmodifiableCollection(hashMap2.values());

    }
}
