package hot100.Solution19;

import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> ret = new ArrayList<>();
        int stat = 0;
        int row = 0, col = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            if (matrix[row][col] == -99999) break;
            ret.add(matrix[row][col]);
            matrix[row][col] = -99999;
            int testrow = row + directions[stat % 4][0];
            int testcol = col + directions[stat % 4][1];
            if (testrow == matrix.length || testrow == -1 || testcol == matrix[0].length || testcol == -1 || matrix[testrow][testcol] == -99999) {
                stat++;
            }
            row += directions[stat % 4][0];
            col += directions[stat % 4][1];
        }
        return ret;
    }
}