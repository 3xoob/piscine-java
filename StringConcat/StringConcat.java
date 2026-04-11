public class StringConcat {
    public static String concat(String s1, String s2) {
        String left = s1 == null ? "" : s1;
        String right = s2 == null ? "" : s2;
        return left + right;
    }
}
