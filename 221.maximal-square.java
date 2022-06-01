/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start

// Approach 1: (Dynamic Programming)
// public class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
//         int[][] dp = new int[rows + 1][cols + 1];
//         int maxsqlen = 0;
//         for (int i = 1; i <= rows; i++) {
//             for (int j = 1; j <= cols; j++) {
//                 if (matrix[i-1][j-1] == '1'){
//                     dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
//                     maxsqlen = Math.max(maxsqlen, dp[i][j]);
//                 }
//             }
//         }
//         return maxsqlen * maxsqlen;
//     }
// }

// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int m = matrix.length, n = matrix[0].length;
//         int[][] dp = new int[m][n];
//         for (int i = 0; i < m; i++) {
//             dp[i][0] = matrix[i][0] - '0';
//         }
//         for (int j = 0; j < n; j++) {
//             dp[0][j] = matrix[0][j] - '0';
//         }
        
//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (matrix[i][j] == '0') continue;
//                 dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
//             }
//         }
//         int length = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 length = Math.max(length, dp[i][j]);
//             }
//         }
//         return length * length;
//     }
// }

// Approach 2: Better Dynamic Programming
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}
// @lc code=end

