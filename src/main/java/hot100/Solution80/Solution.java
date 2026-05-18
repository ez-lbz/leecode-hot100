package hot100.Solution80;

import java.util.*;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c)[1] = i;
            } else {
                map.put(c, new int[]{i, i});
            }
        }
        List<Integer> res = new ArrayList<>();
        int rightBound = 0, leftBound = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > rightBound) {
                res.add(rightBound - leftBound + 1);
                leftBound = i;
                rightBound = map.get(s.charAt(i))[1];
            } else {
                rightBound = Math.max(rightBound, map.get(s.charAt(i))[1]);
            }
        }
        res.add(rightBound - leftBound + 1);
        return res;
    }
}