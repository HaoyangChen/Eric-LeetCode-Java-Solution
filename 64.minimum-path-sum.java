/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start

import java.util.*;

// public class Solution {
//     public int calculate(int[][] grid, int i, int j) {
//         if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
//         if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
//         return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
//     }
//     public int minPathSum(int[][] grid) {
//         return calculate(grid, 0, 0);
//     }
// }

// Method 1: Recursion with Memorization
// class Solution {
//     int[][] memo;
//     public int minPathSum(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         memo = new int[m][n];
//         for (int[] row: memo) {
//             Arrays.fill(row, -1);
//         }
//         return dp(grid, m - 1, n - 1);
//     }
    
//     private int dp(int[][] grid, int i, int j) {
//         if (i == 0 && j == 0) return grid[0][0];
//         if (i < 0 || j < 0) return Integer.MAX_VALUE;
//         if (memo[i][j] != -1) return memo[i][j];
//         memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
//         return memo[i][j];
//     }
// }

// Method: Bottom Up DP
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

