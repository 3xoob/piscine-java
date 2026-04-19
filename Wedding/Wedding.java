import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        Map<String, String> couples = new HashMap<>();
        if (first == null || second == null || first.isEmpty() || second.isEmpty()) {
            return couples;
        }

        List<String> firstList = new ArrayList<>(first);
        List<String> secondList = new ArrayList<>(second);

        Random random = new Random();
        for (int i = secondList.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String tmp = secondList.get(i);
            secondList.set(i, secondList.get(j));
            secondList.set(j, tmp);
        }

        int count = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < count; i++) {
            couples.put(firstList.get(i), secondList.get(i));
        }

        return couples;
    }
}
