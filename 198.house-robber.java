/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start

// Recursion with Memorization
// Time Complexity: O(N) since we process at most N recursive calls and making O(1) computation for each of thes calls to make two other recursive calls to find maximum and populate the cache based on the result
// Space Complexity: O(N) - recursion stack and cahce
import java.util.*;
class Solution {
    private int[] memo;
    
    public int rob(int[] nums) {
        this.memo = new int[100];
        Arrays.fill(this.memo, -1);
        return this.robHelper(0, nums);
    }
    
    private int robHelper(int start, int[] nums) {
        if (start >= nums.length) return 0;
        if (this.memo[start] > -1) return this.memo[start];
        int ans = Math.max(this.robHelper(start + 1, nums), this.robHelper(start + 2, nums) + nums[start]);
        this.memo[start] = ans;
        return ans;
    }
}
// @lc code=end

