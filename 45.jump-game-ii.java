/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start

// Method: Greedy Algorithm
// Time Complexity: O(N) because there are N elements and we visit each element in the nums array only once.
// Space Complexity: O(1) because no additional data structure is used
class Solution {
    public int jump(int[] nums) {
        int totaljumps = 0, currentJumpEnd = 0, farthestJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthestJump = Math.max(farthestJump, i + nums[i]);
            if (i ==  currentJumpEnd) {
                totaljumps++;
                currentJumpEnd = farthestJump;
            }
        }
        return totaljumps;
    }
}
// @lc code=end

