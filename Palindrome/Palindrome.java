public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
