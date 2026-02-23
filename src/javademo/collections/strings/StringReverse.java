package javademo.collections.strings;

public class StringReverse {

    public static void main(String[] args) {

        methodOne();
       int result = methodTwo("madam");
       System.out.println(result);
    }

    private static void methodOne() {
        String string = "Ashish";
        StringBuilder sb = new StringBuilder(string);

        for (int i = string.length() - 1; i >= 0; i--) {
            sb.append(string.charAt(i));
        }

        if (string.contentEquals(sb)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }

    static int methodTwo(String string) {

        int left = 0;
        int right = string.length() - 1;

        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return 0;
            }

            left++;
            right--;
        }

        return 1;
    }
}
