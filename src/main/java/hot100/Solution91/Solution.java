package hot100.Solution91;

public class Solution {
    public int uniquePaths(int m, int n) {
        int all = (n - 1) + (m - 1);
        int result = 1, min = Math.min(m - 1, n - 1);
        for (int i = 0; i < min; i++) {
            result = result * (all - i);
            result = result / (i + 1);
        }

        return (int) result;

    }
}