/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start

// Top-Down DP with Memorization
import java.util.*;
// class Solution {
//     private int[][] memo;
    
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length(), n = text2.length();
//         memo = new int[m][n];
//         for (int[] row: memo) {
//             Arrays.fill(row, -1);
//         }
//         return dp(text1, 0, text2, 0);
//     }
    
//     private int dp(String s1, int i, String s2, int j) {
//         if (i == s1.length() || j == s2.length()) {
//             return 0;
//         }
//         if (memo[i][j] != -1) return memo[i][j];
//         if (s1.charAt(i) == s2.charAt(j)) {
//             memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
//         } else {
//             memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
//         }
//         return memo[i][j];
//     }
// }

// Bottom-Up DP Approach
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length(), n = text2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 1; i <= m; i++) {
//             char character1 = text1.charAt(i - 1);
//             for (int j = 1; j <= n; j++) {
//                 char character2 = text2.charAt(j - 1);
//                 if (character1 == character2) {
//                     dp[i][j] = dp[i - 1][j - 1] + 1;
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
// @lc code=end

