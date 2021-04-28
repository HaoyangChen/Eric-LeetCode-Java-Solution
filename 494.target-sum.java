/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start

// Method 1: Brute force
// Time Complexity: O(2^n) - size of recursion tree will be 2^n. n refers to the size of nums array
// Space Complexity: O(n), the depth of the recursion tree can go up to n
class Solution {
    int result;
    public int findTargetSumWays(int[] nums, int target) {
        result = 0;
        helper(nums, target, 0);
        return result;
    }
    
    private void helper(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                result++;
            }
            return;
        }
        helper(nums, target + nums[index], index + 1);
        helper(nums, target - nums[index], index + 1);
    }
}

// public class Solution {
//     int count = 0;
//     public int findTargetSumWays(int[] nums, int S) {
//         int[][] memo = new int[nums.length][2001];
//         for (int[] row: memo)
//             Arrays.fill(row, Integer.MIN_VALUE);
//         return calculate(nums, 0, 0, S, memo);
//     }
//     public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
//         if (i == nums.length) {
//             if (sum == S)
//                 return 1;
//             else
//                 return 0;
//         } else {
//             if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
//                 return memo[i][sum + 1000];
//             }
//             int add = calculate(nums, i + 1, sum + nums[i], S, memo);
//             int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
//             memo[i][sum + 1000] = add + subtract;
//             return memo[i][sum + 1000];
//         }
//     }
// }
// @lc code=end

