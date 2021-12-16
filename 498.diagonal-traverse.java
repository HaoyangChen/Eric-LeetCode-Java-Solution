/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start

// Time Complexity: O(N * M) each element of the matrix is processed exactly once.
// Space Complexity: O(1) since no additional data sttructure is used.
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int N = mat.length;
        int M = mat[0].length;
        
        int row = 0, column = 0, direction = 1, r = 0;
        int[] result = new int[N * M];
        while (row < N && column < M) {
            result[r++] = mat[row][column];
            int newRow = row + (direction == 1 ? -1 : 1);
            int newCol = column + (direction == 1 ? 1 : -1);
            if (newRow < 0 || newRow == N || newCol < 0 || newCol == M) {
                if (direction == 1) {
                    row += (column == M - 1 ?  1 : 0);
                    column += (column < M - 1 ?  1: 0);
                } else {
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }
                direction = 1 - direction;
            } else {
                row = newRow;
                column = newCol;
            }
        }
        return result;
        
    }
}
// @lc code=end

