/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 */

// @lc code=start

// Time Complexity: O(m * n) since we need to fill in the dp array of size m * n. Here m and n refer to the lengths of s1 and s2.
// Space Complexity: O(m * n) since dp array of size m * n is used
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int lcs = longestCommonSubsequence(word1, word2);
        return m - lcs + n - lcs;
    }
    
    private int longestCommonSubsequence(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

