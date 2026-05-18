package hot100.Solution13;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}