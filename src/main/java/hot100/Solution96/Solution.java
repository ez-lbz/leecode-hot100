package hot100.Solution96;

// 没想到，妙妙小办法了说是

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;

    }
}