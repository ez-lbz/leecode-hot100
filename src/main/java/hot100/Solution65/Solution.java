package hot100.Solution65;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int[] res = new int[] {-1, -1};

        int left = 0, right = nums.length - 1;
        int find = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                find = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (find == -1) return new int[]{-1, -1};

        for (int i = find - 1; i >= 0; i--) {
            if (nums[i] != target) {
                res[0] = i + 1;
                break;
            }
        }
        for (int i = find + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                res[1] = i - 1;
                break;
            }
        }
        if (res[0] == -1) res[0] = 0;
        if (res[1] == -1) res[1] = nums.length - 1;

        return res;

    }
}