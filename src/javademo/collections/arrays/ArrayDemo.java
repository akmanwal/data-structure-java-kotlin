package javademo.collections.arrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayDemo {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 4, 5};

        int size = removeDuplicates(arr);

        for (int i = 0; i < size; i++) {
            //System.out.print(arr[i] + " ");
        }

        int[] arr2 = {2, 3, 2, 5, 1, 2, 1, 6, 7};
        int[] sortedArray = removeDuplicates2(arr2);

        for (int j : sortedArray) {
            System.out.print(j + " ");
        }
    }

    // remove duplicates from a sorted array
    static int removeDuplicates(int[] arr) {

        int length = arr.length;
        int index = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[index++] = arr[i];
            }
        }

        return index;
    }

    // remove duplicates from an unsorted array
    static int[] removeDuplicates2(int[] arr) {
        // 1. Create a LinkedHashSet to store unique elements
        Set<Integer> set = new LinkedHashSet<>();

        // 2. Iterate through the array and add elements to the Set.
        // Duplicates are automatically ignored.
        for (int element : arr) {
            set.add(element);
        }

        // 3. Convert the Set back to an array
        // The size of the new array is the size of the Set
        int[] arr2 = new int[set.size()];
        int index = 0;

        for (int element : set) {
            arr2[index++] = element;
        }

        return arr2;
    }
}
