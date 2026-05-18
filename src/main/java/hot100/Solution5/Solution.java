package hot100.Solution5;

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            } else {
                right--;
                max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            }
        }
        return max;
    }
}