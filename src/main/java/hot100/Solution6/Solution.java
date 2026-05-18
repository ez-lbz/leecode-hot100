package hot100.Solution6;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> s = new HashSet<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (m.containsKey(-nums[i] - nums[j]) && m.get(-nums[i] - nums[j]) != j) {
                    List<Integer> tmp = new ArrayList<>(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
                    Collections.sort(tmp);
                    s.add(tmp);
                }
            }
            m.put(nums[i], i);
        }
        List<List<Integer>> l = new ArrayList<>(s);
        return l;
    }
}