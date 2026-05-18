package hot100.Solution58;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, candidates, target, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> cache, int[] candidates, int target, int first) {
        if (target < 0 || first >= candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(cache));
            return;
        }

        cache.add(candidates[first]);
        if (target >= candidates[first]) {
            backtrack(result, cache, candidates, target - candidates[first], first);
        }
        cache.remove(cache.size() - 1);

        backtrack(result, cache, candidates, target, first + 1);
    }
}