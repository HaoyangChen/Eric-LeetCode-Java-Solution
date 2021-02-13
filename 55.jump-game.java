/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start

// Time Limit Exceeded Solution: Backtracking
// Time complexity : O(2^n) There are 2^n (upper bound) ways of jumping from the first position to the last, where nn is the length of array nums
// Space Complexity: O(n) - Recursion requires additional memory for the stack frame 
class Solution {
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) return true;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
}



// @lc code=end

