package hot100.Solution52;

import java.util.*;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 0;
        while (!q.isEmpty()) {
           q.add(null);
           while (q.peek() != null) {
               int[] pos = q.poll();
               for (int[] d : directions) {
                   int x = pos[0] + d[0];
                   int y = pos[1] + d[1];
                   if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                       q.add(new int[]{x, y});
                       grid[x][y] = 2;
                   }
               }

           }

            q.poll();
            result++;
        }

        if (result > 0) result --;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return result;
    }
}