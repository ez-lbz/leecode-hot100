package hot100.Solution62;

import java.util.*;

public class Solution {
    public boolean isOk(List<Integer> cache) {
        for (int i = 0; i < cache.size(); i++) {
            for (int j = i + 1; j < cache.size(); j++) {
                if (cache.get(i) == cache.get(j) || Math.abs(cache.get(i) - cache.get(j)) == j - i) return false;
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, n, new ArrayList<>(), 0);
        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < result.get(i).size(); j++) {
                String s = "";
                for (int k = 0; k < result.get(i).get(j); k++) {
                    s += '.';
                }
                s += 'Q';
                for (int k = result.get(i).get(j) + 1; k < n; k++) {
                    s += '.';
                }
                tmp.add(s);
            }
            ret.add(tmp);
        }
        return ret;
    }

    public boolean cut(List<Integer> cache) {
        if (cache.size() < 2) return true;
        for (int i = 0; i < cache.size() - 1; i++) {
            if (cache.get(i) == cache.get(cache.size() - 1)) return false;
        }
        return true;
    }

    public void backtrack(List<List<Integer>> result, int n, List<Integer> cache, int first) {
        if (!cut(cache)) return;
        if (cache.size() == n) {
            if (isOk(cache)) result.add(new ArrayList<>(cache));
            return;
        }

        for (int i = 0; i < n; i++) {
            cache.add(i);
            backtrack(result, n, cache, first + 1);
            cache.remove(cache.size() - 1);

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}