import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        int index = list.lastIndexOf(value);
        return index >= 0 ? index : null;
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        int index = list.indexOf(value);
        return index >= 0 ? index : null;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> indexes = new ArrayList<>();
        if (list == null) {
            return indexes;
        }

        for (int i = 0; i < list.size(); i++) {
            if (value == null ? list.get(i) == null : value.equals(list.get(i))) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
