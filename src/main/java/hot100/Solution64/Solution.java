package hot100.Solution64;

// 二分查找的开闭区间问题

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][matrix[0].length - 1] == target) {
                return true;
            } else if (matrix[mid][matrix[0].length - 1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int bar = left;
        left = 0; right = matrix[bar].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[bar][mid] == target) {
                return true;
            } else if (matrix[bar][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}