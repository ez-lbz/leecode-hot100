package hot100.Solution66;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[nums.length - 1] < nums[0]) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] > nums[0] && (nums[mid] < target || target <= nums[nums.length - 1])) left = mid + 1;
                else if (nums[mid] < nums[nums.length - 1] && (nums[mid] > target || target >= nums[0])) right = mid - 1;
                else if (nums[mid] > nums[0] && nums[mid] > target) {
                    right = mid - 1;
                    break;
                } else {
                    left = mid + 1;
                    break;
                }
            }
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
        }

        return -1;
    }
}