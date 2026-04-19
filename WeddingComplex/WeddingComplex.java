import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> engagedFirstToSecond = new HashMap<>();
        if (first == null || second == null || first.isEmpty() || second.isEmpty()) {
            return engagedFirstToSecond;
        }

        Map<String, String> engagedSecondToFirst = new HashMap<>();
        Map<String, Integer> nextChoiceIndex = new HashMap<>();
        for (String proposer : first.keySet()) {
            nextChoiceIndex.put(proposer, 0);
        }

        Map<String, Map<String, Integer>> preferenceRank = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : second.entrySet()) {
            Map<String, Integer> rank = new HashMap<>();
            List<String> prefs = entry.getValue();
            for (int i = 0; i < prefs.size(); i++) {
                rank.put(prefs.get(i), i);
            }
            preferenceRank.put(entry.getKey(), rank);
        }

        Queue<String> free = new ArrayDeque<>(first.keySet());

        while (!free.isEmpty()) {
            String proposer = free.poll();
            List<String> prefs = first.get(proposer);
            int index = nextChoiceIndex.get(proposer);
            if (prefs == null || index >= prefs.size()) {
                continue;
            }

            String candidate = prefs.get(index);
            nextChoiceIndex.put(proposer, index + 1);

            String current = engagedSecondToFirst.get(candidate);
            if (current == null) {
                engagedSecondToFirst.put(candidate, proposer);
                engagedFirstToSecond.put(proposer, candidate);
                continue;
            }

            Map<String, Integer> candidateRanks = preferenceRank.get(candidate);
            int rankNew = candidateRanks.getOrDefault(proposer, Integer.MAX_VALUE);
            int rankCurrent = candidateRanks.getOrDefault(current, Integer.MAX_VALUE);

            if (rankNew < rankCurrent) {
                engagedSecondToFirst.put(candidate, proposer);
                engagedFirstToSecond.put(proposer, candidate);
                engagedFirstToSecond.remove(current);
                free.offer(current);
            } else {
                free.offer(proposer);
            }
        }

        return engagedFirstToSecond;
    }
}
