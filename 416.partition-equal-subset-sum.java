/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start

// Method 1: Bottom-up Dynamic Programming Approach
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum = 0;
//         for (int num: nums) {
//             sum += num;
//         }
//         if (sum % 2 == 1) return false;
//         sum = sum / 2;
//         int n = nums.length;
//         boolean[][] dp = new boolean[n + 1][sum + 1];
//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = true;
//         }
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= sum; j++) {
//                 if (j - nums[i - 1] < 0) {
//                     dp[i][j] = dp[i - 1][j];
//                 } else {
//                     dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
//                 }
//             }
//         }
//         return dp[n][sum];
//     }
// }


// Method 2: Optimized DP Approach using 1D Array
// Time Complexity: O(m * n) where m is the subset sum, and n is the number of array elements
// Space Complexity: O(m) since we use an array of size m to store the result of subproblems
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum % 2 == 1) return false;
        int n = nums.length;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}

// @lc code=end

