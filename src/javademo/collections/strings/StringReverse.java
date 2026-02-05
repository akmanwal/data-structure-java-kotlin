package javademo.collections.strings;

public class StringReverse {

    public static void main(String[] args) {
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
}
