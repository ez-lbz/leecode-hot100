package hot100.Solution59;

import java.util.*;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String cache = "";
        backtrack(res, cache, n, n);
        return res;
    }

    public void backtrack(List<String> result, String cache, int left, int right) {
        if (right < left) return;
        if (left == 0) {
            String tmp = new String(cache);
            for (int i = 0; i < right; i++) {
                tmp += ')';
            }
            result.add(tmp);
            return;
        }

        cache += '(';
        backtrack(result, cache, left - 1, right);
        cache = cache.substring(0, cache.length() - 1);

        cache += ')';
        backtrack(result, cache, left, right - 1);
        cache = cache.substring(0, cache.length() - 1);
    }
}