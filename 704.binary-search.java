/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start

// Method: Binary Search
// Time Complexity: O(logN)
// Space Complexity: O(1) since it is a constant space solution
class Solution {
    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] < target) {
                left = pivot + 1;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else if (nums[pivot] == target) {
                return pivot;
            }
        }
        return -1;
    }
}
// @lc code=end

