/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
import java.util.*;

// Method 1: Dynamic Programming
// Time Comlpexity: O(N^2)
// Space Complexity: O(N) - The only extra space used relative to the input size is the dp array, which is the same length as the given nums array
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, 1);
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
//             }
//         }
//         int result = 0;
//         for (int num: dp) {
//             result = Math.max(result, num);
//         }
//         return result;
//     }
// }


// Method 2: Binary Search
// Time Complexity: O(NlogN) binary search uses log(N) time
// Space Complexity: O(N) when the input is strictly increasing, the sub array will be the same size as the input
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int[] top = new int[nums.length];
//         int piles = 0;
//         for (int i = 0; i < nums.length; i++) {
//             int poker = nums[i];
//             int left = 0, right = piles;
//             while (left < right) {
//                 int mid = left + (right - left) / 2;
//                 if (top[mid] > poker) {
//                     right = mid;
//                 } else if (top[mid] < poker) {
//                     left = mid + 1;
//                 } else {
//                     right = mid;
//                 }
//             }
//             if (left == piles) piles++;
//             top[left] = poker;
//         }
//         return piles;
//     }
// }


class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
// @lc code=end

