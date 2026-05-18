package hot100.Solution78;

public class Solution {
    public boolean canJump(int[] nums) {
        int maxLocation = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxLocation) return false;
            maxLocation = Math.max(maxLocation, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }
}