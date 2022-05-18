/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
// Time Complexity: O(n) where n is the length of the given array nums since we iterate every element of nums exactly once
// Space Complexity: O(1) only currentMax and largestSum variables are used
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int currentMax = nums[0];
//         int largestSum = nums[0];
        
//         for (int i = 1; i < nums.length; i++) {
//             int num = nums[i];
//             currentMax = Math.max(num, currentMax + num);
//             largestSum = Math.max(largestSum, currentMax);
//         }
//         return largestSum;
//     }
// }


public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end

