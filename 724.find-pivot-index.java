/*
 * @lc app=leetcode id=724 lang=java
 *
 * [724] Find Pivot Index
 */

// @lc code=start

// Method: Prefix Sum
// Time Complexity: O(N) where N is the length of nums
// Space Complexity: O(1), the space used by leftSum and sum
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
// @lc code=end

