package javademo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

    public static void main(String[] args) {

        String brackets = "[({})]";
        System.out.println(isValid(brackets));
    }

    private static boolean isValid(String brackets) {

        char[] array = brackets.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : array) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (c != ')' && top == '(') {
                    return false;
                }
                if (c != '}' && top == '{') {
                    return false;
                }

                if (c != ']' && top == '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
