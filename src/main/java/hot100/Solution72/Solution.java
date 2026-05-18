package hot100.Solution72;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[] {0};
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        stack.push(new int[] {0, temperatures[0]});
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] top = stack.pop();
                res[top[0]] = i - top[0];
            }
            stack.push(new int[] {i, temperatures[i]});

        }
        return res;
    }
}