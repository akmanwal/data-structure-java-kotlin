package javademo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek()); // show top element

        int pop = stack.pop(); // returns poped element
        System.out.println(pop);

        System.out.println(stack.empty());
        System.out.println(stack.size());

        System.out.println(stack);
        // Also can use the methods of list
        stack.add(5);
        stack.add(2,10);

        System.out.println(stack);

        int index = stack.search(10); // return the index of 10 from top
        System.out.println(index);


        // We can use LinkedList as Stack
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3); // push

        linkedList.removeLast(); // pop

        linkedList.getLast(); // peek

        linkedList.isEmpty();

        linkedList.indexOf(3);


        // ArrayList as Stack -> above both are good -> not recommended
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        arrayList.getLast();
        /** Internally
         * public E getLast() {
         *         int last = size - 1;
         *         if (last < 0) {
         *             throw new NoSuchElementException();
         *         } else {
         *             return elementData(last);
         *         }
         *     }
         */

        arrayList.removeLast();

    }
}
