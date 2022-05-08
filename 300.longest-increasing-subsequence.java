/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
import java.util.*;

// Method: Dynamic Programming
// Time Comlpexity: O(N^2)
// Space Complexity: O(N) - The only extra space used relative to the input size is the dp array, which is the same length as the given nums array
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int result = 0;
        for (int num: dp) {
            result = Math.max(result, num);
        }
        return result;
    }
}
// @lc code=end

