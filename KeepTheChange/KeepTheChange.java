import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        if (amount < 0 || coins == null || coins.isEmpty()) {
            return List.of();
        }

        List<Integer> validCoins = coins.stream()
                .filter(c -> c != null && c > 0)
                .sorted(Comparator.reverseOrder())
                .toList();

        if (validCoins.isEmpty()) {
            return List.of();
        }

        int[] minCount = new int[amount + 1];
        int[] previousCoin = new int[amount + 1];
        int inf = amount + 1;

        for (int i = 1; i <= amount; i++) {
            minCount[i] = inf;
            previousCoin[i] = -1;
            for (Integer coin : validCoins) {
                if (coin <= i && minCount[i - coin] + 1 < minCount[i]) {
                    minCount[i] = minCount[i - coin] + 1;
                    previousCoin[i] = coin;
                }
            }
        }

        if (amount > 0 && previousCoin[amount] == -1) {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();
        int remaining = amount;
        while (remaining > 0) {
            int coin = previousCoin[remaining];
            if (coin == -1) {
                return List.of();
            }
            result.add(coin);
            remaining -= coin;
        }

        result.sort(Collections.reverseOrder());
        return result;
    }
}
