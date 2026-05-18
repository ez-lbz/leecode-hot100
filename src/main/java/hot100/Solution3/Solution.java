package hot100.Solution3;

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                map.put(num, map.get(num - 1) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int max = Collections.max(map.values());
        return max;
    }
}