package hot100.Solution87;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        cache[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, cache[j]);
                }
            }
            cache[i] = max + 1;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, cache[i]);
        }
        return max;
    }


}