package hot100.Solution2;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            if (!ans.containsKey(tmp)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                ans.put(tmp, list);
            } else {
                ans.get(tmp).add(strs[i]);
            }
        }
        return new ArrayList<>(ans.values());
    }
}