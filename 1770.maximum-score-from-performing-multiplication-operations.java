/*
 * @lc app=leetcode id=1770 lang=java
 *
 * [1770] Maximum Score from Performing Multiplication Operations
 */

// @lc code=start

// Top Down Approach
class Solution {
    private int[][] memo;
    private int[] nums, multipliers;
    private int n, m;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        this.memo =  new int[m][m];
        return dp(0, 0);
    }
    
    private int dp(int i, int left) {
        if (i == m) return 0; // base case
        int multi = multipliers[i];
        int right = n - 1 - (i - left);
        if (memo[i][left] == 0) {
            memo[i][left] = Math.max(multi * nums[left] + dp(i + 1, left + 1), multi * nums[right] + dp(i + 1, left));
        }
        return memo[i][left];
    }
}
// @lc code=end

