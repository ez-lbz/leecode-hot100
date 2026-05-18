package hot100.Solution89;

// 这题挺难的，我起初只想到了回溯解法，实际上可以用背包法

//public class Solution {
//    boolean flag = false;
//
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int i : nums) {
//            sum += i;
//        }
//
//        backtrack(sum, nums, 0, 0, 0);
//        return flag;
//
//    }
//
//    public void backtrack(int sum, int[] nums, int left, int right, int first) {
//        if (flag || left > sum / 2 || right > sum / 2) return;
//        if (first == nums.length) {
//            if (left == right) flag = true;
//            return;
//        }
//
//        backtrack(sum, nums, left + nums[first], right, first + 1);
//        backtrack(sum, nums, left, right + nums[first], first + 1);
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.canPartition(new int[]{1,5,11,5}));
//    }
//
//}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum / 2 * 2 != sum || sum / 2 < maxNum) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length][target + 1];

        for (int  i = 0; i < nums.length; i++) dp[i][0] = true;
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
            }
        }
        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1,5,11,5}));
    }
}


