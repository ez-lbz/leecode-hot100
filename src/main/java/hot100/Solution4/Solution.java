package hot100.Solution4;

import java.util.*;

public class Solution {
    public void moveZeroes(int[] nums) {
        int[] tmp = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp[j++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }
}