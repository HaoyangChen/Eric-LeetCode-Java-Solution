/*
 * @lc app=leetcode id=1877 lang=java
 *
 * [1877] Minimize Maximum Pair Sum in Array
 */

// @lc code=start
class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n/2; i++) {
            result = Math.max(result, nums[i] + nums[n - i - 1]);
        }
        return result;
    }
}
// @lc code=end

