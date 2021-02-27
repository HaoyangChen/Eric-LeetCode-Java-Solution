/*
 * @lc app=leetcode id=799 lang=java
 *
 * [799] Champagne Tower
 */

// @lc code=start

// Time Complexity: O(R^2) - where R is the number of rows. As this is fixed, we can consider this complexity to be O(1)
// Space Complexity: O(R^2), or O(1) by the reasoning above
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double A[][] = new double[102][102];
        A[0][0] = (double) poured;
        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r + 1][c] += q;
                    A[r + 1][c + 1] += q;
                } 
            }
        }
        return Math.min(1, A[query_row][query_glass]);
    }
}
// @lc code=end

