/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    int[] directionInX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] directionInY = {1, 0, -1, 0, 1, -1, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }
    
    private void dfs(char[][] board, int x, int y) {
        int count = 0;
        
        for (int i = 0; i < 8; i++) {
             int newX = x + directionInX[i];
            int newY = y + directionInY[i];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
            if (board[newX][newY] == 'M') ++count;   
        }
        
        if (count > 0) {
            board[x][y] = (char)(count + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; ++i) {
                int newX = x + directionInX[i];
                int newY = y + directionInY[i];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || board[newX][newY] != 'E') continue;
                dfs(board, newX, newY);
            }
        }
    }
}
// @lc code=end

