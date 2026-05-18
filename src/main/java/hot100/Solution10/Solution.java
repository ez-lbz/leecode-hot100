package hot100.Solution10;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    num++;
                }
            }
        }
        return num;
    }
}