/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start

// Time Limit Exceeded Solution: Backtracking
// Time complexity : O(2^n) There are 2^n (upper bound) ways of jumping from the first position to the last, where nn is the length of array nums
// Space Complexity: O(n) - Recursion requires additional memory for the stack frame 

// public class Solution {
//     public boolean canJumpFromPosition(int position, int[] nums) {
//         if (position == nums.length - 1) {
//             return true;
//         }

//         int furthestJump = Math.min(position + nums[position], nums.length - 1);
//         for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//             if (canJumpFromPosition(nextPosition, nums)) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     public boolean canJump(int[] nums) {
//         return canJumpFromPosition(0, nums);
//     }
// }


// Method 2: Dynamic Programming Top-down
// Time Complexity: O(n^2) - for every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index
// Space Complexity: O(2n) = O(n). First n originates from recursion, second n comes from the usage of the memo table.
// enum Index {
//     GOOD, BAD, UNKNOWN
// }

// class Solution {
//     Index[] memo;
//     public boolean canJump(int[] nums) {
//         memo = new Index[nums.length];
//         for (int i = 0; i < memo.length; i++) {
//             memo[i] = Index.UNKNOWN;
//         }
//         memo[memo.length - 1] = Index.GOOD;
//         return canJumpFromPosition(0, nums);
//     }
    
//     private boolean canJumpFromPosition(int position, int[] nums) {
//         if (memo[position] != Index.UNKNOWN) {
//             return memo[position] == Index.GOOD ? true : false;
//         }
//         int furthestJump = Math.min(position + nums[position], nums.length - 1);
//         for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//             if (canJumpFromPosition(nextPosition, nums)) {
//                 memo[position] = Index.GOOD;
//                 return true;
//             }
//         }
//         memo[position] = Index.BAD;
//         return false;
//     }
// }


// Method 3: Greedy Algorithm
// Time Complexity: O(n) - where n is the length of the given array nums since we are doing a single pass
// Space Complexity: O(1) - no extra memory is used
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) return true;
            }
        }
        return false;
    }
}

// @lc code=end

