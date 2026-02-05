package javademo.maths;

public class SumOfDigits {

    public static void main(String[] args) {
        getSum(12345);
    }

    static void getSum(int number) {
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            number /= 10;
            sum += digit;
        }

        System.out.println(sum);
    }
}
