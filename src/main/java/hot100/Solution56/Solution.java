package hot100.Solution56;

import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        backtrack(l, l1, nums,0);
        return l;
    }

    public void backtrack(List<List<Integer>> l, List<Integer> container, int nums[], int first) {
        if (first == nums.length) {
            l.add(new ArrayList<>(container));
            return;
        }

        container.add(nums[first]);
        backtrack(l, container, nums, first + 1);
        container.remove(container.size() - 1);

        backtrack(l, container, nums, first + 1);
    }
}