package hot100.Solution55;

// 这题挺套路的，但我不太会
// 需要格外注意深浅拷贝的问题

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        backtrack(res, list, 0);
        return res;

    }

    public void backtrack(List<List<Integer>> l, List<Integer> nums, int first) {
        if (first == nums.size()) {
            l.add(new ArrayList<Integer>(nums));
        }
        for (int i = first; i < nums.size(); i++) {
            Collections.swap(nums, first, i);
            backtrack(l, nums, first + 1);
            Collections.swap(nums, first, i);
        }
    }
}