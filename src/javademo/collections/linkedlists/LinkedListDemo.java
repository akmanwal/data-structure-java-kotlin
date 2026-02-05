package javademo.collections.linkedlists;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {


    public static void main(String[] args) {
        // Linked list as list
        LinkedList<Integer> linkedList = new LinkedList<>(); // Doubly
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.get(2); // O(n) -> Because using for loop inside
        linkedList.remove(2);

        linkedList.addFirst(0); // O(1)
        linkedList.addLast(5);  // O(1)

        System.out.println("Before Add: " + linkedList);
        linkedList.add(2,50);
        System.out.println("LinkedList: " + linkedList);

        //linkedList.removeIf(x -> x % 2 == 0);

        System.out.println("LinkedList: " + linkedList);

        LinkedList<String> animalsList = new LinkedList<>(Arrays.asList("Dog", "Cat", "Elephant"));
        LinkedList<String> anotherAnimalList = new LinkedList<>(Arrays.asList("Dog", "Lion"));
        animalsList.removeAll(anotherAnimalList);
        System.out.println("animalsList: " + animalsList);

        // Linked list as queue and stack
        // Next video
    }
}