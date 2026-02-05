package javademo.collections.arraylists;

import javademo.collections.Students;

import java.util.*;

class MyComparator implements java.util.Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        System.out.println("compare->" + (num2 - num1));
        return num2 - num1; // for descending
    }
}

class StringComparator implements java.util.Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str1.length() - str2.length(); // for descending
    }
}

public class ArrayListDemo {

    public static void main(String[] args) throws IllegalAccessException {
        //operations();
        //checkFixedSize();
        //withAnotherCollection();
        //comparatorSorting();
        compareStudentModel();
    }

    static void compareStudentModel() {
        ArrayList<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students("Ashish", 30));
        studentsList.add(new Students("Manwal", 25));
        studentsList.add(new Students("Manish", 27));
        studentsList.add(new Students("Hussy", 15));

        //studentsList.sort(Comparator.comparingInt(JavaDemo.Students::getAge).reversed().thenComparing(JavaDemo.Students::getName));
        for (Students student : studentsList) {
            System.out.println(student.getName() + ": " + student.getAge());
        }

        int p1 = studentsList.indexOf(new Students("Manish", 27));
        System.out.println(p1);


    }

    static void comparatorSorting() {

        // 1. In case of integer
        ArrayList<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(10);


        Collections.sort(list); // print in ascending

        // if we pass null then natural sorting
        list.sort(new MyComparator());

        System.out.println(list);

        // 2. In case of string
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("ok"); // s1
        stringList.add("bye"); // s2

        stringList.sort(new StringComparator());
        System.out.println(stringList);
    }

    static void withAnotherCollection() {
        // 1. Creating array list
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("c");
        arrayList.add("b");
        arrayList.add("a");

        ArrayList<String> arrayListAnother = new ArrayList<>();
        arrayListAnother.add("a");
        arrayListAnother.add("b");

        arrayList.addAll(arrayListAnother);
        System.out.println(arrayList);

        // myList is of fixed size and cannot add, remove only replace will work
        // cant made changes in size dynamically
        // 2. Creating array list
        List<String> myList = Arrays.asList("d", "e", "f");
        // add one list to another
        arrayList.addAll(myList);

        System.out.println(arrayList);
        System.out.println(arrayListAnother.getClass().getName()); // java.util.ArrayList

        // 3. Creating array list from an array
        // Fixed size
        String[] stringArray = {"g", "h", "i"};
        // Always return List not ArrayList
        List<String> arrayToList = Arrays.asList(stringArray);
        System.out.println(arrayToList.getClass().getName()); // java.util.Arrays$ArrayList
        System.out.println(arrayToList);

        // 4. Creating a list
        // No add, no remove, no replace
        List<Integer> list = List.of(1, 2, 3, 4);
        //list.set(1,33); // UnsupportedOperationException
        System.out.println(list);

        // Making above two list as Modifiable
        // In constructor of ArrayList -> we can pass capacity or any collection
        List<String> modifiableList = new ArrayList<>(arrayToList);
        modifiableList.add("j");
        System.out.println(modifiableList);

    }

    static void checkFixedSize() throws IllegalAccessException {
        // This is the initial capacity of internal array
        // So there is nothing at indexes
        // It will throw IndexOutOfBoundsException if we try to get any index
        // Creating an empty array list with capacity of 15 (by default 10)
        // Increases 1.5x times capacity if elements exceed limit of 10
        ArrayList<Integer> list = new ArrayList<>(15);
        list.add(1);
        System.out.println(list.size());
        System.out.println(list.get(0));

        // How to get the capacity?
        // Using reflection
        // Just for education purpose
        // Do not use in production apps
        /*Field field = ArrayList.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println(elementData.length);*/
    }

    static void operations() {
        // Creating an empty array list with capacity of 10
        ArrayList<String> list = new ArrayList<>(); // we can provide initial capacity
        list.add("z");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.get(1)); // get element on first index
        System.out.println(list.size()); // gives size

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String i : list) {
            System.out.println(i);
        }

        System.out.println(list.contains("a")); // check existence
        System.out.println(list.contains("z"));

        //list.remove(2); // can take both value and index

        System.out.println(list);

        list.add("e"); // add at the end

        // insert at a particular index but will not replace if anything exist on that index
        // just add a new element and keep all elements same and shift right elements
        list.add(2, "f");

        // replace the value on a particular index
        list.set(2, "e");

        // Here its removing element at index not the value 2
        list.remove(2);
        // Here its removing element
        list.remove("e");

        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.add(3);
        anotherList.add(2);
        anotherList.add(1);

        // It will remove value at index 1 that is 2
        anotherList.remove(1);

        System.out.println(anotherList);
        anotherList.add(2);

        // Now it will remove the value 2 from list
        // Now 1 is objected
        anotherList.remove(Integer.valueOf(2));

        anotherList.add(2);

        System.out.println(anotherList);

        // Sort
        // Only returning sorted list but not modifying the actual list
        // According to letters
        Collections.sort(list);
        // According to values
        Collections.sort(anotherList);
        System.out.println(list);
        System.out.println(anotherList);

        // Index of
        // If present then return the index
        // If not then return -1
        ArrayList<String> indexList = new ArrayList<>();
        indexList.add("a");
        indexList.add("b");
        indexList.add("c");
        int index = indexList.indexOf("a");
        System.out.println(index);
    }
}



