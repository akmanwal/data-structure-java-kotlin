package javademo.maths;

public class ReverseDigits {

    public static void main(String[] args) {
        reverseDigits(1234);
    }

    static void reverseDigits(int n) {

        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum = sum * 10 + digit;
            n = n / 10;
        }

        System.out.println(sum);
    }
}
