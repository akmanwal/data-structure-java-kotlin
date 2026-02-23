package javademo.collections.strings;

import java.util.Arrays;

public class CheckAnagram {

    public static void main(String[] args) {

        String string1 = "ashish";
        String string2 = "hsihsa";

        char[] array1 = string1.toCharArray();
        char[] array2 = string2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        boolean result =  Arrays.equals(array1, array2);

        System.out.println(result);
    }
}
