package hot100.Solution11;


import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            q.add(new int[]{nums[i], i});
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(q.peek()[0]);
        for (int i = 1; i < nums.length - k + 1; i++) {
            q.add(new int[]{nums[i + k - 1], i + k - 1});
            while (q.peek()[1] < i) {
                q.poll();
            }
            ans.add(q.peek()[0]);
        }
        return ans.stream().mapToInt(i -> i).toArray();

    }
}