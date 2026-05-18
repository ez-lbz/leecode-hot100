package hot100.Solution88;

public class Solution {
    public int maxProduct(int[] nums) {
        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        int max = cache[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                cache[j] = cache[j] * nums[i];
                max = Math.max(max, cache[j]);
            }
            cache[i] = nums[i];
            max = Math.max(max, cache[i]);
        }
        return max;

    }
}