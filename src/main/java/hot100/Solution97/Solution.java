package hot100.Solution97;

// 可以采用抽签法，随机抽一个验证

import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                if (map.get(num) > nums.length / 2) return num;
            } else {
                map.put(num, 1);
            }
        }
        return nums[0];

    }
}