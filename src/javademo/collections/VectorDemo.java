package javademo.collections;

import java.util.Arrays;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {

        /**
         * Vector is synchronized | ArrayList not
         * can check capacity -> vector.capcity() | Not in ArrayList
         * initialCapacity by default = 10
         * it's dubles (x2) after exceeding
         * one extra param in constructor -> Vector<>(int initialCapacity, int capacityIncrement)
         * So it will increase capacity by capacityIncrement when initialCapacity is reached and so on
         */
        Vector<Integer> vector = new Vector<>(5, 3);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);

        System.out.println(vector);
        System.out.println(vector.capacity());

        vector.add(6);
        vector.add(6);
        vector.add(6);

        System.out.println(vector.capacity());

        // take as collection
        Vector<Integer> vector1 = new Vector<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(vector1);

        /* Methods (same as ArrayList) but all methods are synchronized
         * .add() -> add element at end
         * .add(int index, element) -> Insert at specific index
         * .get(index) -> Retrieves the element at specific index
         * .set(int index, element) -> Replace the element at specific index
         * remove(Object o) -> remove the first occurrence of the specified element
         * .remove(int index) -> removes the element at the specified index
         * .size()
         * .isEmpty()
         * .contains() -> check
         * .clear()
         * .capacity() -> is different from ArrayList
         */


        // Checking synchronized
        Vector<Integer> arrayList = new Vector<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // if we use Vector instead of ArrayList then it will print 2000
        System.out.println(arrayList.size()); // not exact 2000 because ArrayList is not synchronized -> some operations of  add are duplicate

    }
}
