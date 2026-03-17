package javademo.leetcode;

public class SubPalindromes {

    public static void main(String[] args) {

        findAllPalindromes("aba");
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void findAllPalindromes(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);      // Odd length
            expand(s, i, i + 1);  // Even length
        }
    }

    private static void expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            System.out.println(s.substring(left, right + 1));
            left--;
            right++;
        }
    }
}
