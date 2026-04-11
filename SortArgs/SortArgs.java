import java.util.Arrays;
import java.util.Comparator;

public class SortArgs {
    public static void sort(String[] args) {
        if (args == null) {
            return;
        }
        String[] copy = Arrays.copyOf(args, args.length);
        Arrays.sort(copy, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int left = Integer.parseInt(a);
                int right = Integer.parseInt(b);
                return Integer.compare(left, right);
            }
        });
        if (copy.length == 0) {
            System.out.println();
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < copy.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(copy[i]);
        }
        sb.append('\n');
        System.out.print(sb.toString());
    }
}
