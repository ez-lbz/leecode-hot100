package hot100.Solution9;

import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        char[] ps = p.toCharArray();
        Arrays.sort(ps);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String tmp = s.substring(i, i + p.length());
            char[] ss = tmp.toCharArray();
            Arrays.sort(ss);
            if (Arrays.equals(ps, ss)) {
                l.add(i);
            }
        }
        return l;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i : solution.findAnagrams("cbaebabacd", "abc")) {
            System.out.println(i);
        }
    }
}