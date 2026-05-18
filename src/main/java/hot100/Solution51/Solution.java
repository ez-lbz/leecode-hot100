package hot100.Solution51;

public class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    backtrack(grid, visited, i, j);
                }
            }
        }
        return result;
    }

    public void backtrack(char[][] grid, boolean[][] visited, int row, int col) {
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited[row][col]) return;
        visited[row][col] = true;
        if (grid[row][col] == '0') return;

        backtrack(grid, visited, row - 1, col);
        backtrack(grid, visited, row + 1, col);
        backtrack(grid, visited, row, col - 1);
        backtrack(grid, visited, row, col + 1);


    }
}