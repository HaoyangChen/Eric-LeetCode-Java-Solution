/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N + 1];
    int[][] cols = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];
    char[][] board;
    boolean sudokusolved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public void placeNumber(int d, int row, int col) {
        int index = (row / n) * n + col / n;
        rows[row][d]++;
        cols[col][d]++;
        boxes[index][d]++;
        board[row][col] = (char)(d + '0');
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    if (!sudokusolved) removeNumber(d, row, col);
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    public boolean couldPlace(int d, int row, int col) {
        int index = (row / n) * n + col / n;
        return rows[row][d] + cols[col][d] + boxes[index][d] == 0;
    }

    public void placeNextNumbers(int row, int col) {
        if ((col == N - 1) && (row == N - 1)) {
            sudokusolved = true;
        } else {
            if (col == N - 1) backtrack(row + 1, 0);
            else backtrack(row, col + 1);
        }
    }

    public void removeNumber(int d, int row, int col) {
        int index = (row / n) * n + col / n;
        rows[row][d]--;
        cols[col][d]--;
        boxes[index][d]--;
        board[row][col] = '.';
    }

}
// @lc code=end

