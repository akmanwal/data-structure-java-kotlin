package javademo.maths;

public class Armstrong {


    public static void main(String[] args) {
        checkArmstrong(153);
    }

    public static void checkArmstrong(int num) {

        int number = num;
        if (number < 0) {
            throw new IllegalArgumentException("Number is negative");
        } else {

            int length = String.valueOf(number).length();
            int sum = 0;
            while (length > 0) {
                int digit = number % 10;
                number = number / 10;
                sum += digit * digit * digit;
                length--;
            }

            if (sum == num) {
                System.out.println("It's an Armstrong number: " + num);
            } else {
                System.out.println("Not Armstrong number: " + num);
            }
        }
    }
}
