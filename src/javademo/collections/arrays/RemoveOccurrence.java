package javademo.collections.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveOccurrence {
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 5, 1, 2, 5, 6, 7};
        int element = 2;

        ArrayList<Integer> list = new ArrayList<>();

        for (int item : arr) {
            if (item != element) {
                list.add(item);
            }
        }

        //list.removeAll(List.of(element));

        int[] newArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            newArray[i] = list.get(i);
        }

        System.out.println(Arrays.toString(newArray));
    }
}
