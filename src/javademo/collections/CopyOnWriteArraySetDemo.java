package javademo.collections;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {

    public static void main(String[] args) {

        // Thread-safe
        // Copy-On-Write Mechanism
        // No duplicate elements
        // Iterator do not reflect modifications
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        for (int i = 0; i < 5; i++) {
            copyOnWriteArraySet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println("Initial copyOnWriteArraySet : " + copyOnWriteArraySet);
        System.out.println("Initial concurrentSkipListSet : " + concurrentSkipListSet);

        // It can reflect or may be not
        // Also called Weakly consistent (test adding at last iteration using if)
        for (Integer integer : concurrentSkipListSet) {
            System.out.println("Reading from concurrentSkipListSet: " + integer);
            concurrentSkipListSet.add(5); // 6 will add
        }

        for (Integer integer : copyOnWriteArraySet) {
            System.out.println("Reading from copyOnWriteArraySet: " + integer);
            copyOnWriteArraySet.add(5); // 6 will not add
        }

        // Now 6 will add
        System.out.println("Reading after loop copyOnWriteArraySet: " + copyOnWriteArraySet);

    }
}
