package hot100.Solution86;

import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        List<Integer> cache = new ArrayList<>();
        boolean[] visited = new boolean[s.length() + 1];
        cache.add(0);
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < cache.size(); j++) {
                String ss = s.substring(cache.get(j), i + 1);
                if (set.contains(ss) && !visited[i + 1]) {
                    cache.add(i + 1);
                    visited[i + 1] = true;
                }
            }
        }
        return cache.get(cache.size() - 1) == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa")));
    }
}