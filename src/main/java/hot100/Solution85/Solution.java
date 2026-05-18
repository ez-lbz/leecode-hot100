package hot100.Solution85;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        cache[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    min = Math.min(min, cache[i - coins[j]]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                cache[i] = min + 1;
            } else {
                cache[i] = Integer.MAX_VALUE;
            }
        }
        if (cache[amount] != Integer.MAX_VALUE) {
            return cache[amount];
        } else {
            return -1;
        }
    }
}