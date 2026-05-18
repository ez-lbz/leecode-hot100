package hot100.Solution60;

// 这里的剪枝策略 Debug 了好久

public class Solution {
    public boolean exist(char[][] board, String word) {
        char[][] visited = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && exist(board, visited, "", word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[][]board, char[][] visited, String cache, String word, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (visited[row][col] != 0) return false;
        if (word.equals(cache + board[row][col])) return true;
        if (!(word.substring(0, cache.length() + 1)).equals(cache  + board[row][col])) return false;


        boolean result = false;

        visited[row][col] = '*';
        cache += board[row][col];
        result = result || exist(board, visited, cache, word, row + 1, col) || exist(board, visited, cache, word, row, col + 1) || exist(board, visited, cache, word, row, col - 1) || exist(board, visited, cache, word, row - 1, col);
        cache = cache.substring(0, cache.length() - 1);
        visited[row][col] = 0;


        return result;
    }
}