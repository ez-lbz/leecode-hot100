package hot100.Solution57;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, "abc".toCharArray());
        map.put(3, "def".toCharArray());
        map.put(4, "ghi".toCharArray());
        map.put(5, "jkl".toCharArray());
        map.put(6, "mno".toCharArray());
        map.put(7, "pqrs".toCharArray());
        map.put(8, "tuv".toCharArray());
        map.put(9, "wxyz".toCharArray());
        List<String> result = new ArrayList<>();
        List<Character> cache = new ArrayList<>();
        backtrack(result, cache, map, digits, 0);
        return result;
    }

    public void backtrack(List<String> result, List<Character> cache, Map<Integer, char[]> map, String digits, int first) {
        if (first == digits.length()) {
            String tmp = "";
            for (Character c : cache) {
                tmp += c;
            }
            result.add(tmp);
            return;
        }

        int num = digits.charAt(first) - '0';
        for (char c : map.get(num)) {
            cache.add(c);
            backtrack(result, cache, map, digits, first + 1);
            cache.remove(cache.size() - 1);
        }
    }
}