/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int largestSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentMax = Math.max(num, currentMax + num);
            largestSum = Math.max(largestSum, currentMax);
        }
        return largestSum;
    }
}
// @lc code=end

