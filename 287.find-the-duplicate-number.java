/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
// Method 1: Sorting
// Time Complexity: O(nlogn) - The sort invocation costs O(nlogn) time in python and java, so it dominates the subsequent linear scan
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return -1;
    }
}
// @lc code=end

