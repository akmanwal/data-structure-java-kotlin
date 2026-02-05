package javademo.collections;

public class SwapNumbers {

    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        System.out.println("Before swapping a: " + a);
        System.out.println("Before swapping b: " + b);

        a = a + b; //6
        b = a - b; // 2
        a = a - b;

        System.out.println("After swapping a: " + a);
        System.out.println("After swapping b: " + b);
    }
}
