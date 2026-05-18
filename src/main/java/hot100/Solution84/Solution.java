package hot100.Solution84;

// 这个思路有点奇特

public class Solution {
    public int numSquares(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, cache[i - j * j]);
            }
            cache[i] = min + 1;
        }
        return cache[n];
    }
}