package hot100.Solution98;

public class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        colors[0] = -1;
        colors[1] = -1;
        colors[2] = -1;
        colors[nums[0]] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (colors[0] == -1) {
                    colors[0] = 0;
                    int tmp = nums[i];
                    nums[i] = nums[0];
                    nums[0] = tmp;
                } else {
                    colors[0]++;
                    int tmp = nums[i];
                    nums[i] = nums[colors[0]];
                    nums[colors[0]] = tmp;
                }
            }
            if (nums[i] == 1) {
                if (colors[1] == -1) {
                    colors[1] = colors[0] + 1;
                    int tmp = nums[i];
                    nums[i] = nums[colors[1]];
                    nums[colors[1]] = tmp;
                } else {
                    colors[1]++;
                    int tmp = nums[i];
                    nums[i] = nums[colors[1]];
                    nums[colors[1]] = tmp;
                }
            }
        }
    }
}