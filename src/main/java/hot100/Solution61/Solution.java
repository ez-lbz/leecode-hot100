package hot100.Solution61;

// 因为 substring 也没少踩坑

import java.util.*;

public class Solution {
    public boolean isOk(String s) {
        for (int i = 0; i < s.length() / 2 ; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0, 1);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> cache, String s, int left, int right) {
        if (cache.size() != 0 && !isOk(cache.get(cache.size() - 1))) return;
        if (left >= s.length() || right > s.length()) return;
        if (right == s.length()) {
            List<String> tmp = new ArrayList<>(cache);
            tmp.add(s.substring(left, right));
            if (isOk(tmp.get(tmp.size() - 1))) {
                result.add(tmp);
            }
            return;
        }

        cache.add(s.substring(left, right));
        backtrack(result, cache, s, right, right + 1);
        cache.remove(cache.size() - 1);

        backtrack(result, cache, s, left, right + 1);
    }
}