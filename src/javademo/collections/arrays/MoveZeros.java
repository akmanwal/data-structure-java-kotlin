package javademo.collections.arrays;

public class MoveZeros {

    public static void main(String[] args) {

        int[] array = {0, 5, 4, 0, 3, 2, 0, 9, 1};
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[count++] = array[i];
            }
        }

        while (count < array.length) {
            array[count++] = 0;
        }

        for (int j : array) {
            System.out.print(j + " ");
        }

    }
}
