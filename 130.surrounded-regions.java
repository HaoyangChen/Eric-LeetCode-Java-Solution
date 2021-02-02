/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
// Shangan Solution
class Solution {
    private static int[] xBias = {0, 0, 1, -1};
    private static int[] yBias = {1, -1, 0, 0};
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '-';
                queue.offer(i * col);
            }
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = '-';
                queue.offer(i * col + col - 1);
            }

        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '-';
                queue.offer(i);
            }
            if (board[row - 1][i] == 'O') {
                board[row - 1][i] = '-';
                queue.offer((row - 1) * col + i);
            }
        }
        
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int i = num / col;
            int j = num % col;
            for (int k = 0; k < xBias.length; k++) {
                int newI = i + xBias[k];
                int newJ = j + yBias[k];
                if (newI < 0 || newI >= row || newJ < 0 || newJ >= col || board[newI][newJ] != 'O') {
                    continue;
                }
                queue.offer(newI * col + newJ);
                board[newI][newJ] = '-';
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
// @lc code=end

