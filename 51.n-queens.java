/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] chess, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                solve(res, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] chess, int row, int col) {
        // check if above contains queen
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // check if top-right contains queen
        for (int i = row - 1, j = col + 1; i >=0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // check if top-left contains queen
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}
// @lc code=end

