/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start

// Method 1: Recursion with Memorization
// Time Complexity: O(N) since we process at most N recursive calls and making O(1) computation for each of thes calls to make two other recursive calls to find maximum and populate the cache based on the result
// Space Complexity: O(N) - recursion stack and cahce
// import java.util.*;
// class Solution {
//     private int[] memo;
    
//     public int rob(int[] nums) {
//         this.memo = new int[100];
//         Arrays.fill(this.memo, -1);
//         return this.robHelper(0, nums);
//     }
    
//     private int robHelper(int start, int[] nums) {
//         if (start >= nums.length) return 0;
//         if (this.memo[start] > -1) return this.memo[start];
//         int ans = Math.max(this.robHelper(start + 1, nums), this.robHelper(start + 2, nums) + nums[start]);
//         this.memo[start] = ans;
//         return ans;
//     }
// }


// Method 2: Dynamic Programming
// Time Complexity: O(N) since we have a loop from N - 2 to 0 and we can use the pre-calculated values of the dp table for calculating the current value in the table, which is a constant time operation
// Space Complexity: O(N) amount of space used by the table

// class Solution {
    
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;
//         int[] maxRobbedAmount = new int[nums.length + 1];
//         maxRobbedAmount[n] = 0;
//         maxRobbedAmount[n - 1] = nums[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
//         }
//         return maxRobbedAmount[0];
        
//     }
// }

// Continued Another Way of Implementing DP
// Time Complexity and Space Complexity both O(N)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }
}

// Optimized DP
// Time Complexity: O(N) since we have a loop from n - 2 to 0, and we use the precalculated values from the dp table to calculate the current value in the table
// Space Complexity: O(1) since we are not using a table to store the values and instead we are using two variables to calculate the result 
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 0) return 0;
//         int robNextPlusOne = 0;
//         int robNext = nums[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             int current = Math.max(robNextPlusOne + nums[i], robNext);
//             robNextPlusOne = robNext;
//             robNext = current;
//         }
//         return robNext;
//     }
// }
// @lc code=end

