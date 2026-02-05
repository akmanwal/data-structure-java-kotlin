package javademo.collections;

public class VowelsCount {

    public static void main(String[] args) {

        String string = "aeiouAshish";

        int count = 0;

        for(int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        System.out.println(count);
    }

}
