package hot100.Solution99;

// 这题没看懂题干，挺脑筋急转弯的，二刷时一定要多看

 public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        // 1. 从后往前，找到第一个下降点 i
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果 i < 0，说明整个数组已经是降序了（比如 321），直接跳到第 3 步翻转整个数组
        if (i >= 0) {
            // 2. 从后往前，找到第一个比 nums[i] 大的数 j
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // 交换 i 和 j
            swap(nums, i, j);
        }

        // 3. 无论是哪种情况，都需要将 i 后面的部分序列逆序（让其变成升序，达到最小增幅）
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}