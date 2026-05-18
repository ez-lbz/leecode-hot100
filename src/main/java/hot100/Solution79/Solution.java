package hot100.Solution79;

public class Solution {
    public int jump(int[] nums) {
        int lastJump = nums.length - 1;
        int jumpTimes = 0;
        while (lastJump > 0) {
            int lastStep = lastJump;
            for (int i = lastJump; i >= 0; i--) {
                if (i + nums[i] >= lastJump) {
                    lastStep = i;
                }
            }
            lastJump = lastStep;
            jumpTimes++;
        }
        return jumpTimes;
    }
}