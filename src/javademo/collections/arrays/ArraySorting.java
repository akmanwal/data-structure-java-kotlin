package javademo.collections.arrays;

import java.util.Arrays;

public class ArraySorting {

    public static void main(String[] args) {

        int[] array = {5, 6, 4, 7, 3, 9, 1};
        bubbleSort(array);
    }


    static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }


}
