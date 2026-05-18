package hot100.Solution16;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] front = new int[nums.length];
        int[] back = new int[nums.length];
        front[0] = nums[0];
        back[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            front[i] = front[i - 1] * nums[i];
            back[nums.length - i - 1] = back[nums.length - i] * nums[nums.length - i - 1];
        }

        int[] ret = new int[nums.length];
        ret[0] = back[1];
        ret[nums.length - 1] = front[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            ret[i] = front[i - 1] * back[i + 1];
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.productExceptSelf(nums));
    }
}