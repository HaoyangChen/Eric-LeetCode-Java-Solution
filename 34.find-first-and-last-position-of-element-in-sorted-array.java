/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start

// Binary Search
// Time Complexity: O(logN)
// Space Complexity: O(1) - All work is done in place, so the overall memory usage is constant
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] targetRange = {-1, -1};
        int leftIndex = extremeInsertionIndex(nums, target, true);

        // assert that "leftIndex" is within the array bounds and that "target" is actually in "nums"
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }
        targetRange[0] = leftIndex;
        // subtract 1 to get rightmost index
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
        return targetRange;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0; 
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || left && target == nums[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
// @lc code=end

