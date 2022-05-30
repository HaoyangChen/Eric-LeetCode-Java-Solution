/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n -1));
    }

    private int robRange(int[] nums, int start, int end) {
        int dpNext = 0, dpNextNext = 0, dpCurrent = 0;
        for (int i = end; i >= start; i--) {
            dpCurrent = Math.max(dpNext, nums[i] + dpNextNext);
            dpNextNext = dpNext;
            dpNext = dpCurrent; 
        }
        return dpCurrent;
    }
}
// @lc code=end

