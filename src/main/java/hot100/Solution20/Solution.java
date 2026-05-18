package hot100.Solution20;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];           // 左上 ← 左下
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // 左下 ← 右下
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // 右下 ← 右上
                matrix[j][n - 1 - i] = tmp;                    // 右上 ← 左上
            }
        }
    }
}