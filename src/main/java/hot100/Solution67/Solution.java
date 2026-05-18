package hot100.Solution67;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums[left] <= nums[right]) return nums[left];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[nums.length - 1]) right = mid - 1;
            else left = mid + 1;
        }

        return nums[left];


    }
}