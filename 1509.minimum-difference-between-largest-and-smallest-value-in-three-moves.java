/*
 * @lc app=leetcode id=1509 lang=java
 *
 * [1509] Minimum Difference Between Largest and Smallest Value in Three Moves
 */

// @lc code=start

// We have 4 plans:
// kill 3 biggest elements
// kill 2 biggest elements + 1 smallest elements
// kill 1 biggest elements + 2 smallest elements
// kill 3 smallest elements
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length, res = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }
        return res;
    }
}
// @lc code=end

