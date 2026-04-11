public class StringConcat {
    public static String concat(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return null;
        }
        String left = s1 == null ? "" : s1;
        String right = s2 == null ? "" : s2;
        return left + right;
    }
}
