/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;
            
            if (k < 0) {
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}
// @lc code=end

