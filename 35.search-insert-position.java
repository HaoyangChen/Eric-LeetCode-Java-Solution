/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start

// Method 1: Binary Search
// Time Complexity: O(logN) - where N is the length of the array. Because we shortened the array by half each time, the overall time complexity is O(logN)
// Space Complexity: O(1) - constant space is used 
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;

        if (nums[len - 1] < target) return len;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

