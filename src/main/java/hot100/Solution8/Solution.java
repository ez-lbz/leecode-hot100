package hot100.Solution8;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0 , left = 0;
        while (left < s.length()) {
            int right = left + 1;
            Set<Character> c = new HashSet<Character>();
            c.add(s.charAt(left));
            while (right < s.length() && !c.contains(s.charAt(right))) {
                c.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - left);
            left++;
        }
        return max;
    }
}