package hot100.Solution81;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int i = 1, j = 2;
        int result = 0;
        for (int k = 3; k <= n; k++) {
            result = i + j;
            i = j;
            j = result;
        }
        return result;

    }
}