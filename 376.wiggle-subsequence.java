/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

// @lc code=start

// Linear Dynamic Programming
// Time Complexity: O(n) - only one pass over the array length
// Space Complexity: O(n) - two arrays of the same length are used for dp
// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         int n = nums.length;
//         if (nums.length < 2) return n;
//         int[] up = new int[n];
//         int[] down = new int[n];
//         up[0] = down[0] = 1;
//         for (int i = 1; i < n; i++) {
//             if (nums[i] > nums[i - 1]) {
//                 up[i] = down[i - 1] + 1;
//                 down[i] = down[i - 1];
//             } else if (nums[i] < nums[i - 1]) {
//                 down[i] = up[i - 1] + 1;
//                 up[i] = up[i - 1];
//             } else {
//                 down[i] = down[i - 1];
//                 up[i] = up[i - 1];
//             }
//         }
//         return Math.max(down[n - 1], up[n - 1]);
//     }
// }


// Space Optimized DP
// Time Complexity: O(n) - Only one pass over the array length
// Space Complexity: O(1) - constant space is used
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }
}
// @lc code=end

