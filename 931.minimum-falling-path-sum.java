/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int result = Integer.MAX_VALUE;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp(matrix, n - 1, j)); 
        }
        return result;
    }
    
    private int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 99999;
        if (i == 0) return matrix[i][j];
        if (memo[i][j] != 66666) return memo[i][j];
        memo[i][j] = matrix[i][j] + findMin(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }
    
    private int findMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
// @lc code=end

